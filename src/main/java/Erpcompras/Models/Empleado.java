package Erpcompras.Models;

public class Empleado{
    private String nombre;
    private String apellido;
    private String dni;
    private int telefono;
    private Departamento departamento;

    public Empleado(){

    }

    public Empleado(String apellido, Departamento departamento, String nombre, String dni, String telefono) {
        this.apellido = apellido;
        this.departamento = departamento;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = 0;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        String infoDepartamento = (departamento != null) ? departamento.toString() : "Sin departamento";
        return nombre + " " + apellido + " " + dni + " " + telefono + " " + infoDepartamento;

    }
}

