package es.tpv_bar.persistencia.pojos;
// Generated 19-sep-2016 11:23:55 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Bloqueubicacion generated by hbm2java
 */
@Entity
@Table(name="bloqueubicacion"
)
public class Bloqueubicacion  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String descripcion;
     private String imagen;
     private Set<Atipicas> atipicases = new HashSet<Atipicas>(0);
     private Set<Ubicacion> ubicacions = new HashSet<Ubicacion>(0);

    public Bloqueubicacion() {
    }

	
    public Bloqueubicacion(String nombre) {
        this.nombre = nombre;
    }
    public Bloqueubicacion(String nombre, String descripcion, Set<Atipicas> atipicases, Set<Ubicacion> ubicacions) {
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.atipicases = atipicases;
       this.ubicacions = ubicacions;
    }

    public Bloqueubicacion(Integer id, String nombre, String descripcion, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", nullable=false)
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
 @Column(name="imagen", length=255)
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    
    
    
@OneToMany(fetch=FetchType.LAZY, mappedBy="bloqueubicacion")
    public Set<Atipicas> getAtipicases() {
        return this.atipicases;
    }
    
    public void setAtipicases(Set<Atipicas> atipicases) {
        this.atipicases = atipicases;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="bloqueubicacion")
    public Set<Ubicacion> getUbicacions() {
        return this.ubicacions;
    }
    
    public void setUbicacions(Set<Ubicacion> ubicacions) {
        this.ubicacions = ubicacions;
    }


 @Override
    public String toString() {
        return  nombre ;
    }


}


