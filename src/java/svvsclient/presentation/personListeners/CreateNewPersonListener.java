/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svvsclient.presentation.personListeners;

import business.ControllerFactoryRemote;
import business.controller.person.create.IPersonCreation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import javax.swing.JTable;
import svvsclient.presentation.forms.CreatePersonDialog;
import svvsclient.presentation.tableModels.PersonTableModel;

/**
 *
 * @author Kno
 */
public class CreateNewPersonListener implements ActionListener {

    JTable table;
    ControllerFactoryRemote controllerfactory;

    public CreateNewPersonListener(JTable table, ControllerFactoryRemote factory) {
        this.controllerfactory = factory;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            IPersonCreation createController;
            createController = controllerfactory.getPersonCreation();//controllerfactory.loadPersonCreateController();
            CreatePersonDialog dialog = new CreatePersonDialog(null, true, createController);
            dialog.setVisible(true);
            
            if(dialog.getPerson() != null) {
                PersonTableModel personModel = (PersonTableModel) table.getModel();
                personModel.addPerson(dialog.getPerson());
                personModel.fireTableDataChanged();
            }
        } catch (RemoteException ex) {
            System.out.println("Coud not load controller");
        }

    }
}
