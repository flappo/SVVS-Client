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
import javax.swing.JTable;
import svvsclient.presentation.forms.CreateMatchDialog;
import svvsclient.presentation.tableModels.MatchTableModel;

/**
 *
 * @author Michael
 */
public class CreateNewMatchListener implements ActionListener {

    private ITournamentEdit editController;
    private ITournamentDTO tournament;
    private JTable matches;

    public CreateNewMatchListener(JTable matchTable, ITournamentEdit editController, ITournamentDTO tournament) {
        this.editController = editController;
        this.tournament = tournament;
        this.matches = matchTable;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            CreateMatchDialog dialog = new CreateMatchDialog(null, true, editController, tournament);
            dialog.setVisible(true);
            
            if(dialog.getMatch() != null) {
                MatchTableModel model = (MatchTableModel) matches.getModel();
                model.addMatch(dialog.getMatch());
                model.fireTableDataChanged();
            }
        } catch (RemoteException ex) {
            Logger.getLogger(CreateNewMatchListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
