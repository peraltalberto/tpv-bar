// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.persistencia.modelos;

import es.tpv_bar.persistencia.AbstractModel;
import es.tpv_bar.persistencia.pojos.Bloqueubicacion;
import java.util.ArrayList;


/**
 *
 * @author aperalta
 */
public class BloqueUbicacionModel extends AbstractModel {
    
    public BloqueUbicacionModel() {
        super(Bloqueubicacion.class);
    }
    
    @Override
    public ArrayList<Bloqueubicacion> getLista() {
        this.cargarLista();
        return (ArrayList<Bloqueubicacion>) super.getLista();
    }
}
