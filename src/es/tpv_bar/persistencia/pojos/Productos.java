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
 * Productos generated by hbm2java
 */
@Entity
@Table(name="Productos"
    ,catalog="mydb"
)
public class Productos  implements java.io.Serializable {


     private Integer idProductos;
     private Categoria categoria;
     private String nombre;
     private Double precio;
     private Set<Linea> lineas = new HashSet<Linea>(0);

    public Productos() {
    }

	
    public Productos(Categoria categoria) {
        this.categoria = categoria;
    }
    public Productos(Categoria categoria, String nombre, Double precio, Set<Linea> lineas) {
       this.categoria = categoria;
       this.nombre = nombre;
       this.precio = precio;
       this.lineas = lineas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="IdProductos", unique=true, nullable=false)
    public Integer getIdProductos() {
        return this.idProductos;
    }
    
    public void setIdProductos(Integer idProductos) {
        this.idProductos = idProductos;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IdCategoria", nullable=false)
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    @Column(name="Nombre", length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Column(name="Precio", precision=22, scale=0)
    public Double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="productos")
    public Set<Linea> getLineas() {
        return this.lineas;
    }
    
    public void setLineas(Set<Linea> lineas) {
        this.lineas = lineas;
    }




}


