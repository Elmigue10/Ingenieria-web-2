/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Proveedor;

/**
 *
 * @author miguel.valbuena
 */
@Stateless
public class ProveedorDao implements ProveedorDaoLocal {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addProveedor(Proveedor proveedor) {
        em.persist(proveedor);
    }

    @Override
    public void editProveedor(Proveedor proveedor) {
        em.merge(proveedor);
    }

    @Override
    public void deleteProveedor(int idProveedor) {
        em.remove(getProveedor(idProveedor));
    }

    @Override
    public Proveedor getProveedor(int idProveedor) {
        return em.find(Proveedor.class, idProveedor);
    }

    @Override
    public List<Proveedor> getTodoProveedor() {
        return em.createNamedQuery("Proveedor.getTodo").getResultList();
    }
    
     // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
