package models;

public class Producto {

    private int idProducto;
    private String descripcion;
    private double precio;
    private int cantidadStock;
    private String estado;

    public Producto() {
    }

    public Producto(Producto producto) {
        this.idProducto = producto.getIdProducto();
        this.descripcion = producto.getDescripcion();
        this.precio = producto.getPrecio();
        this.cantidadStock = producto.getCantidadStock();
        this.estado = producto.getEstado();
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
