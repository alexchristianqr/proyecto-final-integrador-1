package controllers;

import javax.swing.table.DefaultTableModel;
import services.ProductoService;
import models.Producto;

public class ProductoController extends BaseController<Producto, ProductoService> {

    public ProductoController() {
        lista.clear();
        service = new ProductoService();
    }

    public DefaultTableModel listarProductos(String buscar) {
        DefaultTableModel modelo;
        String[] columnNames = {"Codigo", "Descripcion", "Precio", "Cantidad", "Estado", "Fecha creado", "Fecha actualizado"};
        Object[] data = new Object[columnNames.length];
        modelo = new DefaultTableModel(null, columnNames);
        modelo = service.listarProductos(modelo, data);
        return modelo;
    }

    public void crearProducto(Producto producto) {
        service.agregarProducto(producto);
    }

    public void actualizarProducto(Producto producto) {
        service.actualizarProducto(producto);
    }

    public void eliminarProducto(Producto producto) {
        service.eliminarProducto(producto);
    }

    public double obtenerPrecio(String nombre) {
        for (Producto producto : lista) {
            if (nombre.equals(producto.getDescripcion())) {
                return producto.getPrecio();
            }
        }
        return 0;
    }

}
