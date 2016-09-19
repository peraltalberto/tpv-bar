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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ubicacion generated by hbm2java
 */
@Entity
@Table(name="ubicacion"
)
public class Ubicacion  implements java.io.Serializable {


     private Integer idUbicacion;
     private Bloqueubicacion bloqueubicacion;
     private String nombre;
     private String descripcion;
     private boolean activo;
     private Set<Linea> lineas = new HashSet<Linea>(0);

    public Ubicacion() {
    }

	
    public Ubicacion(Bloqueubicacion bloqueubicacion, boolean activo) {
        this.bloqueubicacion = bloqueubicacion;
        this.activo = activo;
    }
    public Ubicacion(Bloqueubicacion bloqueubicacion, String nombre, String descripcion, boolean activo, Set<Linea> lineas) {
       this.bloqueubicacion = bloqueubicacion;
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.activo = activo;
       this.lineas = lineas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="IdUbicacion", nullable=false)
    public Integer getIdUbicacion() {
        return this.idUbicacion;
    }
    
    public void setIdUbicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IdBloqueUbicacion", nullable=false)
    public Bloqueubicacion getBloqueubicacion() {
        return this.bloqueubicacion;
    }
    
    public void setBloqueubicacion(Bloqueubicacion bloqueubicacion) {
        this.bloqueubicacion = bloqueubicacion;
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

    
    @Column(name="Activo", nullable=false)
    public boolean isActivo() {
        return this.activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="ubicacion")
    public Set<Linea> getLineas() {
        return this.lineas;
    }
    
    public void setLineas(Set<Linea> lineas) {
        this.lineas = lineas;
    }




}


