// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.persistencia.modelos;

import es.tpv_bar.persistencia.AbstractModel;
import es.tpv_bar.persistencia.pojos.Cabezera;
import es.tpv_bar.persistencia.pojos.Linea;
import es.tpv_bar.persistencia.pojos.Ubicacion;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


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
    
     public ArrayList<Cabezera> getTicketsSC(){
         ArrayList<Cabezera> result = null;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        result = (ArrayList<Cabezera>) session.createCriteria(Cabezera.class)
                .add(Restrictions.eq("estado", 0))
                .list();
        return result;
     }
}
