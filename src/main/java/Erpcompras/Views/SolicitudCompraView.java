package Erpcompras.Views;

import Erpcompras.Models.Empleado;
import Erpcompras.Models.Persona;
import Erpcompras.Models.Proveedor;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolicitudCompraView {
    private Frame frame;
    private TextField txtNumero, txtCedula;
    private Button btnCrear, btnLimpiar;

    // Listas de ejemplo
    private List<Empleado> empleados;
    private List<Proveedor> proveedores;

    public SolicitudCompraView() {
        // Crear ventana
        frame = new Frame("Registrar Solicitud de Compra");
        frame.setLayout(new GridLayout(4, 2));

        // Etiquetas y campos
        frame.add(new Label("Número Solicitud:"));
        txtNumero = new TextField();
        frame.add(txtNumero);

        frame.add(new Label("Cédula (Empleado o Proveedor):"));
        txtCedula = new TextField();
        frame.add(txtCedula);

        // Botones
        btnCrear = new Button("Crear Solicitud");
        btnLimpiar = new Button("Limpiar");
        frame.add(btnCrear);
        frame.add(btnLimpiar);

        // Acciones
        btnCrear.addActionListener(e -> {
            String numero = txtNumero.getText();
            String cedula = txtCedula.getText();

            Empleado empleado = buscarEmpleado(cedula);
            if (empleado != null) {
                System.out.println("✅ Solicitud número " + numero + " creada por el empleado: " +
                        empleado.getNombre() + " " + empleado.getApellido());
                return;
            }

            Proveedor proveedor = buscarProveedor(cedula);
            if (proveedor != null) {
                System.out.println("✅ Solicitud número " + numero + " creada para el proveedor: " +
                        proveedor.getPersona().getNombre() + " " + proveedor.getPersona().getApellido());
                return;
            }

            System.out.println("❌ La cédula ingresada no corresponde a ningún empleado ni proveedor.");
        });

        btnLimpiar.addActionListener(e -> {
            txtNumero.setText("");
            txtCedula.setText("");
        });

        frame.setSize(400, 200);
        frame.setVisible(true);
    }

    private Empleado buscarEmpleado(String dni) {
        return empleados.stream()
                .filter(emp -> emp.getDni().equals(dni))
                .findFirst()
                .orElse(null);
    }

    private Proveedor buscarProveedor(String dni) {
        return proveedores.stream()
                .filter(prov -> prov.getPersona().getDni().equals(dni))
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) {
        new SolicitudCompraView();
    }
}
