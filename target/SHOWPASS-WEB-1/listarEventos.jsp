<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Evento" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Eventos</title>

    <style>
        body {
            font-family: Arial;
            text-align: center;
        }

        table {
            margin: auto;
            border-collapse: collapse;
            width: 80%;
        }

        th, td {
            border: 1px solid black;
            padding: 10px;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        a {
            margin: 5px;
            text-decoration: none;
        }

        .activo {
            color: green;
            font-weight: bold;
        }

        .inactivo {
            color: red;
            font-weight: bold;
        }
    </style>
</head>

<body>

<h2>📋 Eventos registrados</h2>

<%
    List<Evento> eventos = (List<Evento>) request.getAttribute("eventos");
%>

<table>
    <tr>
        <th>Nombre</th>
        <th>Fecha</th>
        <th>Lugar</th>
        <th>Precio</th>
        <th>Estado</th>
        <th>Acciones</th>
    </tr>

<%
    if (eventos != null) {
        for (Evento e : eventos) {
%>

    <tr>
        <td><%= e.getNombre() %></td>
        <td><%= e.getFecha() %></td>
        <td><%= e.getLugar() %></td>
        <td><%= e.getPrecio() %></td>

        <!-- ESTADO -->
        <td>
            <span class="<%= e.getEstado() %>">
                <%= e.getEstado() %>
            </span>
        </td>

        <!-- ACCIONES -->
        <td>

            <!-- EDITAR -->
            <a href="EventoServlet?accion=editar&id=<%= e.getId() %>">
                ✏ Editar
            </a>

            <!-- ELIMINAR -->
            <a href="EventoServlet?accion=eliminar&id=<%= e.getId() %>">
                ❌ Eliminar
            </a>

            <!-- ACTIVAR / DESACTIVAR -->
            <%
                if ("activo".equals(e.getEstado())) {
            %>
                <a href="EventoServlet?accion=estado&id=<%= e.getId() %>&valor=inactivo">
                    🔴 Desactivar
                </a>
            <%
                } else {
            %>
                <a href="EventoServlet?accion=estado&id=<%= e.getId() %>&valor=activo">
                    🟢 Activar
                </a>
            <%
                }
            %>

        </td>
    </tr>

<%
        }
    }
%>

</table>

<br>

<a href="registrarEvento.jsp">➕ Nuevo evento</a>
<br>
<a href="index.jsp">⬅ Volver</a>

</body>
</html>