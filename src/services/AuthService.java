package services;

import core.services.MysqlDBService;
import core.utils.UsuarioThreadLocal;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Cliente;
import models.Empleado;
import models.Usuario;

public class AuthService extends BaseService {

    public AuthService() {
        db = new MysqlDBService();
    }

    public boolean login(String username, String pwd) {

        boolean success = false;

        try {
            ResultSet rs_1, rs_2, rs_3, rs_4;

            querySQL_1 = "SELECT u.rol FROM usuarios u WHERE u.username = ? AND u.pwd = ? AND u.estado = 'activo' LIMIT 1;";
            Object[] parametrosSQL_1 = {username, pwd};
            rs_1 = db.queryConsultar(querySQL_1, parametrosSQL_1);

            String rol = "";

            if (rs_1.next()) {
                rol = rs_1.getString("rol");
            }

            switch (rol) {
                case "empleado":
                    querySQL_2 = "SELECT u.*, e.id AS 'id_empleado', e.id_persona FROM usuarios u JOIN empleados e ON e.id_usuario = u.id AND e.estado = 'activo' WHERE u.username = ? AND u.pwd = ? AND u.estado = 'activo' LIMIT 1;";
                    break;
//                case "cliente":
//                    querySQL_2 = "SELECT u.*, c.id AS 'id_cliente', c.id_persona FROM usuarios u JOIN clientes c ON c.id_usuario = u.id AND c.estado = 'activo' WHERE u.username = ? AND u.pwd = ? AND u.estado = 'activo' LIMIT 1;";
//                    break;
                default:
                    return false;
            }

            Object[] parametrosSQL_2 = {username, pwd};
            rs_2 = db.queryConsultar(querySQL_2, parametrosSQL_2);

            Usuario usuario = new Usuario();
            Empleado empleado;
            Cliente cliente;

            while (rs_2.next()) {

                usuario.setIdUsuario(rs_2.getInt("id"));
                usuario.setIdPersona(rs_2.getInt("id_persona"));
                usuario.setNombres(rs_2.getString("nombres"));
                usuario.setApellidos(rs_2.getString("apellidos"));
                usuario.setRol(rs_2.getString("rol"));
                usuario.setUsername(rs_2.getString("username"));
                usuario.setPassword(rs_2.getString("pwd"));
                usuario.setEstado(rs_2.getString("estado"));
                usuario.setFechaCreado(rs_2.getString("fecha_creado"));

                switch (rol) {
                    case "empleado": {
                        usuario.setIdEmpleado(rs_2.getInt("id_empleado"));
                        empleado = new Empleado();

                        /* OBTENER DATOS DEL EMPLEADO */
                        querySQL_3 = "SELECT * FROM empleados e WHERE e.id = ? LIMIT 1;";
                        Object[] parametrosSQL_3 = {usuario.getIdEmpleado()};
                        rs_3 = db.queryConsultar(querySQL_3, parametrosSQL_3);

                        while (rs_3.next()) {
                            empleado.setIdEmpleado(rs_3.getInt("id"));
                            empleado.setIdPersona(rs_3.getInt("id_persona"));
                            empleado.setIdUsuario(rs_3.getInt("id_usuario"));
                            empleado.setEstado(rs_3.getString("estado"));
                            empleado.setFechaCreado(rs_3.getString("fecha_creado"));
                            empleado.setFechaActualizado(rs_3.getString("fecha_actualizado"));
                        }

                        /* OBTENER DATOS DE LA PERSONA */
                        querySQL_4 = "SELECT * FROM personas p WHERE p.id = ? LIMIT 1;";
                        Object[] parametrosSQL_4 = {usuario.getIdPersona()};
                        rs_4 = db.queryConsultar(querySQL_4, parametrosSQL_4);

                        while (rs_4.next()) {
                            empleado.setIdPersona(rs_4.getInt("id"));
                            empleado.setNombre(rs_4.getString("nombre"));
                            empleado.setApellidos(rs_4.getString("apellido"));
                            empleado.setTipoDocumento(rs_4.getInt("tipo_documento"));
                            empleado.setNroDocumento(rs_4.getString("nrodocumento"));
                            empleado.setSexo(rs_4.getString("sexo"));
                            empleado.setEdad(rs_4.getString("edad"));
                            empleado.setTelefono(rs_4.getString("telefono"));
                            empleado.setEstado(rs_4.getString("estado"));
                            empleado.setFechaCreado(rs_4.getString("fecha_creado"));
                            empleado.setFechaActualizado(rs_4.getString("fecha_actualizado"));
                        }

                        usuario.setEmpleado(empleado);
                        success = true;
                    }
                    break;
//                    case "cliente":
//                        usuario.setIdCliente(rs_2.getInt("id_clientess"));
//                        cliente = new Cliente();
//
//                        /* OBTENER DATOS DEL CLIENTE */
//                        querySQL_3 = "SELECT * FROM clientes c WHERE c.id = ? LIMIT 1;";
//                        Object[] parametrosSQL_3 = {usuario.getIdCliente()};
//                        rs_3 = db.queryConsultar(querySQL_3, parametrosSQL_3);
//
//                        while (rs_3.next()) {
//                            cliente.setIdCliente(rs_3.getInt("id"));
//                            cliente.setIdPersona(rs_3.getInt("id_persona"));
//                            cliente.setIdUsuario(rs_3.getInt("id_usuario"));
//                            cliente.setEstado(rs_3.getString("estado"));
//                            cliente.setFechaCreado(rs_3.getString("fecha_creado"));
//                            cliente.setFechaActualizado(rs_3.getString("fecha_actualizado"));
//                        }
//
//                        /* OBTENER DATOS DE LA PERSONA */
//                        querySQL_4 = "SELECT * FROM personas p WHERE p.id = ? LIMIT 1;";
//                        Object[] parametrosSQL_4 = {usuario.getIdPersona()};
//                        rs_4 = db.queryConsultar(querySQL_4, parametrosSQL_4);
//
//                        while (rs_4.next()) {
//                            cliente.setIdPersona(rs_4.getInt("id"));
//                            cliente.setNombre(rs_4.getString("nombre"));
//                            cliente.setApellidos(rs_4.getString("apellido"));
//                            cliente.setTipoDocumento(rs_4.getInt("tipo_documento"));
//                            cliente.setNroDocumento(rs_4.getString("nrodocumento"));
//                            cliente.setSexo(rs_4.getString("sexo"));
//                            cliente.setEdad(rs_4.getString("edad"));
//                            cliente.setTelefono(rs_4.getString("telefono"));
//                            cliente.setEstado(rs_4.getString("estado"));
//                            cliente.setFechaCreado(rs_4.getString("fecha_creado"));
//                            cliente.setFechaActualizado(rs_4.getString("fecha_actualizado"));
//                        }
//
//                        usuario.setCliente(cliente);
//
//                        success = true;
//
//                        break;
                    default:
                        throw new RuntimeException("Rol no permitido");
                }
            }

            // Actualizar nuevo usuario en sesión local
            UsuarioThreadLocal.set(usuario);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            db.cerrarConsulta();
        }

        return success;
    }

    public boolean logout() {
        boolean success = false;

        try {
            var usuario = UsuarioThreadLocal.get();

            // Eliminar usuario en sesión local
            if (usuario != null) {
                UsuarioThreadLocal.remove();
                success = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return success;
    }
}
