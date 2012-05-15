// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.persistencia.modelos;

import es.tpv_bar.persistencia.AbstractModel;
import es.tpv_bar.persistencia.pojos.Atipicas;
import es.tpv_bar.persistencia.pojos.Bloqueubicacion;
import es.tpv_bar.persistencia.pojos.Productos;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


/**
 *
 * @author aperalta
 */
public class AtipicasModel extends AbstractModel {
    
    public AtipicasModel() {
        super(Atipicas.class);
    }
    
    @Override
    public ArrayList<Atipicas> getLista() {
        this.cargarLista();
        return (ArrayList<Atipicas>) super.getLista();
    }
    
    public Atipicas getAtipica(Bloqueubicacion bl,Productos prod){
        Session ses = factory.getCurrentSession();
        Transaction tx = ses.beginTransaction();
        Atipicas resul = (Atipicas)ses.createCriteria(Atipicas.class)
                .add(Restrictions.eq("bloqueubicacion",bl))
                .add(Restrictions.eq("productos", prod)).setMaxResults(1)
                .uniqueResult();
        return resul;
    }
}
