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
 * Categoria generated by hbm2java
 */
@Entity
@Table(name="categoria"
    ,catalog="mydb"
)
public class Categoria  implements java.io.Serializable {


     private Integer idCategoria;
     private String nombre;
     private boolean activo;
     private Set<Productos> productoses = new HashSet<Productos>(0);

    public Categoria() {
    }

	
    public Categoria(boolean activo) {
        this.activo = activo;
    }
    public Categoria(String nombre, boolean activo, Set<Productos> productoses) {
       this.nombre = nombre;
       this.activo = activo;
       this.productoses = productoses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="IdCategoria", unique=true, nullable=false)
    public Integer getIdCategoria() {
        return this.idCategoria;
    }
    
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    @Column(name="Nombre", length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Column(name="Activo", nullable=false)
    public boolean isActivo() {
        return this.activo;
    }
    public String getActivo(){
        return this.activo?"visible":"oculto";
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="categoria")
    public Set<Productos> getProductoses() {
        return this.productoses;
    }
    
    public void setProductoses(Set<Productos> productoses) {
        this.productoses = productoses;
    }

    @Override
    public String toString() {
        return  nombre ;
    }




}


