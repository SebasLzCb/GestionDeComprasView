package Erpcompras.Views;

import Erpcompras.Models.*;
import java.awt.*;
import java.awt.event.*;

public class ProveedorView {
    private Frame frame;
    private TextField txtId, txtNombre, txtApellido, txtDni, txtTelefono, txtEmail;
    private Label resultadoLabel;

    public ProveedorView() {
        frame = new Frame("📦 Registro de Proveedor");
        frame.setLayout(new GridLayout(9, 2, 5, 5)); // 9 filas, 2 columnas con espaciado

        // Crear y agregar los campos de entrada con etiquetas centradas
        txtId = addCenteredLabelAndTextField("ID:");
        txtNombre = addCenteredLabelAndTextField("Nombre:");
        txtApellido = addCenteredLabelAndTextField("Apellido:");
        txtDni = addCenteredLabelAndTextField("DNI:");
        txtTelefono = addCenteredLabelAndTextField("Teléfono:");
        txtEmail = addCenteredLabelAndTextField("Email:");

        // Espacio vacío para centrar botón
        frame.add(new Label(""));

        // Botón centrado
        Panel buttonPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        Button btnRegistrar = new Button("Registrar");
        buttonPanel.add(btnRegistrar);
        frame.add(buttonPanel);

        // Label de resultado
        frame.add(new Label("Resultado:", Label.CENTER));
        resultadoLabel = new Label("", Label.CENTER);
        frame.add(resultadoLabel);

        // Acción del botón
        btnRegistrar.addActionListener(e -> registrarProveedor());

        // Configuración general
        frame.setSize(450, 400);
        frame.setVisible(true);

        // Manejo de cierre
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                new MenuPrincipalView();
            }
        });
    }

    // Método para crear etiquetas y campos de texto con etiquetas centradas
    private TextField addCenteredLabelAndTextField(String labelText) {
        Label label = new Label(labelText, Label.CENTER);
        TextField textField = new TextField();
        frame.add(label);
        frame.add(textField);
        return textField;
    }

    // Lógica del registro
    private void registrarProveedor() {
        try {
            if (txtId.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty()
                    || txtDni.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtEmail.getText().isEmpty()) {
                resultadoLabel.setText("Todos los campos son obligatorios.");
                return;
            }

            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String dni = txtDni.getText();
            String telefono = txtTelefono.getText();
            String email = txtEmail.getText();

            Persona persona = new Persona(nombre, apellido, dni, telefono, email);
            Proveedor proveedor = new Proveedor(id, persona);

            resultadoLabel.setText("Proveedor registrado correctamente.");
        } catch (NumberFormatException nfe) {
            resultadoLabel.setText("ID debe ser un número entero.");
        } catch (Exception ex) {
            resultadoLabel.setText("Error al registrar: " + ex.getMessage());
        }
    }
}
