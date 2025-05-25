package Erpcompras.Views;

import Erpcompras.Datos.BaseDeDatos;
import Erpcompras.Models.Proveedor;
import Erpcompras.Models.Persona;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProveedorView extends BaseView {
    public ProveedorView() {
        super("Registrar Proveedor");

        // Obtener el panel “card” creado por BaseView
        JPanel card = (JPanel)((JPanel)getContentPane()).getComponent(0);

        // Título
        JLabel lblTitulo = new JLabel("Registrar Proveedor", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        card.add(lblTitulo, BorderLayout.NORTH);

        // Formulario
        JPanel form = new JPanel(new GridLayout(0, 2, 10, 10));
        form.setOpaque(false);
        JTextField txtId    = new JTextField();
        JTextField txtNom   = new JTextField();
        JTextField txtApe   = new JTextField();
        JTextField txtDni   = new JTextField();
        JTextField txtTel   = new JTextField();
        JTextField txtEmail = new JTextField();

        form.add(new JLabel("ID:"));      form.add(txtId);
        form.add(new JLabel("Nombre:"));  form.add(txtNom);
        form.add(new JLabel("Apellido:"));//
        form.add(txtApe);
        form.add(new JLabel("DNI:"));     form.add(txtDni);
        form.add(new JLabel("Teléfono:"));//
        form.add(txtTel);
        form.add(new JLabel("Email:"));   form.add(txtEmail);

        card.add(form, BorderLayout.CENTER);

        // Botones
        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        acciones.setOpaque(false);
        JButton btnGuardar  = createButton("Guardar");
        JButton btnCancelar = createButton("Cancelar");
        acciones.add(btnGuardar);
        acciones.add(btnCancelar);
        card.add(acciones, BorderLayout.SOUTH);

        // Lógica de los botones
        btnGuardar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String nom  = txtNom.getText().trim();
                String ape  = txtApe.getText().trim();
                String dni  = txtDni.getText().trim();
                String tel  = txtTel.getText().trim();
                String mail = txtEmail.getText().trim();

                Persona persona = new Persona(nom, ape, dni, tel, mail);
                Proveedor proveedor = new Proveedor(id, persona);
                BaseDeDatos.proveedores.add(proveedor);

                JOptionPane.showMessageDialog(this,
                        "Proveedor registrado exitosamente.",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "ID inválido. Debe ser un número entero.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancelar.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}