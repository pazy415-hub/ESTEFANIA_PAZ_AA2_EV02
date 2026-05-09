<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>SHOWPASS - Sistema de Eventos</title>
    <style>
        body {
            font-family: Arial;
            text-align: center;
            background-color: #f2f2f2;
        }

        .container {
            margin-top: 80px;
        }

        h1 {
            color: #333;
        }

        .btn {
            display: inline-block;
            padding: 12px 20px;
            margin: 10px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 8px;
        }

        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>

<body>

<div class="container">

    <h1>🎪 SHOWPASS</h1>
    <h3>Sistema de Gestión de Eventos</h3>

    <a class="btn" href="EventoServlet">📋 Ver eventos</a>
    <a class="btn" href="registrarEvento.jsp">➕ Registrar evento</a>

</div>

</body>
</html>