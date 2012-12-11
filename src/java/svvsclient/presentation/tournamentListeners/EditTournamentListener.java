/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svvsclient.presentation.tournamentListeners;


import business.ControllerFactory3Remote;
import business.controller.tournament.edit.ITournamentEdit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import svvsclient.presentation.forms.EditTournamentDialog;
import svvsclient.presentation.tableModels.TournamentTableModel;


/**
 *
 * @author Michael
 */
public class EditTournamentListener implements ActionListener {

    JTable _table;
    ControllerFactory3Remote factory;

    public EditTournamentListener(JTable table, ControllerFactory3Remote factory) {
        _table = table;
        this.factory = factory;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (_table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Bitte wählen Sie erst einen Wettbewerb aus, die sie bearbeiten möchten.");
        } else {
            int index = _table.convertRowIndexToModel(_table.getSelectedRow());
            TournamentTableModel tournamentModel = (TournamentTableModel) _table.getModel();
            
            try {
                
                ITournamentEdit edit = factory.getTournamentEdit();//factory.loadTournamentEditController();
                EditTournamentDialog dialog = new EditTournamentDialog(null, true, tournamentModel.getTournamentDTO(index), edit);
                dialog.setVisible(true);

                if(dialog.getTournament() != null) {
                    tournamentModel.updateTournamentDTO(index, dialog.getTournament());
                    tournamentModel.fireTableDataChanged();
                }
                
            } catch (RemoteException ex) {
                Logger.getLogger(EditTournamentListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
