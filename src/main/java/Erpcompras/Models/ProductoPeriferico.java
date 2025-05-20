package Erpcompras.Models;

public class ProductoPeriferico extends Producto {
    private String tipo;
    private Proveedor proveedor;

    public ProductoPeriferico(int id, String nombre, double precio, UnidadMedida unidad, String tipo, Proveedor proveedor) {
        super(id, nombre, precio, unidad);
        this.tipo = tipo;
        this.proveedor = proveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public double calcularSubTotal() {
        return getPrecioUnitario();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTipo periférico: " + tipo +
                "\nProveedor: " + (proveedor != null
                ? proveedor.getPersona().getNombre() + " " + proveedor.getPersona().getApellido()
                : "Sin proveedor asignado");
    }
}
