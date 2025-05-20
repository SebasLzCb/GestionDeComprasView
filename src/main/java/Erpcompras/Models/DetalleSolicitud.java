package Erpcompras.Models;

public class DetalleSolicitud {
    private Producto producto;
    private int cantidad;

    public DetalleSolicitud(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double calcularSubTotal() {
        return producto.getPrecioUnitario() * cantidad;
    }

    @Override
    public String toString() {
        return "Detalle{" +
                "producto=" + producto.getNombre() +
                ", cantidad=" + cantidad +
                ", subtotal=" + calcularSubTotal() +
                '}';
    }
}
