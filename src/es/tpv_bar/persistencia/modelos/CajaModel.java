// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.persistencia.modelos;

import es.tpv_bar.persistencia.AbstractModel;
import es.tpv_bar.persistencia.pojos.Caja;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;


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
    
    public Double getSaldo(){
        try{
        Session ses = factory.getCurrentSession();
        Transaction tx = ses.beginTransaction();
        Integer id= (Integer)ses.createCriteria(Caja.class)
                .setProjection(Projections.max("idCaja")).uniqueResult();
        System.out.println(id);
        Caja c=  (Caja) ses.load(Caja.class,id);
        return c.getSaldo();
        }catch(Exception e){
        return 0.0;
        }
    }
}
