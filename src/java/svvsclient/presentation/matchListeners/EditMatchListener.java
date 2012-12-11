/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svvsclient.presentation.matchListeners;

import business.controller.tournament.edit.ITournamentEdit;
import data.DTOs.ITournamentDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import svvsclient.presentation.forms.CreateMatchDialog;
import svvsclient.presentation.tableModels.MatchTableModel;


/**
 *
 * @author Michael
 */
public class EditMatchListener implements ActionListener {

    JTable table;
    ITournamentEdit editController;
    ITournamentDTO tournament;

    public EditMatchListener(JTable table, ITournamentEdit editController, ITournamentDTO tournament) {
        this.table = table;
        this.editController = editController;
        this.tournament = tournament;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Bitte w�hlen Sie erst eine Person aus, die sie bearbeiten m�chten.");
        } else {
            try {
                int index = table.convertRowIndexToModel(table.getSelectedRow());
                MatchTableModel matchModel = (MatchTableModel) table.getModel();

                CreateMatchDialog dialog = new CreateMatchDialog(null, true, editController, tournament, matchModel.getMatchDTO(index));
                dialog.setVisible(true);

                if(dialog.getMatch() != null) {
                    matchModel.updateMatchDTO(index, dialog.getMatch());
                    matchModel.fireTableDataChanged();
                }
            } catch (RemoteException ex) {
                Logger.getLogger(EditMatchListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
