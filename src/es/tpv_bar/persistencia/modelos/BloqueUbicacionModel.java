// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.persistencia.modelos;

import es.tpv_bar.persistencia.AbstractModel;
import es.tpv_bar.persistencia.pojos.BloqueUbicacion;
import java.util.ArrayList;


/**
 *
 * @author aperalta
 */
public class BloqueUbicacionModel extends AbstractModel {
    
    public BloqueUbicacionModel() {
        super(BloqueUbicacion.class);
    }
    
    @Override
    public ArrayList<BloqueUbicacion> getLista() {
        this.cargarLista();
        return (ArrayList<BloqueUbicacion>) super.getLista();
    }
}
