package controllers;

import core.services.ProductoService;
import models.Producto;

public class ProductoController extends BaseController<Producto, ProductoService> {

    public ProductoController() {
        lista.clear();
        service = new ProductoService();
    }

    public void cargarLista() {
        Producto p1 = new Producto(1, "Agua", 2.50, 30);
        Producto p2 = new Producto(2, "Gaseosa", 3.50, 20);
        Producto p3 = new Producto(3, "Vino", 30, 20);
        Producto p4 = new Producto(4, "Piqueo Snack", 3.50, 15);
        Producto p5 = new Producto(5, "Chocolate", 2, 20);
        Producto p6 = new Producto(6, "Gatorade", 3.50, 20);
        Producto p7 = new Producto(7, "Doritos", 3.50, 20);
        Producto p8 = new Producto(8, "Cerveza", 10, 30);

        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);
        lista.add(p7);
        lista.add(p8);
    }

    public double obtenerPrecio(String nombre) {
        for (Producto producto : lista) {
            if (nombre.equals(producto.getNombre())) {
                return producto.getPrecio();
            }
        }
        return 0;
    }

}
