// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.persistencia.modelos;

import es.tpv_bar.persistencia.AbstractModel;
import es.tpv_bar.persistencia.pojos.Configuracion;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


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
                .add(Restrictions.eq("key", "codTicket")).uniqueResult();
        if (result == null){
            Configuracion conf = new Configuracion();
            conf.setKey("codTicket");
            conf.setValue("0");
            super.saveDato(conf);
        }else{
             i = Integer.parseInt(result.getValue());
             i++;
             result.setValue(i.toString());
             super.saveDato(result);
        }
        return i;
    }
}
