package Erpcompras.Views;

import Erpcompras.Datos.BaseDeDatos;
import Erpcompras.Models.Proveedor;
import javax.swing.*;
import java.awt.*;

public class BuscarProveedorView extends BaseView {

    public BuscarProveedorView() {
        super("Buscar Proveedor");

        // Panel “card” de BaseView
        JPanel card = (JPanel)((JPanel)getContentPane()).getComponent(0);
        card.setLayout(new BorderLayout(0, 20));

        // Título
        JLabel lblTitulo = new JLabel("Buscar Proveedor", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        card.add(lblTitulo, BorderLayout.NORTH);

        // Formulario y resultados en un solo panel central
        JPanel center = new JPanel(new BorderLayout(0, 15));
        center.setOpaque(false);

        // Formulario: etiqueta, campo y botón Buscar
        JPanel form = new JPanel(new BorderLayout(10, 0));
        form.setOpaque(false);
        JLabel lblId = new JLabel("ID:");
        lblId.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        JTextField txtId = new JTextField();
        JButton btnBuscar = createButton("Buscar");
        form.add(lblId, BorderLayout.WEST);
        form.add(txtId, BorderLayout.CENTER);
        form.add(btnBuscar, BorderLayout.EAST);

        center.add(form, BorderLayout.NORTH);

        // Área de texto para mostrar el resultado
        JTextArea txtResult = new JTextArea(6, 30);
        txtResult.setEditable(false);
        txtResult.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(txtResult);
        center.add(scroll, BorderLayout.CENTER);

        card.add(center, BorderLayout.CENTER);

        // Botones de acción: Buscar y Volver
        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        acciones.setOpaque(false);
        JButton btnVolver = createButton("Volver");
        acciones.add(btnVolver);
        card.add(acciones, BorderLayout.SOUTH);

        // Lógica del botón Buscar
        btnBuscar.addActionListener(e -> {
            String text = txtId.getText().trim();
            try {
                int id = Integer.parseInt(text);
                Proveedor prov = BaseDeDatos.proveedores.stream()
                        .filter(p -> p.getId() == id)
                        .findFirst()
                        .orElse(null);
                if (prov != null) {
                    txtResult.setText(prov.toString());
                } else {
                    txtResult.setText("Proveedor con ID " + id + " no encontrado.");
                }
            } catch (NumberFormatException ex) {
                txtResult.setText("ID inválido. Debe ser un número.");
            }
        });

        // Lógica del botón Volver
        btnVolver.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}