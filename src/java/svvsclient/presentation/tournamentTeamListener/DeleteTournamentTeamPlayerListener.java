/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svvsclient.presentation.tournamentTeamListener;

import business.controller.team.playerToTeam.IPlayerToTeam;
import business.controller.touramentTeam.ITournamentTeamController;
import data.DTOs.ISportsmanDTO;
import data.DTOs.ISportsmanTrainingTeamDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import svvsclient.presentation.forms.AssignPlayerTournamentTeamDialog;
import svvsclient.presentation.tableModels.SportsManTableModel;
import svvsclient.presentation.trainingTeamListener.DeletePlayerListener;

/**
 *
 * @author Michael
 */
public class DeleteTournamentTeamPlayerListener implements ActionListener {

    JTable table;
    ITournamentTeamController assignController;
    AssignPlayerTournamentTeamDialog dialog;

    public DeleteTournamentTeamPlayerListener(JTable table, ITournamentTeamController assignController, AssignPlayerTournamentTeamDialog dialog) {
        this.table = table;
        this.assignController = assignController;
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Bitte w�hlen Sie erst einen Spieler aus, den Sie l�schen m�chten.");
        } else {
            int index = table.convertRowIndexToModel(table.getSelectedRow());
            SportsManTableModel sportsmanModel = (SportsManTableModel) table.getModel();
            ISportsmanDTO deletingSportsman = sportsmanModel.getSportsmanDTO(index);

            try {
                assignController.removePlayer(dialog.getTournamentTeam().getTournament(), dialog.getTournamentTeam().getTeam(), 
                        deletingSportsman);
                sportsmanModel.removeSportsman(deletingSportsman);
                sportsmanModel.fireTableDataChanged();
                dialog.addSportsmanToComboBox(deletingSportsman);
            } catch (RemoteException ex) {
                Logger.getLogger(DeletePlayerListener.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}