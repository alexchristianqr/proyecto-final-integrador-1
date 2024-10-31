package models;

public class Habitacion {

    private int idHabitacion;
    private String descripcion;
    private String nivel;
    private String numeroPiso;
    private double precio;
    private int cantidadCamas;
    private int idTipoHabitacion;
    private String estado;
    private String fechaCreado;
    private String fechaActualizado;

    public Habitacion() {
    }

    public Habitacion(Habitacion habitacion) {
        this.descripcion = habitacion.getDescripcion();
        this.nivel = habitacion.getNivel();
        this.numeroPiso = habitacion.getNumeroPiso();
        this.precio = habitacion.getPrecio();
        this.cantidadCamas = habitacion.getCantidadCamas();
        this.idTipoHabitacion = habitacion.getIdTipoHabitacion();
        this.estado = habitacion.getEstado();
        this.fechaCreado = habitacion.getFechaCreado();
        this.fechaActualizado = habitacion.getFechaActualizado();
    }

    public double calcularPrecioBase() {
        double precioBase = 0;
        if (idTipoHabitacion == 1) {
            precioBase = 30;
        } else if (idTipoHabitacion == 2) {
            precioBase = 40;
        } else {
            precioBase = 50;
        }
        return precioBase;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getNumeroPiso() {
        return numeroPiso;
    }

    public void setNumeroPiso(String numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    public int getCantidadCamas() {
        return cantidadCamas;
    }

    public void setCantidadCamas(int cantidadCamas) {
        this.cantidadCamas = cantidadCamas;
    }

    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(String fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    public String getFechaActualizado() {
        return fechaActualizado;
    }

    public void setFechaActualizado(String fechaActualizado) {
        this.fechaActualizado = fechaActualizado;
    }

}
