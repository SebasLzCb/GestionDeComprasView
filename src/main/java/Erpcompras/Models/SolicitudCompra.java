package Erpcompras.Models;

import java.util.ArrayList;
import java.util.List;

public class SolicitudCompra {
    private int numero;
    private Proveedor proveedor;
    private List<DetalleSolicitud> detalles;
    private EstadoSolicitud estado;

    public SolicitudCompra(int numero, Proveedor proveedor) {
        this.numero = numero;
        this.proveedor = proveedor;
        this.detalles = new ArrayList<>();
        this.estado = EstadoSolicitud.PENDIENTE;
    }

    public int getNumero() {
        return numero;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }

    public void agregarDetalle(DetalleSolicitud detalle) {
        detalles.add(detalle);
    }

    public double calcularTotal() {
        double total = 0;
        for (DetalleSolicitud d : detalles) {
            total += d.calcularSubTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return "SolicitudCompra:" +
                "\nNúmero: " + numero +
                "\nProveedor: " + proveedor.getPersona().getNombre() + " " + proveedor.getPersona().getApellido() +
                "\nEmail: " + proveedor.getPersona().getEmail() +
                "\nEstado: " + estado +
                "\nTotal: " + calcularTotal();
    }
}
