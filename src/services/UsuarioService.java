package services;

import core.services.MysqlDBService;
import models.Cliente;
import models.Empleado;
import models.Usuario;

public class UsuarioService extends BaseService {
    
    public UsuarioService() {
        db = new MysqlDBService();
    }

    public boolean registrarUsuario(Usuario usuario) {
        boolean success = false;

        try {

            // Validaciones de entrada
            if (usuario == null || usuario.getNombres() == null || usuario.getApellidos() == null || usuario.getRol() == null || usuario.getUsername() == null || usuario.getPassword() == null) {
                throw new IllegalArgumentException("Datos del usuario incompletos o nulos.");
            }

            String rol = usuario.getRol();

            // Insertar usuario
            querySQL_1 = "INSERT INTO usuarios (nombres, apellidos, rol, username, pwd) VALUES (?,?,?,?,?)";
            Object[] parametrosSQL_1 = {usuario.getNombres(), usuario.getApellidos(), rol, usuario.getUsername(), usuario.getPassword()};
            int id_usuario = db.queryInsertar(querySQL_1, parametrosSQL_1);

            if (id_usuario > 0) {
                switch (rol) {
                    case "cliente" :{
                        // Insertar candidato
                        ClienteService clienteService = new ClienteService();
                        Cliente cliente = new Cliente();
//                        cliente.setIdUsuario(id_usuario);
                        cliente.setNombre(usuario.getNombres());
                        cliente.setApellidos(usuario.getApellidos());
                        cliente.setEstado("activo");
                        clienteService.crearCliente(cliente);

                        success = true;
                        break;
                    }
                    case "empleado" : {
                        // Insertar reclutador
                        EmpleadoService empleadoService = new EmpleadoService();
                        Empleado empleado = new Empleado();
                        empleado.setIdUsuario(id_usuario);
                        empleado.setNombre(usuario.getNombres());
                        empleado.setApellidos(usuario.getApellidos());
                        empleadoService.crearEmpleado(empleado);

                        success = true;
                        break;
                    }
                    default :
                        throw new AssertionError();
                }
            } else {
                throw new RuntimeException("No se pudo insertar el usuario en la base de datos.");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al registrar el usuario: " + e.getMessage(), e);
        } finally {
            db.cerrarConsulta();
        }

        return success;
    }
}
