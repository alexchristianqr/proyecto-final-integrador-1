package controllers;

import core.services.ClienteService;
import javax.swing.table.DefaultTableModel;
import models.Cliente;

public class ClienteController extends BaseController<Cliente, ClienteService> {

    public ClienteController() {
        lista.clear();
        service = new ClienteService();
    }

    public DefaultTableModel listarClientes(String buscar) {
        DefaultTableModel modelo;
        String[] columnNames = {"Código", "Nombres", "Apellidos", "Tipo Doc.", "Nro Doc.", "Edad", "Sexo", "Telefono", "Estado", "Fecha creado", "Fecha actualizado"};
        Object[] data = new Object[columnNames.length];
        modelo = new DefaultTableModel(null, columnNames);
        modelo = service.listarClientes(modelo, data);
        return modelo;
    }

    public void crearCliente(Cliente cliente) {
        service.crearCliente(cliente);
    }

    public void actualizarCliente(Cliente cliente) {
        service.actualizarCliente(cliente);
    }
}
