/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svvsclient.presentation.trainingTeamListener;

import business.controller.team.playerToTeam.IPlayerToTeam;
import data.DTOs.ISportsmanTrainingTeamDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import svvsclient.presentation.forms.AssignPlayerTrainingTeamDialog;
import svvsclient.presentation.tableModels.SportsManTrainingTeamTableModel;


/**
 *
 * @author Michael
 */
public class DeletePlayerListener implements ActionListener {

    JTable table;
    IPlayerToTeam assignController;
    AssignPlayerTrainingTeamDialog dialog;

    public DeletePlayerListener(JTable table, IPlayerToTeam assignController, AssignPlayerTrainingTeamDialog dialog) {
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
            SportsManTrainingTeamTableModel sportsmanModel = (SportsManTrainingTeamTableModel) table.getModel();
            ISportsmanTrainingTeamDTO deletingSportsman = sportsmanModel.getSportsmanDTO(index);

            try {
                assignController.RemovePlayerFromTeam(deletingSportsman);
                sportsmanModel.removeSportsman(deletingSportsman);
                sportsmanModel.fireTableDataChanged();
            } catch (RemoteException ex) {
                Logger.getLogger(DeletePlayerListener.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}