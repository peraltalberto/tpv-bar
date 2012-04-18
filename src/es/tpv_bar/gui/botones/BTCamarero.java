/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.gui.botones;


import es.tpv_bar.persistencia.pojos.Camarero;
import es.tpv_bar.persistencia.pojos.Ubicacion;
import javax.swing.JButton;

/**
 *
 * @author aperalta
 */
public class BTCamarero extends JButton {
    
   public BTCamarero(){
       super();
   }
   
   public BTCamarero(Camarero camarero){
       super();
       this.camarero = camarero;
       this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/IconCamarero.png")));
       this.setText(this.camarero.getNombre());
   }
   
   Camarero camarero;

    public Camarero getUbicacion() {
        return camarero;
    }

    public void setUbicacion(Camarero camarero) {
        this.camarero = camarero;
    }

   
   
}
