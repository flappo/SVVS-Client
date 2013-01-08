/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceclient.business.webservice;

import business.webservice.SVVSService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import serviceclient.MatchDialog;
import serviceclient.TournamentTableModel;

/**
 *
 * @author Michael
 */
public class ShowTournamentListener implements ActionListener {

    JTable _table;
    SVVSService _service;

    public ShowTournamentListener(JTable table, SVVSService service) {
        _table = table;
        _service = service;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (_table.getSelectedRow() != -1) {
            int index = _table.convertRowIndexToModel(_table.getSelectedRow());
            TournamentTableModel tournamentModel = (TournamentTableModel) _table.getModel();

            String tournament = tournamentModel.getTournamentDTO(index);

            if (!_service.isFinished(index)) {
                JOptionPane.showMessageDialog(null, "Achtung: Dieser Wettkampf ist noch nicht beendet!");

            }

            new MatchDialog(null, true,
                    _service.loadTournament(Integer.parseInt(tournament.split(";")[0]))).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Bitte wählen Sie erst einen Wettbewerb aus, die sie anzeigen möchten.");
        }

    }
}
