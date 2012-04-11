// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.persistencia.modelos;

import es.tpv_bar.persistencia.AbstractModel;
import es.tpv_bar.persistencia.pojos.Categoria;
import java.util.ArrayList;


/**
 *
 * @author aperalta
 */
public class CategoriaModel extends AbstractModel {
    
    public CategoriaModel() {
        super(Categoria.class);
    }
    
    @Override
    public ArrayList<Categoria> getLista() {
        this.cargarLista();
        return (ArrayList<Categoria>) super.getLista();
    }
}
