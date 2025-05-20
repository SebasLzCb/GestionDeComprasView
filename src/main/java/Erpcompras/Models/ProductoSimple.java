package Erpcompras.Models;

public class ProductoSimple extends Producto {
    private Proveedor proveedor;

    public ProductoSimple(int id, String nombre, double precioUnitario, UnidadMedida unidad, Proveedor proveedor) {
        super(id, nombre, precioUnitario, unidad);
        this.proveedor = proveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public double calcularSubTotal() {
        return getPrecioUnitario();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n(Tipo: ProductoSimple)" +
                "\nProveedor: " + (proveedor != null
                ? proveedor.getPersona().getNombre() + " " + proveedor.getPersona().getApellido()
                : "Sin proveedor asignado");
    }
}
