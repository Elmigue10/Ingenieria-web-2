
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Persona"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/styles.css" rel="stylesheet" type="text/css"/>
        <title>Listar Personas</title>
    </head>
    <body>
        <div class="container">
            <h1>Personas</h1>
            <br>
            <a class="btn btn-success" href="Controlador?accion=add">Agregar Nuevo</a>
            <br>
            <table class="blue">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>DNI</th>
                        <th>NOMBRES</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <%
                    PersonaDAO dao=new PersonaDAO();
                    List<Persona>list=dao.listar();
                    Iterator<Persona>iter=list.iterator();
                    Persona per=null;
                    while(iter.hasNext()){
                        per=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td><%= per.getId()%></td>
                        <td><%= per.getDni()%></td>
                        <td><%= per.getNom()%></td>
                        <td>
                            <a href="Controlador?accion=editar&id=<%= per.getId()%>">Editar</a>
                            <a href="Controlador?accion=eliminar&id=<%= per.getId()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
