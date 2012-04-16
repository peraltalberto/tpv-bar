/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.gui.botones;

import es.tpv_bar.persistencia.pojos.Productos;
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
   }
   
   Productos producto;

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }
   
}
