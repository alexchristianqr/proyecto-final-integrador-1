package services;

import core.services.MysqlDBService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Producto;

public class ProductoService extends BaseService {

    public ProductoService() {
        db = new MysqlDBService();
    }

    // Método para listar todos los productos
    public List<Producto> listarProductos() {
        List<Producto> productos = new ArrayList<>();
        querySQL_1 = "SELECT codigo, nombre, precio, cantidad FROM productos";
        ResultSet rs = db.queryConsultar(querySQL_1, new Object[]{});

        try {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCodigo(rs.getInt("codigo"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
                productos.add(producto);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error al listar productos", ex);
        } finally {
            db.cerrarConsulta();
        }

        return productos;
    }

    // Método para agregar un nuevo producto
    public void agregarProducto(Producto producto) {
        querySQL_1 = "INSERT INTO productos (codigo, nombre, precio, cantidad) VALUES (?, ?, ?, ?)";
        Object[] parametros = {
            producto.getCodigo(),
            producto.getNombre(),
            producto.getPrecio(),
            producto.getCantidad()
        };

        db.queryInsertar(querySQL_1, parametros);
        db.cerrarConsulta();
    }

    // Método para actualizar un producto existente
    public void actualizarProducto(Producto producto) {
        querySQL_1 = "UPDATE productos SET nombre = ?, precio = ?, cantidad = ? WHERE codigo = ?";
        Object[] parametros = {
            producto.getNombre(),
            producto.getPrecio(),
            producto.getCantidad(),
            producto.getCodigo()
        };

        db.queryActualizar(querySQL_1, parametros);
        db.cerrarConsulta();
    }

    // Método para eliminar un producto por su código
    public void eliminarProducto(int codigo) {
        querySQL_1 = "DELETE FROM productos WHERE codigo = ?";
        Object[] parametros = {codigo};

        db.queryEliminar(querySQL_1, parametros);
        db.cerrarConsulta();
    }
}
