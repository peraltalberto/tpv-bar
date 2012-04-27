/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.gui.botones;

import es.tpv_bar.persistencia.pojos.Categoria;
import javax.swing.JButton;

/**
 *
 * @author aperalta
 */
public class BTCategoria extends JButton {
    
   public BTCategoria(){
   
   }
   
   public BTCategoria(Categoria categoria){
       this.categoria = categoria;
       this.setFont(new java.awt.Font("Arial", 1, 16));
       this.setText(this.categoria.getNombre());
   }
   
   Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
   
}
