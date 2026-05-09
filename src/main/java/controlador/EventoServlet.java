package controlador;

import dao.EventoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Evento;

@WebServlet("/EventoServlet")
public class EventoServlet extends HttpServlet {

    private EventoDAO dao;

    @Override
    public void init() {
        dao = new EventoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        // SI NO HAY ACCIÓN → SIEMPRE LISTA (IMPORTANTE)
        if (accion == null) {
            listar(request, response);
            return;
        }

        // ELIMINAR
        if ("eliminar".equals(accion)) {

            int id = Integer.parseInt(request.getParameter("id"));
            dao.eliminar(id);

            response.sendRedirect("EventoServlet");
            return;
        }

        // ACTIVAR / DESACTIVAR
        if ("estado".equals(accion)) {

            int id = Integer.parseInt(request.getParameter("id"));
            String estado = request.getParameter("valor");

            dao.cambiarEstado(id, estado);

            response.sendRedirect("EventoServlet");
            return;
        }

        // EDITAR (CARGAR DATOS)
        if ("editar".equals(accion)) {

            int id = Integer.parseInt(request.getParameter("id"));

            Evento evento = dao.obtenerPorId(id);

            request.setAttribute("evento", evento);

            request.getRequestDispatcher("editarEvento.jsp")
                   .forward(request, response);
        }
    }

    // MÉTODO LIMPIO PARA LISTAR (MEJOR PRÁCTICA)
    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Evento> lista = dao.listar();

        request.setAttribute("eventos", lista);

        request.getRequestDispatcher("listarEventos.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");

        Evento e = new Evento(
                request.getParameter("nombre"),
                request.getParameter("fecha"),
                request.getParameter("lugar"),
                request.getParameter("precio")
        );

        // UPDATE
        if (idStr != null && !idStr.isEmpty()) {

            e.setId(Integer.parseInt(idStr));
            dao.actualizar(e);

        } else {

            // INSERT
            dao.insertar(e);
        }

        response.sendRedirect("EventoServlet");
    }
}