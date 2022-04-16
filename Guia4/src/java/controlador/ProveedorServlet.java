/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.ProveedorDaoLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Proveedor;

/**
 *
 * @author miguel.valbuena
 */
@WebServlet(name = "ProveedorServlet", urlPatterns = {"/ProveedorServlet"})
public class ProveedorServlet extends HttpServlet {

    @EJB
    private ProveedorDaoLocal ProveedorDao;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String idProveedorStr = request.getParameter("idProveedor");
        
        int idProveedor = 0;
        
        if(idProveedorStr != null && !idProveedorStr.equals("")){
            idProveedor = Integer.parseInt(idProveedorStr);
        }
        
        String nombre = request.getParameter("nombre");
        Proveedor proveedor = new Proveedor(idProveedor, nombre);
        
        if("Add".equalsIgnoreCase(action)){
            ProveedorDao.addProveedor(proveedor);
        } else if("Edit".equalsIgnoreCase(action)){
            ProveedorDao.editProveedor(proveedor);
        } else if("Delete".equalsIgnoreCase(action)){
            ProveedorDao.deleteProveedor(idProveedor);
        } else if("Search".equalsIgnoreCase(action)){
            proveedor = ProveedorDao.getProveedor(idProveedor);
        }
        
        request.setAttribute("proveedor", proveedor);
        List<Proveedor> proveedores = ProveedorDao.getTodoProveedor();
        System.out.println("Proveedor 1 :" + proveedores.get(0));
        System.out.println("Lista" + ProveedorDao.getTodoProveedor());
        request.setAttribute("TodoProveedor", ProveedorDao.getTodoProveedor());
        request.getRequestDispatcher("proveedorInfo.jsp").forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
