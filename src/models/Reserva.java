package models;

public class Reserva {

    private int idReserva;
    private String cliente;
    private int idCliente;
    private String habitacion;
    private int idHabitacion;
    private String empleado;
    private int idEmpleado;
    private String tipo;// horas|noche
    private String tiempoReservado;// 3(horas)|2(noches)
    private double costoTotal;
    private String estado;// disponible|reservado|mantenimiento
    private String fechaCreado;
    private String fechaActualizado;
    private String fechaReservado, fechaEntrada, fechaSalida;

    public Reserva() {
    }

    public Reserva(Reserva reserva) {
        this.idCliente = reserva.getIdCliente();
        this.idHabitacion = reserva.getIdHabitacion();
        this.idEmpleado = reserva.getIdEmpleado();
        this.cliente = reserva.getCliente();
        this.habitacion = reserva.getHabitacion();
        this.empleado = reserva.getEmpleado();
        this.tipo = reserva.getTipo();
        this.tiempoReservado = reserva.getTiempoReservado();
        this.costoTotal = reserva.getCostoTotal();
        this.estado = reserva.getEstado();
        this.fechaReservado = reserva.getFechaReservado();
        this.fechaEntrada = reserva.getFechaEntrada();
        this.fechaSalida = reserva.getFechaSalida();
        this.fechaCreado = reserva.getFechaCreado();
        this.fechaActualizado = reserva.getFechaActualizado();
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaReservado() {
        return fechaReservado;
    }

    public void setFechaReservado(String fechaReservado) {
        this.fechaReservado = fechaReservado;
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

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getTiempoReservado() {
        return tiempoReservado;
    }

    public void setTiempoReservado(String tiempoReservado) {
        this.tiempoReservado = tiempoReservado;
    }

}
