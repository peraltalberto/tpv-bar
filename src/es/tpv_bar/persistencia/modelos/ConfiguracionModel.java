// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.persistencia.modelos;

import es.tpv_bar.persistencia.AbstractModel;
import static es.tpv_bar.persistencia.AbstractModel.factory;
import es.tpv_bar.persistencia.pojos.Configuracion;
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
public class ConfiguracionModel extends AbstractModel {
    
    public ConfiguracionModel() {
        super(Configuracion.class);
    }
    
    @Override
    public ArrayList<Configuracion> getLista() {
        this.cargarLista();
        return (ArrayList<Configuracion>) super.getLista();
    }
    
    public int getCod(){
        Integer i = 0;
        Configuracion result = null;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        result =(Configuracion) session.createCriteria(Configuracion.class)
                .add(Restrictions.eq("clave", "codTicket")).uniqueResult();
        if (result == null){
            Configuracion conf = new Configuracion();
            conf.setClave("codTicket");
            conf.setValue("0");
            session.save(conf);
        }else{
             i = Integer.parseInt(result.getValue());
             i++;
             result.setValue(i.toString());
             session.save(result);
        }
        tx.commit();
        return i;
    }
    public String getValue(String clave){
        Configuracion conf = (Configuracion) super.busquedaDato("clave", clave);
        return conf.getValue();
    }
    public void setValue(String clave,String value){
        Configuracion conf = (Configuracion) super.busquedaDato("clave", clave);
        conf.setValue(value);
        super.saveDato(conf);
    }
    
    public ArrayList<Object[]> getVentas(){
        String sql = "SELECT YEAR(Fecha) as year,YEAR(Fecha)   as month ,"
                + "DAYOFMONTH(Fecha) as day , sum(Total) as total "
                + "FROM `cabezera` group by YEAR(Fecha) ,YEAR(Fecha) ,"
                + "DAYOFMONTH(Fecha) order by Fecha desc LIMIT 10";
        
         Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
 
        
        ArrayList<Object[]> result = (ArrayList<Object[]>) 
                session.createSQLQuery(sql).list();
        return result;
    
    }
}
