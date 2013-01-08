/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceclient;

import serviceclient.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Michael
 */
public class MatchTableModel extends DefaultTableModel {

    private List<String> matchs;
    private String[] colNames = {"Team 1", "Team 2", "Ergebnis"};

    public MatchTableModel(List<String> matchs) {
        this.matchs = matchs;
    }

    @Override
    public int getRowCount() {
        return (matchs == null) ? 0 : matchs.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        String match = matchs.get(row);

        switch (column) {
            case 0:
                return match.split(";")[0];
            case 1:
                return match.split(";")[1];
            case 2:
                return match.split(";")[2] + " - " + match.split(";")[3];
            default:
                return null;
        }
    }

    public List<String> getTournaments() {
        return matchs;
    }

    public void setTournaments(List<String> matchs) {
        this.matchs = matchs;
    }

    public void addTournament(String match) {
        this.matchs.add(match);
    }

    public void updateTournamentDTO(int index, String match) {
        this.matchs.set(index, match);
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
        return matchs.get(index);
    }
}
