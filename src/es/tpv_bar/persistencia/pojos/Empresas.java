package es.tpv_bar.persistencia.pojos;
// Generated 19-sep-2016 11:23:55 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Empresas generated by hbm2java
 */
@Entity
@Table(name="empresas"
)
public class Empresas  implements java.io.Serializable {


     private int id;
     private String nombre;
     private String direccion;
     private String cif;
     private Integer telefono;
     private String mail;
     private Integer fax;
     private Integer contadorCod;
     private Set<Camarero> camareros = new HashSet<Camarero>(0);

    public Empresas() {
    }

	
    public Empresas(int id) {
        this.id = id;
    }
    public Empresas(int id, String nombre, String direccion, String cif, Integer telefono, String mail, Integer fax, Integer contadorCod, Set<Camarero> camareros) {
       this.id = id;
       this.nombre = nombre;
       this.direccion = direccion;
       this.cif = cif;
       this.telefono = telefono;
       this.mail = mail;
       this.fax = fax;
       this.contadorCod = contadorCod;
       this.camareros = camareros;
    }
   
     @Id 

    
    @Column(name="id", nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="Nombre", length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="Direccion", length=45)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    @Column(name="Cif", length=45)
    public String getCif() {
        return this.cif;
    }
    
    public void setCif(String cif) {
        this.cif = cif;
    }

    
    @Column(name="Telefono")
    public Integer getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    
    @Column(name="Mail", length=45)
    public String getMail() {
        return this.mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }

    
    @Column(name="Fax")
    public Integer getFax() {
        return this.fax;
    }
    
    public void setFax(Integer fax) {
        this.fax = fax;
    }

    
    @Column(name="ContadorCod")
    public Integer getContadorCod() {
        return this.contadorCod;
    }
    
    public void setContadorCod(Integer contadorCod) {
        this.contadorCod = contadorCod;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="empresas")
    public Set<Camarero> getCamareros() {
        return this.camareros;
    }
    
    public void setCamareros(Set<Camarero> camareros) {
        this.camareros = camareros;
    }




}


