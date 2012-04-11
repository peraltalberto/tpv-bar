// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.persistencia.modelos;

import es.tpv_bar.persistencia.AbstractModel;
import es.tpv_bar.persistencia.pojos.Productos;
import java.util.ArrayList;


/**
 *
 * @author aperalta
 */
public class ProductosModel extends AbstractModel {
    
    public ProductosModel() {
        super(Productos.class);
    }
    
    @Override
    public ArrayList<Productos> getLista() {
        this.cargarLista();
        return (ArrayList<Productos>) super.getLista();
    }
}
