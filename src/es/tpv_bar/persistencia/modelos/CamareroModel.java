// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.persistencia.modelos;

import es.tpv_bar.persistencia.AbstractModel;
import es.tpv_bar.persistencia.pojos.Camarero;
import java.util.ArrayList;


/**
 *
 * @author aperalta
 */
public class CamareroModel extends AbstractModel {
    
    public CamareroModel() {
        super(Camarero.class);
    }
    
    @Override
    public ArrayList<Camarero> getLista() {
        this.cargarLista();
        return (ArrayList<Camarero>) super.getLista();
    }
}
