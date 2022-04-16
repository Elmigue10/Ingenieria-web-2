/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import modelo.Proveedor;

/**
 *
 * @author miguel.valbuena
 */
@Local
public interface ProveedorDaoLocal {

    void addProveedor(Proveedor proveedor);

    void editProveedor(Proveedor proveedor);

    void deleteProveedor(int idProveedor);

    Proveedor getProveedor(int idProveedor);

    List<Proveedor> getTodoProveedor();
    
}
