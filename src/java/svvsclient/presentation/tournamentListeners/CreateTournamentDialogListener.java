/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svvsclient.presentation.tournamentListeners;

import business.controller.tournament.Create.ITournamentCreation;
import data.DTOs.ITournamentDTO;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import svvsclient.presentation.forms.CreateTournamentDialog;

/**
 *
 * @author Kno
 */
public class CreateTournamentDialogListener implements ActionListener {

    private CreateTournamentDialog dialog;
    private ITournamentCreation tournament;

    public CreateTournamentDialogListener(ITournamentCreation tournament, CreateTournamentDialog dialog) {
        this.tournament = tournament;
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String error = isValide();
            if (error.equals("")) {
                try {
                    ITournamentDTO tournamentDTO = tournament.CreateTournament(dialog.getName(), dialog.getPlace(), dialog.getDate(), 
                            new BigDecimal(dialog.getFee()), dialog.getSports(), dialog.getTeams());
                    
                    
                    JOptionPane.showMessageDialog(null, "Tournament wurde erfolgreich erstellt.");
                    
                    dialog.setSavedTournament(tournamentDTO);
                    dialog.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Fehler ohne Sinn ist aufgetreten.");
                    dialog.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Tournament konnte nicht erstellt werden. \n Bitte korrigieren Sie folgende Punkte \n \n " + error);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(CreateTournamentDialogListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String isValide() throws RemoteException {
        String error = "";


        if (dialog.getName().equals("")) {
            error += "Name \n";
        }
        if (dialog.getPlace().equals("")) {
            error += "Ort \n";
        }
        try {
            new BigDecimal(dialog.getFee());
        } catch (Exception ex) {
            error += "Gebühr + \n";
        }
        if (dialog.getSports().isEmpty()) {
            error += "Sportart \n";
        }
        if (dialog.getTeams().equals("")) {
            error += "Teams \n";
        }

        return error;
    }
}
