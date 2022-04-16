<%-- 
    Document   : proveedorInfo
    Created on : 15/04/2022, 04:38:40 PM
    Author     : miguel.valbuena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proveedor</title>
    </head>
    <body>
        <h1>Información del proveedor</h1>
        <form action="./ProveedorServlet" method = "POST">
            <table>
                <tr>
                    <td>ID Proveedor</td>
                    <td><input type="text" name="idProveedor" value="${proveedor.idProveedor}"></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${proveedor.nombre}"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add">
                        <input type="submit" name="action" value="Edit">
                        <input type="submit" name="action" value="Delete">
                        <input type="submit" name="action" value="Search">
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>ID</th>
            <th>Nombre</th>
            <c:forEach items="${TodoProveedor}" var="prove">
                <tr>
                    <td>${prove.idProveedor}</td>
                    <td>${prove.nombre}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
