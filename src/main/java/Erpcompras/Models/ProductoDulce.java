package Erpcompras.Models;

public class ProductoDulce extends Producto {
    private String sabor;
    private Proveedor proveedor;

    public ProductoDulce(int id, String nombre, double precio, UnidadMedida unidad, String sabor, Proveedor proveedor) {
        super(id, nombre, precio, unidad);
        this.sabor = sabor;
        this.proveedor = proveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    @Override
    public double calcularSubTotal() {
        return getPrecioUnitario();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSabor: " + sabor +
                "\nProveedor: " + (proveedor != null
                ? proveedor.getPersona().getNombre() + " " + proveedor.getPersona().getApellido()
                : "Sin proveedor asignado");
    }
}
