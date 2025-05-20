package Erpcompras.Models;

public class Departamento {
    private String nombre;
    private String codigo;

    public Departamento(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;

    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    @Override
    public String toString() {
        return nombre + " (Código: " + codigo + ")";
    }
}
