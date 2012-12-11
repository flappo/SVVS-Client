/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svvsclient.presentation.personListeners;

import business.ControllerFactoryRemote;
import business.controller.person.edit.IPersonEdit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import svvsclient.presentation.forms.CreatePersonDialog;
import svvsclient.presentation.tableModels.PersonTableModel;

/**
 *
 * @author Kno
 */
public class EditPersonListener implements ActionListener {

    JTable _table;
    ControllerFactoryRemote factory;

    public EditPersonListener(JTable table, ControllerFactoryRemote factory) {
        _table = table;
        this.factory = factory;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (_table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Bitte wählen Sie erst eine Person aus, die sie bearbeiten möchten.");
        } else {
            int index = _table.convertRowIndexToModel(_table.getSelectedRow());
            PersonTableModel personModel = (PersonTableModel) _table.getModel();

            try {
                IPersonEdit personEdit = factory.getPersonEdit();//factory.loadPersonEditController();
                CreatePersonDialog dialog = new CreatePersonDialog(null, true, personEdit, personModel.getPersonDTO(index));
                dialog.setVisible(true);

                if (dialog.getPerson() != null) {
                    personModel.updatePersonDTO(index, dialog.getPerson());
                    personModel.fireTableDataChanged();
                }

            } catch (RemoteException ex) {
                Logger.getLogger(EditPersonListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
