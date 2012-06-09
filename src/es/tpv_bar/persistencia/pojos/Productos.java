package es.tpv_bar.persistencia.pojos;
// Generated 09-jun-2012 17:46:57 by Hibernate Tools 3.2.1.GA


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
@Table(name="productos"
    ,catalog="mydb"
)
public class Productos  implements java.io.Serializable {


     private Integer idProductos;
     private Categoria categoria;
     private String nombre;
     private Double precio;
     private String textoBt;
     private boolean activo;
     private Integer color;
     private Set<Linea> lineas = new HashSet<Linea>(0);
     private Set<Atipicas> atipicases = new HashSet<Atipicas>(0);

    public Productos() {
    }

	
    public Productos(Categoria categoria, String textoBt, boolean activo) {
        this.categoria = categoria;
        this.textoBt = textoBt;
        this.activo = activo;
    }
    public Productos(Categoria categoria, String nombre, Double precio, String textoBt, boolean activo, Integer color, Set<Linea> lineas, Set<Atipicas> atipicases) {
       this.categoria = categoria;
       this.nombre = nombre;
       this.precio = precio;
       this.textoBt = textoBt;
       this.activo = activo;
       this.color = color;
       this.lineas = lineas;
       this.atipicases = atipicases;
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
    
    @Column(name="textoBT", nullable=false, length=45)
    public String getTextoBt() {
        return this.textoBt;
    }
    
    public void setTextoBt(String textoBt) {
        this.textoBt = textoBt;
    }
    
    @Column(name="Activo", nullable=false)
    public boolean isActivo() {
        return this.activo;
    }
     public boolean getActivo() {
        return this.activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    @Column(name="Color")
    public Integer getColor() {
        return this.color;
    }
    
    public void setColor(Integer color) {
        this.color = color;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="productos")
    public Set<Linea> getLineas() {
        return this.lineas;
    }
    
    public void setLineas(Set<Linea> lineas) {
        this.lineas = lineas;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="productos")
    public Set<Atipicas> getAtipicases() {
        return this.atipicases;
    }
    
    public void setAtipicases(Set<Atipicas> atipicases) {
        this.atipicases = atipicases;
    }

 @Override
    public String toString() {
        return  nombre ;
    }

}


