/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.gui.botones;


import es.tpv_bar.persistencia.pojos.Ubicacion;
import javax.swing.JButton;

/**
 *
 * @author aperalta
 */
public class BTMesa extends JButton {
    
   public BTMesa(){
       super();
   }
   
   public BTMesa(Ubicacion ubicacion){
       super();
       this.ubicacion = ubicacion;
       this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/addTaza.png")));
       this.setText(this.ubicacion.getNombre());
       this.setFont(new java.awt.Font("Arial", 1, 16));
   }
   
   Ubicacion ubicacion;

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

   
   
}
