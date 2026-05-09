<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Registrar Evento</title>

    <style>
        body {
            font-family: Arial;
            background-color: #f2f2f2;
            text-align: center;
        }

        .container {
            background-color: white;
            width: 40%;
            margin: auto;
            margin-top: 60px;
            padding: 30px;
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
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #218838;
        }

        a {
            display: block;
            margin-top: 15px;
            text-decoration: none;
        }
    </style>

</head>

<body>

<div class="container">

    <h2>➕ Registrar Evento</h2>

    <form action="EventoServlet" method="post">

        <input type="text" name="nombre" placeholder="Nombre del evento" required>
        <input type="date" name="fecha" required>
        <input type="text" name="lugar" placeholder="Lugar" required>
        <input type="text" name="precio" placeholder="Precio" required>

        <button type="submit">Guardar</button>

    </form>

    <a href="EventoServlet">📋 Ver eventos</a>
    <a href="index.jsp">⬅ Volver</a>

</div>

</body>
</html>