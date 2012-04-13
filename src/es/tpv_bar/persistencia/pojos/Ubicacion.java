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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ubicacion generated by hbm2java
 */
@Entity
@Table(name="Ubicacion"
    ,catalog="mydb"
)
public class Ubicacion  implements java.io.Serializable {


     private Integer idUbicacion;
     private BloqueUbicacion bloqueUbicacion;
     private String nombre;
     private String descripcion;
     private Set<Servicios> servicioses = new HashSet<Servicios>(0);

    public Ubicacion() {
    }

	
    public Ubicacion(BloqueUbicacion bloqueUbicacion) {
        this.bloqueUbicacion = bloqueUbicacion;
    }
    public Ubicacion(BloqueUbicacion bloqueUbicacion, String nombre, String descripcion, Set<Servicios> servicioses) {
       this.bloqueUbicacion = bloqueUbicacion;
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.servicioses = servicioses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="IdUbicacion", unique=true, nullable=false)
    public Integer getIdUbicacion() {
        return this.idUbicacion;
    }
    
    public void setIdUbicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IdBloqueUbicacion", nullable=false)
    public BloqueUbicacion getBloqueUbicacion() {
        return this.bloqueUbicacion;
    }
    
    public void setBloqueUbicacion(BloqueUbicacion bloqueUbicacion) {
        this.bloqueUbicacion = bloqueUbicacion;
    }
    
    @Column(name="Nombre", length=45)
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
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="ubicacion")
    public Set<Servicios> getServicioses() {
        return this.servicioses;
    }
    
    public void setServicioses(Set<Servicios> servicioses) {
        this.servicioses = servicioses;
    }




}


