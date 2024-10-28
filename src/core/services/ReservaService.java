package core.services;

import core.db.MysqlDBService;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import models.Reserva;

public class ReservaService extends BaseService {

    public ReservaService() {
        db = new MysqlDBService();
    }

    public DefaultTableModel listarReservas(DefaultTableModel modelo, Object[] data) {
        querySQL_1 = "SELECT r.id, c.empresa AS 'cliente', p.nombre AS 'empleado', th.descripcion AS 'tipo_habitacion', h.descripcion AS 'habitacion', r.monto_total,r.estado, r.fecha_reserva, r.fecha_entrada, r.fecha_salida, r.fecha_creado, r.fecha_actualizado FROM reservas r JOIN clientes c ON c.id = r.id_cliente LEFT JOIN personas pe ON pe.id = c.id_persona JOIN habitaciones h ON h.id = r.id_habitacion LEFT JOIN tipo_habitacion th ON th.id = h.id_tipohabitacion JOIN empleados e ON e.id = r.id_empleado LEFT JOIN personas p ON p.id = e.id_persona;";
        Object[] parametrosSQL_1 = {};
        ResultSet rs = db.queryConsultar(querySQL_1, parametrosSQL_1);

        try {
            while (rs.next()) {
                data[0] = rs.getInt("id");
                data[1] = rs.getString("cliente");
                data[2] = rs.getString("empleado");
                data[3] = rs.getString("tipo_habitacion");
                data[4] = rs.getString("habitacion");
                data[5] = rs.getString("monto_total");
                data[6] = rs.getString("estado");
                data[7] = rs.getString("fecha_reserva");
                data[8] = rs.getString("fecha_entrada");
                data[9] = rs.getString("fecha_salida");
                data[10] = rs.getString("fecha_creado");
                data[11] = rs.getString("fecha_actualizado");
                modelo.addRow(data);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        db.cerrarConsulta();
        return modelo;
    }

    public void crearReserva(Reserva reserva) {
        querySQL_1 = "INSERT INTO reservas ( id_cliente, id_habitacion, id_empleado, tipo, tiempo_reservado, monto_total, estado, fecha_reserva, fecha_entrada, fecha_salida, fecha_creado ) VALUES ( ?,?,?,?,?,?,?,?,?,?,NOW() );";
        Object[] parametrosSQL_1 = {reserva.getIdCliente(), reserva.getIdHabitacion(), reserva.getIdEmpleado(), reserva.getTipo(), reserva.getTiempoReservado(), reserva.getCostoTotal(), reserva.getEstado(), reserva.getFechaReservado(), reserva.getFechaEntrada(), reserva.getFechaSalida()};
        db.queryInsertar(querySQL_1, parametrosSQL_1);

        db.cerrarConsulta();
    }

    public void actualizarReserva(Reserva reserva) {
        querySQL_1 = "UPDATE reservas SET tipo = ?, tiempo_reservado = ?, monto_total = ?, estado = ?, fecha_reserva = ?, fecha_entrada = ?, fecha_salida = ?, fecha_actualizado = NOW() WHERE id = ?";
        Object[] parametrosSQL_1 = {reserva.getIdCliente(), reserva.getIdHabitacion(), reserva.getIdEmpleado(), reserva.getTipo(), reserva.getTiempoReservado(), reserva.getCostoTotal(), reserva.getEstado(), reserva.getFechaReservado(), reserva.getFechaEntrada(), reserva.getFechaSalida(), reserva.getIdReserva()};
        db.queryActualizar(querySQL_1, parametrosSQL_1);

        db.cerrarConsulta();
    }
}
