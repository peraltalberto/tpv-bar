/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.gui.botones;

import es.tpv_bar.persistencia.pojos.Productos;
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
       this.setText(this.producto.getNombre());
      this.setFont(new java.awt.Font("Arial", 1, 16));
   }
   
   Productos producto;

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }
   
}
