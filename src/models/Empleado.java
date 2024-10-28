package models;

public class Empleado extends Persona {

    private int idEmpleado;
    private int idPerfil;
    private double sueldo;

    public Empleado() {
    }

    public Empleado(Empleado empleado) {
        super(empleado.getNroDocumento(), empleado.getNombre(), empleado.getApellidos(), empleado.getSexo(), empleado.getEdad(), empleado.getTelefono(), empleado.getEstado(), empleado.getFechaCreado(), empleado.getFechaActualizado(), empleado.getIdPersona());
        this.idPerfil = empleado.getIdPerfil();
        this.sueldo = empleado.getSueldo();
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

}
