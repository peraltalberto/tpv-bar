/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.gui;

import java.awt.Color;
import java.awt.Component;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        try{
        this.setHorizontalAlignment(SwingConstants.CENTER);
        
        //System.out.println(value.getClass());
        NumberFormat nf = new DecimalFormat("0.00");

        if (value.getClass().equals(Double.class)) {
            value = nf.format(value);
           // this.setHorizontalAlignment(SwingConstants.RIGHT);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        if (value.getClass().equals(Date.class)) {
            value = sdf.format(value);
           // this.setHorizontalAlignment(SwingConstants.RIGHT);
        }
         if (value.getClass().equals(Timestamp.class)) {
            value = sdf.format(value);
           // this.setHorizontalAlignment(SwingConstants.RIGHT);
        }
        if (table.getColumnName(column).equals("Visible")) {

            if ((Boolean) value) {
                value = "Visible";
            } else {
                value = "Oculto";
            }
        }
        if (table.getColumnName(column).equals("Codigo")) {
            table.getColumnModel().getColumn(column).setMaxWidth(60);
            table.getColumnModel().getColumn(column).setMinWidth(60);
            table.getTableHeader().getColumnModel().getColumn(column).setMaxWidth(60);
            table.getTableHeader().getColumnModel().getColumn(column).setMinWidth(60);
        }
        this.setValue(value);


        this.setFont(new java.awt.Font("Arial", 0, 18));
        table.setRowHeight(25);
        if (isSelected) {
            this.setBackground(new Color(255, 204, 153));
               this.setForeground(new Color(105, 102, 102));
        } else {
            if (row % 2 == 0) {
                this.setBackground(new Color(255, 255, 255));
                this.setForeground(new Color(227, 128, 22));
            } else {
                this.setBackground(new Color(221, 221, 221));
                this.setForeground(new Color(105, 102, 102));
            }
            
        }
        }catch(Exception e){
        //    e.printStackTrace();
        }
        return this;
    }
}
