package controllers;

import core.services.HabitacionService;
import javax.swing.table.DefaultTableModel;
import models.Habitacion;

public class HabitacionController extends BaseController<Habitacion, HabitacionService> {

    public HabitacionController() {
        lista.clear();
        service = new HabitacionService();
    }

    public DefaultTableModel listarHabitaciones(String buscar) {
        DefaultTableModel modelo;
        String[] columnNames = {"Código", "Descripción", "Tipo", "Nivel", "Numero", "Precio", "Cantidad camas", "Estado", "Fecha creado", "Fecha actualizado"};
        Object[] data = new Object[columnNames.length];
        modelo = new DefaultTableModel(null, columnNames);
        modelo = service.listarHabitaciones(modelo, data);
        return modelo;
    }

    public void crearHabitacion(Habitacion habitacion) {
        service.crearHabitacion(habitacion);
    }

    public Habitacion encontrarHabitacion(int idHabitacion) {
        for (Habitacion oHabitacion : lista) {
            if (oHabitacion.getIdHabitacion() == idHabitacion) {
                return oHabitacion;
            }
        }
        return null;
    }

    public void actualizarHabitacion(Habitacion habitacion) {
        service.actualizarHabitacion(habitacion);
    }

    public void eliminarHabitacion(int idHabitacion) {
        for (Habitacion oHabitacion : lista) {
            if (oHabitacion.getIdHabitacion() == idHabitacion) {
                lista.remove(oHabitacion);
                break;
            }
        }
    }
}
