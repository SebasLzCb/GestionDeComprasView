package Erpcompras.Models;

import java.util.GregorianCalendar;

public class HistorialSolicitud {
    private int id;
    private String estadoNuevo;
    private GregorianCalendar fechaCambio;

    public HistorialSolicitud(int id, String estadoNuevo, GregorianCalendar fechaCambio) {
        this.id = id;
        this.estadoNuevo = estadoNuevo;
        this.fechaCambio = fechaCambio;
    }

    public String getId() {
        return "ID Historial: " + id + ", Estado: " + estadoNuevo + ", Fecha: " + fechaCambio.getTime();
    }
}
