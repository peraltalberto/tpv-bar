// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.persistencia.modelos;

import es.tpv_bar.persistencia.AbstractModel;
import es.tpv_bar.persistencia.pojos.Servicios;
import java.util.ArrayList;


/**
 *
 * @author aperalta
 */
public class ServiciosModel extends AbstractModel {
    
    public ServiciosModel() {
        super(Servicios.class);
    }
    
    @Override
    public ArrayList<Servicios> getLista() {
        this.cargarLista();
        return (ArrayList<Servicios>) super.getLista();
    }
}
