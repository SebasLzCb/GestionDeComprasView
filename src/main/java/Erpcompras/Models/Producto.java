package Erpcompras.Models;

public abstract class Producto implements Calculable {
    private int id;
    private String nombre;
    private double precioUnitario;
    private UnidadMedida unidad;
    private Proveedor proveedor;

    public Producto(int id, String nombre, double precioUnitario, UnidadMedida unidad) {
        this.id = id;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.unidad = unidad;

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public UnidadMedida getUnidad() {
        return unidad;
    }

    public abstract double calcularSubTotal();

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    @Override
    public double calcularCostoTotal() {
        return calcularSubTotal(); // o una lógica más específica
    }

    @Override
    public String toString() {
        return "Producto{" +
                "\nid=" + id +
                "\nnombre='" + nombre + '\'' +
                "\nprecioUnitario=" + precioUnitario +
                "\nunidad=" + unidad +
                '}';
    }
}
