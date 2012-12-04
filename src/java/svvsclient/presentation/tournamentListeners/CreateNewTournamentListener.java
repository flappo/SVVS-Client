/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svvsclient.presentation.tournamentListeners;


import business.ControllerFactory3Remote;
import business.controller.tournament.Create.ITournamentCreation;
import data.DTOs.IRoleDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import svvsclient.presentation.forms.CreateTournamentDialog;
import svvsclient.presentation.tableModels.TournamentTableModel;


/**
 *
 * @author Michael
 */
public class CreateNewTournamentListener implements ActionListener {

    JTable table;
    ControllerFactory3Remote controllerfactory;
    List<IRoleDTO> managerRols;
    
    public CreateNewTournamentListener(JTable table, ControllerFactory3Remote controller, List<IRoleDTO> managerRols) {
        this.table = table;
        this.controllerfactory = controller;
        this.managerRols = managerRols;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ITournamentCreation create = null;
        try {
            create = controllerfactory.getTournamentCreation();//controllerfactory.loadTournamentCreateController();
            CreateTournamentDialog dialog = new CreateTournamentDialog(null, true, create, managerRols);
            dialog.setVisible(true);
            
            if(dialog.getSavedTournament() != null) {
                TournamentTableModel tableModel = (TournamentTableModel) table.getModel();
                tableModel.addTournament(dialog.getSavedTournament());
                tableModel.fireTableDataChanged();
            }
            
        } catch (RemoteException ex) {
            Logger.getLogger(CreateNewTournamentListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       ((TournamentTableModel) table.getModel()).fireTableDataChanged();

    }
}
