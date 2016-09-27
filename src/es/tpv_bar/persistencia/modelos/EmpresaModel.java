// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.persistencia.modelos;

import es.tpv_bar.persistencia.AbstractModel;
import es.tpv_bar.persistencia.pojos.Empresas;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


/**
 *
 * @author aperalta
 */
public class EmpresaModel extends AbstractModel {
    
    public EmpresaModel() {
        super(Empresas.class);
    }
    
    @Override
    public ArrayList<Empresas> getLista() {
        this.cargarLista();
        return (ArrayList<Empresas>) super.getLista();
    }
    
    String sql = "SELECT tp.caja.movimiento,\n" +
"	tp.caja.fecha,\n" +
"	tp.caja.`cajaPago`,\n" +
"	tp.caja.descripcion\n" +
"FROM tp.caja\n" +
"	INNER JOIN tp.camarero ON \n" +
"	 tp.caja.`IdCamarero` = tp.camarero.`IdCamarero` \n" +
"	INNER JOIN tp.empresas ON \n" +
"	 tp.camarero.`IdEmpresa` = tp.empresas.id where tp.empresas.id =  $P{empresa}  \n" +
"	 and tp.caja.fecha between  $P{desde} and  $P{hasta}  and cajaPago = 0";
    

}
