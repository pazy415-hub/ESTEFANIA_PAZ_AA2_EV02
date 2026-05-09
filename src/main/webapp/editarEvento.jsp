<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Evento" %>

<%
    Evento e = (Evento) request.getAttribute("evento");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Evento</title>

    <style>
        body {
            font-family: Arial;
            background-color: #f2f2f2;
            text-align: center;
        }

        .container {
            width: 40%;
            margin: auto;
            margin-top: 60px;
            padding: 30px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0px 0px 10px #aaa;
        }

        input {
            width: 90%;
            padding: 10px;
            margin: 10px 0;
        }

        button {
            padding: 10px 20px;
            background-color: orange;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: darkorange;
        }

        a {
            display: block;
            margin-top: 15px;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>✏ Editar Evento</h2>

    <form action="EventoServlet" method="post">

        <!-- ID oculto -->
        <input type="hidden" name="id" value="<%= e.getId() %>">

        Nombre:
        <input type="text" name="nombre" value="<%= e.getNombre() %>" required>

        Fecha:
        <input type="date" name="fecha" value="<%= e.getFecha() %>" required>

        Lugar:
        <input type="text" name="lugar" value="<%= e.getLugar() %>" required>

        Precio:
        <input type="text" name="precio" value="<%= e.getPrecio() %>" required>

        <button type="submit">Actualizar</button>

    </form>

    <a href="EventoServlet">⬅ Volver</a>

</div>

</body>
</html>