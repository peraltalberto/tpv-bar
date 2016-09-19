/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.gui.botones;

import es.tpv_bar.persistencia.pojos.Productos;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author aperalta
 */
public class BTProducto extends JButton {
    
   public BTProducto(){
   
   }
   
   public BTProducto(Productos producto){
       this.producto = producto;
       this.setFont(new java.awt.Font("Arial", 1, 16));
       try{
       if(this.producto.getTxtImg() == 1){
           System.out.println(this.producto.getPathImg());
           this.setIcon(new javax.swing.ImageIcon(this.producto.getPathImg()));
            this.setFont(new java.awt.Font("Arial", 1, 10));
             this.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        this.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
       }
       }catch(Exception e){
           this.setFont(new java.awt.Font("Arial", 1, 16));
           e.printStackTrace();
       }
       this.setText(this.producto.getTextoBt());
       try{
       this.setBackground(new Color(producto.getColor()));
       }catch(NullPointerException e){}
       
      
   }
   
   Productos producto;

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }
   
}
