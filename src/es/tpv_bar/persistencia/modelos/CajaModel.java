// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.persistencia.modelos;

import es.tpv_bar.persistencia.AbstractModel;
import es.tpv_bar.persistencia.pojos.Caja;
import java.util.ArrayList;


/**
 *
 * @author aperalta
 */
public class CajaModel extends AbstractModel {
    
    public CajaModel() {
        super(Caja.class);
    }
    
    @Override
    public ArrayList<Caja> getLista() {
        this.cargarLista();
        return (ArrayList<Caja>) super.getLista();
    }
}
