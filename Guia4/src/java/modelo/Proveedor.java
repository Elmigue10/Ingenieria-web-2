/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author miguel.valbuena
 */
@Entity
@Table
@NamedQueries({@NamedQuery(name="Proveedor.getTodo", query="SELECT e FROM Proveedor e")})
public class Proveedor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer idProveedor;
    
    @Column
    private String nombre;

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Proveedor(Integer idProveedor, String nombre) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
    }
    
    public Proveedor(){}

    @Override
    public String toString() {
        return "Proveedor{" + "idProveedor=" + idProveedor + ", nombre=" + nombre + '}';
    }
    
}
