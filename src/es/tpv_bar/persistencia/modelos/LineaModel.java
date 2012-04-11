// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.persistencia.modelos;

import es.tpv_bar.persistencia.AbstractModel;
import es.tpv_bar.persistencia.pojos.Linea;
import java.util.ArrayList;


/**
 *
 * @author aperalta
 */
public class LineaModel extends AbstractModel {
    
    public LineaModel() {
        super(Linea.class);
    }
    
    @Override
    public ArrayList<Linea> getLista() {
        this.cargarLista();
        return (ArrayList<Linea>) super.getLista();
    }
}
