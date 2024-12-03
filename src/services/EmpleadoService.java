package services;

import core.services.MysqlDBService;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import models.Empleado;

public class EmpleadoService extends BaseService {
    public EmpleadoService() {
        db = new MysqlDBService();
    }

    public DefaultTableModel listarEmpleados(DefaultTableModel modelo, Object[] data) {
        querySQL_1 = "SELECT e.id, p.nombre, p.apellido, p.tipo_documento, p.nrodocumento, e.sueldo, e.id_empleado_perfil, p.edad, p.sexo, p.telefono, p.estado, p.fecha_creado, p.fecha_actualizado FROM empleados e JOIN personas p ON p.id = e.id_persona;";
        Object[] parametrosSQL_1 = {};
        ResultSet rs = db.queryConsultar(querySQL_1, parametrosSQL_1);

        try {
            while (rs.next()) {
                data[0] = rs.getInt("id");
                data[1] = rs.getString("nombre");
                data[2] = rs.getString("apellido");
                data[3] = rs.getInt("tipo_documento");
                data[4] = rs.getString("nrodocumento");
                data[5] = rs.getInt("sueldo");
                data[6] = rs.getInt("id_empleado_perfil");
                data[7] = rs.getString("edad");
                data[8] = rs.getString("sexo");
                data[9] = rs.getString("telefono");
                data[10] = rs.getString("estado");
                data[11] = rs.getString("fecha_creado");
                data[12] = rs.getString("fecha_actualizado");
                modelo.addRow(data);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        db.cerrarConsulta();
        return modelo;
    }

    public void crearEmpleado(Empleado empleado) {
        querySQL_1 = "INSERT INTO personas (nombre, apellido, tipo_documento, nrodocumento, sexo, estado, edad, telefono, fecha_creado) VALUES (?,?,?,?,?,?,?,?,?)";
        Object[] parametrosSQL_1 = {empleado.getNombre(), empleado.getApellidos(), empleado.getTipoDocumento(), empleado.getNroDocumento(), empleado.getSexo(), empleado.getEstado(), empleado.getEdad(), empleado.getTelefono(), empleado.getFechaCreado()};
        int id_persona = db.queryInsertar(querySQL_1, parametrosSQL_1);

        querySQL_2 = "INSERT INTO empleados (id_persona, id_empleado_perfil, sueldo, fecha_creado) VALUES (?,?,?,NOW())";
        Object[] parametrosSQL_2 = {id_persona, empleado.getIdPerfil(), empleado.getSueldo(), empleado.getFechaCreado()};
        db.queryInsertar(querySQL_2, parametrosSQL_2);

        db.cerrarConsulta();
    }

    public void actualizarEmpleado(Empleado empleado) {
        querySQL_1 = "UPDATE personas SET  nombre = ?, apellido = ?, tipo_documento = ?, nrodocumento = ?, edad = ?, sexo = ?, telefono = ?, estado = ?, fecha_actualizado = NOW() WHERE id = (SELECT id_persona FROM empleados e WHERE e.id = ?)";
        Object[] parametrosSQL_1 = {empleado.getNombre(), empleado.getApellidos(), empleado.getTipoDocumento(), empleado.getNroDocumento(), empleado.getEdad(), empleado.getSexo(), empleado.getTelefono(), empleado.getEstado(), empleado.getIdEmpleado()};
        db.queryActualizar(querySQL_1, parametrosSQL_1);

        querySQL_2 = "UPDATE empleados SET id_empleado_perfil = ?, sueldo = ?, fecha_actualizado = NOW() WHERE id = ?";
        Object[] parametrosSQL_2 = {empleado.getIdPerfil(), empleado.getSueldo(), empleado.getIdEmpleado()};
        db.queryActualizar(querySQL_2, parametrosSQL_2);

        db.cerrarConsulta();
    }
}
