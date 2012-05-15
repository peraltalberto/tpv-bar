package es.tpv_bar.persistencia.pojos;
// Generated 14-may-2012 18:52:04 by Hibernate Tools 3.2.1.GA


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
 * Camarero generated by hbm2java
 */
@Entity
@Table(name="camarero"
    ,catalog="mydb"
)
public class Camarero  implements java.io.Serializable {


     private Integer idCamarero;
     private String nombre;
     private String apellidos;
     private Integer telefono;
     private boolean activo;
     private Set<Cabezera> cabezeras = new HashSet<Cabezera>(0);
     private Set<Caja> cajas = new HashSet<Caja>(0);

    public Camarero() {
    }

	
    public Camarero(boolean activo) {
        this.activo = activo;
    }
    public Camarero(String nombre, String apellidos, Integer telefono, boolean activo, Set<Cabezera> cabezeras, Set<Caja> cajas) {
       this.nombre = nombre;
       this.apellidos = apellidos;
       this.telefono = telefono;
       this.activo = activo;
       this.cabezeras = cabezeras;
       this.cajas = cajas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="IdCamarero", unique=true, nullable=false)
    public Integer getIdCamarero() {
        return this.idCamarero;
    }
    
    public void setIdCamarero(Integer idCamarero) {
        this.idCamarero = idCamarero;
    }
    
    @Column(name="Nombre", length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Column(name="Apellidos", length=100)
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    @Column(name="Telefono")
    public Integer getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
    
    @Column(name="Activo", nullable=false)
    public boolean isActivo() {
        return this.activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="camarero")
    public Set<Cabezera> getCabezeras() {
        return this.cabezeras;
    }
    
    public void setCabezeras(Set<Cabezera> cabezeras) {
        this.cabezeras = cabezeras;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="camarero")
    public Set<Caja> getCajas() {
        return this.cajas;
    }
    
    public void setCajas(Set<Caja> cajas) {
        this.cajas = cajas;
    }

public String getActivo(){
        return this.activo?"visible":"oculto";
    }


}


