/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar;

/**
 *
 * @author aperalta
 */
public class TPV_Bar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{ 
javax.swing.UIManager.setLookAndFeel( 
javax.swing.UIManager.getSystemLookAndFeelClassName()); 
}catch ( Exception e ) { } 
        new VentanaPrincipal().setVisible(true);
    }
}
