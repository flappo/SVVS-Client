/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svvsclient.presentation.tableModels;

import data.DTOs.IDTO;
import java.awt.Color;
import java.awt.Component;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author uubu
 */
public class DTORenderer extends JLabel implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        try {
            if (value instanceof String) {
                setText((String) value);
            } else if(value == null){
                setText("");
            }else{
                setText(((IDTO) value).getValues());
                setOpaque(true);
                setBackground(isSelected ? Color.blue : Color.white);
                setForeground(isSelected ? Color.white : Color.black);
            }
            
        } catch (RemoteException ex) {
            Logger.getLogger(DTORenderer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }
}
