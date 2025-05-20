package Erpcompras.Models;

public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;

    public Persona(String nombre, String apellido, String dni, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getTelefono() { return telefono; }
    public void setTelefono(int telefono) { this.telefono = String.valueOf(telefono); }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (DNI: " + dni + ", Email: " + email + ")";
    }
}
