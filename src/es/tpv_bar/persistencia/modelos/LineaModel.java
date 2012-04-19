// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.persistencia.modelos;

import es.tpv_bar.persistencia.AbstractModel;
import es.tpv_bar.persistencia.pojos.Linea;
import es.tpv_bar.persistencia.pojos.Ubicacion;
import es.tpv_bar.prints.Ticket;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;


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
     
     public ArrayList<Linea> getLineasUbicacion(Ubicacion ubi){
         ArrayList<Linea> result = null;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        result = (ArrayList<Linea>) session.createCriteria(Linea.class)
                .add(Restrictions.eq("ubicacion", ubi))
                .add(Restrictions.eq("cobrado",false))
                .list();
        return result;
     }
     public ArrayList<Ticket> getTicket(int cabezera){
         
        ArrayList<Ticket> result = null;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql = "SELECT "
                +"(SELECT precio FROM Productos "
                + "WHERE idProductos = Linea.idProductos ) "
                + "AS precio,"
                + "(SELECT nombre FROM Productos "
                + "WHERE idProductos = Linea.idProductos ) "
                + "AS producto,"
                + " COUNT( idProductos ) "
                + "as cantidad , "
                + "SUM( Total )"
                + "as total "
                + "FROM  `Linea` WHERE idCabezera =" +cabezera
                + " GROUP BY idProductos";
        
        result = (ArrayList<Ticket>) session.createSQLQuery(sql)
                .setResultTransformer(Transformers.aliasToBean(Ticket.class))
                .list();
        return result;
     }
}
