<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/styles.css">
    <title>Estadisticas</title>
</head>
<body>
    <div class="container">
        <h1>Estadisticas de la encuesta</h1>
        <a href="/">Volver al inicio</a>
        <p>${mensaje}${superheroVotado.nombre}</p>
        <p>${messageCookie}${superheroName}</p>
        <p class="votos-totales">Votos totales de la encuesta: ${votosTotales}</p>
        <table class="blue">
            <thead>
                <th>Id</th>
                <th>Nombre</th>
                <th>Total Votos</th>
                <th>Porcentaje de Votos</th>
            </thead>
            <tbody>
                <c:forEach items="${superheroes}" var="superhero">
                    <tr>
                        <td>${superhero.id}</td>
                        <td>${superhero.nombre}</td>
                        <td>${superhero.votos}</td>
                        <td>${superhero.porcentajeVotos}%</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
