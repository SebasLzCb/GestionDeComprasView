package Erpcompras.Models;

public class ProductoCosmetico extends Producto {
    private String descripcion;
    private Proveedor proveedor;

    public ProductoCosmetico(int id, String nombre, double precio, UnidadMedida unidad, String descripcion, Proveedor proveedor) {
        super(id, nombre, precio, unidad);
        this.descripcion = descripcion;
        this.proveedor = proveedor;
    }

    public ProductoCosmetico(int id, String nombre, double precio, UnidadMedida unidad) {
        super(id, nombre, precio, unidad);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public double calcularSubTotal() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nDescripción: " + descripcion +
                "\nProveedor: " + (proveedor != null
                ? proveedor.getPersona().getNombre() + " " + proveedor.getPersona().getApellido()
                : "Sin proveedor asignado");
    }
}
