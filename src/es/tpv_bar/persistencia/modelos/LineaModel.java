// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.persistencia.modelos;

import es.tpv_bar.persistencia.AbstractModel;
import es.tpv_bar.persistencia.pojos.Linea;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;


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
    
   
     public void updateDato(Linea dato) {
        Session session = factory.getCurrentSession();
        Double d = ((Linea)dato).getPrecio();
        System.out.println(((Linea)dato).getPrecio());
        Linea l = (Linea) session.load(Linea.class,dato.getIdLinea());
        l.setPrecio(d);
        l.setTotal(d);
        session.saveOrUpdate(l);
        Transaction tx = session.beginTransaction();
       
        session.saveOrUpdate(l);
         System.out.println(l.getTotal());
        tx.commit();
        //cargarLista();
    }
}
