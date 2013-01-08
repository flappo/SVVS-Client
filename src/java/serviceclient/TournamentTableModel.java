/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceclient;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Michael
 */
public class TournamentTableModel extends DefaultTableModel {

    private List<String> tournaments;
    private String[] colNames = {"Name", "Ort", "Datum"};

    public TournamentTableModel(List<String> tournaments) {
        this.tournaments = tournaments;
    }

    @Override
    public int getRowCount() {
        return (tournaments == null) ? 0 : tournaments.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        String tournament = tournaments.get(row);

        switch (column) {
            case 0:
                return tournament.split(";")[1];
            case 1:
                return tournament.split(";")[2];
            case 2:
                return tournament.split(";")[3];
            default:
                return null;
        }
    }

    public List<String> getTournaments() {
        return tournaments;
    }

    public void setTournaments(List<String> tournaments) {
        this.tournaments = tournaments;
    }

    public void addTournament(String tournament) {
        this.tournaments.add(tournament);
    }

    public void updateTournamentDTO(int index, String tournament) {
        this.tournaments.set(index, tournament);
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public String getTournamentDTO(int index) {
        return tournaments.get(index);
    }
}
