// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.persistencia.modelos;

import es.tpv_bar.persistencia.AbstractModel;
import es.tpv_bar.persistencia.pojos.Arqueos;
import java.util.ArrayList;


/**
 *
 * @author aperalta
 */
public class ArqueoModel extends AbstractModel {
    
    public ArqueoModel() {
        super(Arqueos.class);
    }
    
    @Override
    public ArrayList<Arqueos> getLista() {
        this.cargarLista();
        return (ArrayList<Arqueos>) super.getLista();
    }
}
