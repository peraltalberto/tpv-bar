// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.persistencia.modelos;

import es.tpv_bar.persistencia.AbstractModel;
import es.tpv_bar.persistencia.pojos.Configuracion;
import java.util.ArrayList;


/**
 *
 * @author aperalta
 */
public class ConfiguracionModel extends AbstractModel {
    
    public ConfiguracionModel() {
        super(Configuracion.class);
    }
    
    @Override
    public ArrayList<Configuracion> getLista() {
        this.cargarLista();
        return (ArrayList<Configuracion>) super.getLista();
    }
}
