/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar;

import es.tpv_bar.persistencia.modelos.ConfiguracionModel;

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
    
    
public static String getModKey(){
    ConfiguracionModel conf = new ConfiguracionModel();
    return conf.getValue("fechaKey");
} 
public static void setModKey(Long fecha){
    ConfiguracionModel conf = new ConfiguracionModel();
     conf.setValue("fechaKey",fecha.toString());
} 
}
