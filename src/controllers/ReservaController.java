package controllers;

import core.services.ReservaService;
import javax.swing.table.DefaultTableModel;
import models.Reserva;

public class ReservaController extends BaseController<Reserva, ReservaService> {

    public ReservaController() {
        lista.clear();
        service = new ReservaService();
    }

    public DefaultTableModel listarReservas(String buscar) {
        DefaultTableModel modelo;
        String[] columnNames = {"Código", "Cliente", "Empleado", "Tipo Habitación", "Habitación", "Tipo Reserva", "Tiempo Reservado", "Total", "Estado", "Fecha reserva", "Fecha entrada", "Fecha salida", "Fecha creado", "Fecha actualizado"};
        Object[] data = new Object[columnNames.length];
        modelo = new DefaultTableModel(null, columnNames);
        modelo = service.listarReservas(modelo, data);
        return modelo;
    }

    public void crearReserva(Reserva reserva) {
        service.crearReserva(reserva);
    }

    public void actualizarReserva(Reserva reserva) {
        service.actualizarReserva(reserva);
    }

}
