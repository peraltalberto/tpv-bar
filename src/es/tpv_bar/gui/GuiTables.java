/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.gui;

import java.awt.Color;
import java.awt.Component;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author aperalta
 */
public class GuiTables extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        this.setHorizontalAlignment(SwingConstants.CENTER);
        
        //System.out.println(table.getColumnName(column));
        NumberFormat nf = new DecimalFormat("0.00");

        if (value.getClass().equals(Double.class)) {
            value = nf.format(value);
           // this.setHorizontalAlignment(SwingConstants.RIGHT);
        }
        if (table.getColumnName(column).equals("Visible")) {

            if ((Boolean) value) {
                value = "Visible";
            } else {
                value = "Oculto";
            }
        }

        this.setValue(value);



        if (isSelected) {
            this.setForeground(Color.white);
            this.setBackground(Color.BLUE);
        } else {
            if (row % 2 == 0) {
                this.setBackground(Color.WHITE);
            } else {
                this.setBackground(new Color(167, 223, 241));
            }
            this.setForeground(Color.BLACK);
        }

        return this;
    }
}
