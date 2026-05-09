package modelo;

public class Evento {

    private int id;
    private String nombre;
    private String fecha;
    private String lugar;
    private String precio;
    private String estado; // 🔥 NUEVO

    // Constructor vacío
    public Evento() {
    }

    // Constructor para INSERT
    public Evento(String nombre, String fecha, String lugar, String precio) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.precio = precio;
        this.estado = "activo"; // por defecto
    }

    // Constructor completo
    public Evento(int id, String nombre, String fecha, String lugar, String precio, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.precio = precio;
        this.estado = estado;
    }

    // GETTERS Y SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}