/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.gui.renderes;

import es.tpv_bar.persistencia.pojos.Bloqueubicacion;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author aperalta
 */
public class ComboBoxImgRenderer extends JLabel implements ListCellRenderer {

    ArrayList<Bloqueubicacion> bloques;
    Integer[] imageIndex ;

    public ComboBoxImgRenderer(ArrayList<Bloqueubicacion> bloques) {
        setOpaque(true);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
        this.bloques = bloques;
        this.imageIndex =  new Integer[bloques.size()];
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//Get the selected index. (The index param isn't
//always valid, so just use the value.)
        try{
            System.out.println(value);
        int selectedIndex = ((Integer) value).intValue();

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

//Set the icon and text.
        ImageIcon icon =new javax.swing.ImageIcon( bloques.get(index).getImagen());
        String language = bloques.get(index).toString();

        setIcon(icon);
        if (icon != null) {
            setText(language);
            setFont(list.getFont());
        }
        }catch(Exception e){
        e.printStackTrace();
        }
        return this;
    }
}
