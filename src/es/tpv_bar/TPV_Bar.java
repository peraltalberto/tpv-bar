/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jgoodies.looks.plastic.theme.DesertBlue;
import com.jgoodies.looks.plastic.theme.ExperienceBlue;
import com.jgoodies.looks.plastic.theme.LightGray;
import es.tpv_bar.persistencia.modelos.ConfiguracionModel;
import javax.swing.UIManager;

/**
 *
 * @author aperalta
 */
public class TPV_Bar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       PlasticLookAndFeel.setPlasticTheme(new LightGray());
   try {
      UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
         UIManager.put("ScrollBar.is3DEnabled", Boolean.FALSE);
   
   
   } catch (Exception e) {}
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
