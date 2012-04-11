// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.persistencia.modelos;

import es.tpv_bar.persistencia.AbstractModel;
import es.tpv_bar.persistencia.pojos.Ubicacion;
import java.util.ArrayList;


/**
 *
 * @author aperalta
 */
public class UbicacionModel extends AbstractModel {
    
    public UbicacionModel() {
        super(Ubicacion.class);
    }
    
    @Override
    public ArrayList<Ubicacion> getLista() {
        this.cargarLista();
        return (ArrayList<Ubicacion>) super.getLista();
    }
}
