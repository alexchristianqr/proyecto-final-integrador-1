package core.services;

import core.db.MysqlDBService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.Cliente;

public class ClienteService extends BaseService {

    public ClienteService() {
        db = new MysqlDBService();
    }

    public DefaultTableModel listarClientes(DefaultTableModel modelo, Object[] data) {
        querySQL_1 = "SELECT c.id, p.nombre, p.apellido, p.tipo_documento, p.nrodocumento, p.edad, p.sexo, p.telefono, p.estado, p.fecha_creado, p.fecha_actualizado FROM clientes c JOIN personas p ON p.id = c.id_persona";
        Object[] parametrosSQL_1 = {};
        ResultSet rs = db.queryConsultar(querySQL_1, parametrosSQL_1);

        try {
            while (rs.next()) {
                data[0] = rs.getInt("id");
                data[1] = rs.getString("nombre");
                data[2] = rs.getString("apellido");
                data[3] = rs.getInt("tipo_documento");
                data[4] = rs.getString("nrodocumento");
                data[5] = rs.getString("edad");
                data[6] = rs.getString("sexo");
                data[7] = rs.getString("telefono");
                data[8] = rs.getString("estado");
                data[9] = rs.getString("fecha_creado");
                data[10] = rs.getString("fecha_actualizado");
                modelo.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }

        db.cerrarConsulta();
        return modelo;
    }

    public void crearCliente(Cliente cliente) {
        querySQL_1 = "INSERT INTO personas (nombre, apellido, tipo_documento, nrodocumento, sexo, estado, edad, telefono, fecha_creado) VALUES (?,?,?,?,?,?,?,?,?)";
        Object[] parametrosSQL_1 = {cliente.getNombre(), cliente.getApellidos(), cliente.getTipoDocumento(), cliente.getNroDocumento(), cliente.getSexo(), cliente.getEstado(), cliente.getEdad(), cliente.getTelefono(), cliente.getFechaCreado()};
        int id_persona = db.queryInsertar(querySQL_1, parametrosSQL_1);

        querySQL_2 = "INSERT INTO clientes (id_persona, empresa, fecha_creado) VALUES (?,?,?)";
        Object[] parametrosSQL_2 = {id_persona, cliente.getNombre() + ' ' + cliente.getApellidos(), cliente.getFechaCreado()};
        db.queryInsertar(querySQL_2, parametrosSQL_2);

        db.cerrarConsulta();
    }

    public void actualizarCliente(Cliente cliente) {
        querySQL_1 = "UPDATE personas SET  nombre = ?, apellido = ?, tipo_documento = ?, nrodocumento = ?, edad = ?, sexo = ?, telefono = ?, estado = ?, fecha_actualizado = NOW() WHERE id = (SELECT id_persona FROM clientes c WHERE c.id = ?)";
        Object[] parametrosSQL_1 = {cliente.getNombre(), cliente.getApellidos(), cliente.getTipoDocumento(), cliente.getNroDocumento(), cliente.getEdad(), cliente.getSexo(), cliente.getTelefono(), cliente.getEstado(), cliente.getIdCliente()};
        db.queryActualizar(querySQL_1, parametrosSQL_1);

        querySQL_2 = "UPDATE clientes SET empresa = ?, fecha_actualizado = NOW() WHERE id = ?";
        Object[] parametrosSQL_2 = {cliente.getNombre() + ' ' + cliente.getApellidos(), cliente.getIdCliente()};
        db.queryActualizar(querySQL_2, parametrosSQL_2);

        db.cerrarConsulta();
    }
}
