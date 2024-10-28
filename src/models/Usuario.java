package models;

import java.time.LocalDateTime;

public class Usuario {

    private int idUsuario;
    private int idPersona;
    private int idEmpleado;
    private int idCliente;
    private Empleado empleado;
    private Cliente cliente;
    private String username;
    private String password;
    private String perfil;
    private String estado;// activo|inactivo|pendiente
    private String nombres;
    private String apellidos;
    private String rol;
    private String fechaCreado;
    private String fechaActualizado;

    public Usuario() {
    }

    public Usuario(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.idEmpleado = usuario.getIdEmpleado();
        this.empleado = usuario.getEmpleado();
        this.idCliente = usuario.getIdCliente();
        this.cliente = usuario.getCliente();
        this.idPersona = usuario.getIdPersona();
        this.username = usuario.getUsername();
        this.password = usuario.getPassword();
        this.perfil = usuario.getPerfil();
        this.estado = usuario.getEstado();
        this.nombres = usuario.getNombres();
        this.apellidos = usuario.getApellidos();
        this.rol = usuario.getRol();
        this.fechaCreado = usuario.getFechaCreado();
        this.fechaActualizado = usuario.getFechaActualizado();
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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
