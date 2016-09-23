/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.prints;

import java.math.BigInteger;

/**
 *
 * @author aperalta
 */
public class Ticket {
    
    private String producto;
    private Double total;
    private Double cantidad;
    private Double precio;

    public Ticket() {
    }

    
    
    public Ticket(String producto, Double total, Double cantidad, Double precio) {
        this.producto = producto;
        this.total = total;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    
    
}
