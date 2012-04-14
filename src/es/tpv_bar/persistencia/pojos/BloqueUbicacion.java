package es.tpv_bar.persistencia.pojos;
// Generated 13-abr-2012 9:10:04 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * BloqueUbicacion generated by hbm2java
 */
@Entity
@Table(name="BloqueUbicacion"
    ,catalog="mydb"
)
public class BloqueUbicacion  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String descripcion;
     private Set<Ubicacion> ubicacions = new HashSet<Ubicacion>(0);

    public BloqueUbicacion() {
    }

	
    public BloqueUbicacion(String nombre) {
        this.nombre = nombre;
    }
    public BloqueUbicacion(String nombre, String descripcion, Set<Ubicacion> ubicacions) {
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.ubicacions = ubicacions;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="Nombre", nullable=false, length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Column(name="Descripcion", length=100)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="bloqueUbicacion")
    public Set<Ubicacion> getUbicacions() {
        return this.ubicacions;
    }
    
    public void setUbicacions(Set<Ubicacion> ubicacions) {
        this.ubicacions = ubicacions;
    }




}


