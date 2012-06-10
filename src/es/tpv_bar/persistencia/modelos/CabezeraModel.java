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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
     public ArrayList<Cabezera> getTicketsSC(){
         ArrayList<Cabezera> result = null;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        result = (ArrayList<Cabezera>) session.createCriteria(Cabezera.class)
                .add(Restrictions.eq("estado", 0))
                .list();
        return result;
     }
     public ArrayList<Cabezera> getCierreCaja(int id){
         ArrayList<Cabezera> result = null; 
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        result = (ArrayList<Cabezera>) session.createCriteria(Cabezera.class)
                .add(Restrictions.gt("idCabezera", id))
                .list();
        System.out.println("Cantidad de tickets: "+result.size());
        
        return result;
     }
     public ArrayList<Cabezera>getDiaTickets(Date fecha){
        
            ArrayList<Cabezera> result = null; 
         try {
            Session session = factory.getCurrentSession();
          Transaction tx = session.beginTransaction();
          result = (ArrayList<Cabezera>) session.createCriteria(Cabezera.class)
                  .add(Restrictions
                  .between("fecha",sdf2.parse(sdf.format(fecha)+" 00:00"),
                  sdf2.parse(sdf.format(fecha)+" 23:59")))
                  .list();
          System.out.println("Cantidad de tickets: "+result.size());
          
        } catch (ParseException ex) {
            Logger.getLogger(CabezeraModel.class.getName()).log(Level.SEVERE, null, ex);
        }
         return result;
     }
}
