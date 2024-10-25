package controllers;

import javax.swing.table.DefaultTableModel;
import models.Empleado;

public interface EmpleadoControllerInterface {
    DefaultTableModel listarEmpleados(String buscar);
    Empleado crearEmpleado(Empleado empleado);
}
