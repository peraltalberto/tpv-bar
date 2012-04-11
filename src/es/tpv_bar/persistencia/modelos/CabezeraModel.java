// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.persistencia.modelos;

import es.tpv_bar.persistencia.AbstractModel;
import es.tpv_bar.persistencia.pojos.Cabezera;
import java.util.ArrayList;


/**
 *
 * @author aperalta
 */
public class CabezeraModel extends AbstractModel {
    
    public CabezeraModel() {
        super(Cabezera.class);
    }
    
    @Override
    public ArrayList<Cabezera> getLista() {
        this.cargarLista();
        return (ArrayList<Cabezera>) super.getLista();
    }
}
