package services;

import core.services.MysqlDBService;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import models.Producto;

public class ProductoService extends BaseService {

    public ProductoService() {
        db = new MysqlDBService();
    }

    public DefaultTableModel listarProductos(DefaultTableModel modelo, Object[] data) {
        querySQL_1 = "SELECT id, descripcion, precio, cantidad_stock, estado, fecha_creado, fecha_actualizado FROM productos";
        Object[] parametrosSQL_1 = {};
        ResultSet rs = db.queryConsultar(querySQL_1, parametrosSQL_1);

        try {
            while (rs.next()) {
                data[0] = rs.getInt("id");
                data[1] = rs.getString("descripcion");
                data[2] = rs.getString("precio");
                data[3] = rs.getString("cantidad_stock");
                data[4] = rs.getString("estado");
                data[5] = rs.getString("fecha_creado");
                data[6] = rs.getString("fecha_actualizado");
                modelo.addRow(data);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        db.cerrarConsulta();
        return modelo;
    }

    // Método para agregar un nuevo producto
    public void agregarProducto(Producto producto) {
        querySQL_1 = "INSERT INTO productos (descripcion, precio, cantidad_stock) VALUES (?, ?, ?)";
        Object[] parametros = {
            producto.getDescripcion(),
            producto.getPrecio(),
            producto.getCantidadStock()
        };

        db.queryInsertar(querySQL_1, parametros);
        db.cerrarConsulta();
    }

    // Método para actualizar un producto existente
    public void actualizarProducto(Producto producto) {
        querySQL_1 = "UPDATE productos SET descripcion = ?, precio = ?, cantidad_stock = ?, fecha_actualizado = CURRENT_TIMESTAMP WHERE id = ?";
        Object[] parametros = {
            producto.getDescripcion(),
            producto.getPrecio(),
            producto.getCantidadStock(),
            producto.getIdProducto(),
        };

        db.queryActualizar(querySQL_1, parametros);
        db.cerrarConsulta();
    }

    // Método para eliminar un producto por su código
    public void eliminarProducto(Producto producto) {
        querySQL_1 = "DELETE FROM productos WHERE id = ?";
        Object[] parametros = {producto.getIdProducto()};

        db.queryEliminar(querySQL_1, parametros);
        db.cerrarConsulta();
    }
}
