<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/styles.css">
    <title>Superheroes Survey</title>
</head>
<body>
    <div class="container">
        <h1>!Escoge tu Superheroe favorito!</h1>
        <a href="/statistics">Ir a las estadisticas</a>
        <p>${messageCookie}${superheroName}</p>
        <form action="/statistics" method="GET">
            <table class="blue">
                <thead>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Votar</th>
                </thead>
                <tbody>
                    <c:forEach items="${superheroes}" var="superhero">
                        <tr>
                            <td>${superhero.id}</td>
                            <td>${superhero.nombre}</td>
                            <td><button type="submit" value="${superhero.id}" name="id">Votar</button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </div>
</body>
</html>