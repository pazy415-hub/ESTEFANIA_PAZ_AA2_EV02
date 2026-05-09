package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Evento;

public class EventoDAO {

    // INSERTAR
    public void insertar(Evento e) {

        String sql = "INSERT INTO evento(nombre, fecha, lugar, precio, estado) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getFecha());
            ps.setString(3, e.getLugar());
            ps.setDouble(4, Double.parseDouble(e.getPrecio()));
            ps.setString(5, "activo");

            ps.executeUpdate();

            System.out.println("INSERTADO ✔");

        } catch (Exception ex) {
            System.out.println("ERROR INSERTANDO:");
            ex.printStackTrace();
        }
    }

    // LISTAR
    public List<Evento> listar() {

        List<Evento> lista = new ArrayList<>();

        String sql = "SELECT * FROM evento";

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Evento e = new Evento();

                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setFecha(rs.getString("fecha"));
                e.setLugar(rs.getString("lugar"));
                e.setPrecio(rs.getString("precio"));
                e.setEstado(rs.getString("estado"));

                lista.add(e);
            }

        } catch (Exception ex) {
            System.out.println("ERROR LISTANDO:");
            ex.printStackTrace();
        }

        return lista;
    }

    // ELIMINAR
    public void eliminar(int id) {

        String sql = "DELETE FROM evento WHERE id=?";

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("ELIMINADO ✔");

        } catch (Exception ex) {
            System.out.println("ERROR ELIMINANDO:");
            ex.printStackTrace();
        }
    }

    // ACTUALIZAR
    public void actualizar(Evento e) {

        String sql = "UPDATE evento SET nombre=?, fecha=?, lugar=?, precio=? WHERE id=?";

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getFecha());
            ps.setString(3, e.getLugar());
            ps.setDouble(4, Double.parseDouble(e.getPrecio()));
            ps.setInt(5, e.getId());

            ps.executeUpdate();

            System.out.println("ACTUALIZADO ✔");

        } catch (Exception ex) {
            System.out.println("ERROR ACTUALIZANDO:");
            ex.printStackTrace();
        }
    }

    // CAMBIAR ESTADO
    public void cambiarEstado(int id, String estado) {

        String sql = "UPDATE evento SET estado=? WHERE id=?";

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, estado);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("ESTADO CAMBIADO ✔");

        } catch (Exception ex) {
            System.out.println("ERROR CAMBIANDO ESTADO:");
            ex.printStackTrace();
        }
    }

    // OBTENER POR ID (ARREGLADO)
    public Evento obtenerPorId(int id) {

        Evento e = null;

        String sql = "SELECT * FROM evento WHERE id=?";

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                e = new Evento();

                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setFecha(rs.getString("fecha"));
                e.setLugar(rs.getString("lugar"));
                e.setPrecio(rs.getString("precio"));
                e.setEstado(rs.getString("estado"));
            }

        } catch (Exception ex) {
            System.out.println("ERROR OBTENIENDO POR ID:");
            ex.printStackTrace();
        }

        return e;
    }
}