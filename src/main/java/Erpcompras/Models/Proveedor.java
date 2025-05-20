package Erpcompras.Models;

public class Proveedor {
    private int id;
    private Persona persona;

    public Proveedor(int id, Persona persona) {
        this.id = id;
        this.persona = persona;
    }

    public int getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Proveedor:" +
                "\nID: " + id +
                "\nNombre: " + persona.getNombre() + " " + persona.getApellido() +
                "\nDNI: " + persona.getDni() +
                "\nTeléfono: " + persona.getTelefono() +
                "\nEmail: " + persona.getEmail();
    }
}
