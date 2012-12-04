/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svvsclient.presentation.trainingTeamListener;


import business.ControllerFactory2Remote;
import business.controller.team.playerToTeam.IPlayerToTeam;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import svvsclient.presentation.forms.AssignPlayerTrainingTeamDialog;
import svvsclient.presentation.tableModels.TrainingTeamTableModel;


/**
 *
 * @author Michael
 */
public class EditTeamListener implements ActionListener {

    private ControllerFactory2Remote factory;
    private JTable table;

    public EditTeamListener(JTable table, ControllerFactory2Remote controllerFactory) {
        this.factory = controllerFactory;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Bitte wählen Sie erst ein Team aus, dass sie bearbeiten möchten.");
        } else {
            int index = table.convertRowIndexToModel(table.getSelectedRow());
            TrainingTeamTableModel ttModel = (TrainingTeamTableModel) table.getModel();

            try {
                IPlayerToTeam playerAssignController = factory.getPlayerToTeam();//factory.loadPlayerToTeamController();
                AssignPlayerTrainingTeamDialog dialog = new AssignPlayerTrainingTeamDialog(null, true, playerAssignController, ttModel.getTrainingTeamDTO(index));
                dialog.setVisible(true);

                if (dialog.getTrainingTeam() != null) {
                    ttModel.updateTrainingTeamDTO(index, dialog.getTrainingTeam());
                    ttModel.fireTableDataChanged();
                }

            } catch (RemoteException ex) {
                Logger.getLogger(EditTeamListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
