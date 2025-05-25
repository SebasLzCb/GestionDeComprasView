package Erpcompras.Views;

import Erpcompras.Datos.BaseDeDatos;
import Erpcompras.Models.Producto;
import javax.swing.*;
import java.awt.*;

public class BuscarProductoView extends BaseView {

    public BuscarProductoView() {
        super("Buscar Producto");

        JPanel card = (JPanel)((JPanel)getContentPane()).getComponent(0);
        card.setLayout(new BorderLayout(0, 20));

        // 1) Título
        JLabel lblTitulo = new JLabel("Buscar Producto", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        card.add(lblTitulo, BorderLayout.NORTH);

        // 2) Centro: formulario + resultados
        JPanel center = new JPanel();
        center.setOpaque(false);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Formulario
        JPanel form = new JPanel(new BorderLayout(10, 10));
        form.setOpaque(false);
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        JTextField txtNombre = new JTextField();
        JButton btnBuscar = createButton("Buscar");
        form.add(lblNombre, BorderLayout.WEST);
        form.add(txtNombre, BorderLayout.CENTER);
        form.add(btnBuscar, BorderLayout.EAST);

        // Área de resultados
        JTextArea txtResult = new JTextArea(6, 30);
        txtResult.setEditable(false);
        txtResult.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(txtResult);

        center.add(form);
        center.add(Box.createRigidArea(new Dimension(0, 10)));
        center.add(scroll);

        card.add(center, BorderLayout.CENTER);

        // 3) Botón Volver debajo
        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        acciones.setOpaque(false);
        JButton btnVolver = createButton("Volver");
        acciones.add(btnVolver);
        card.add(acciones, BorderLayout.SOUTH);

        // Lógica de búsqueda
        btnBuscar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            Producto prod = BaseDeDatos.productos.stream()
                    .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                    .findFirst().orElse(null);
            txtResult.setText(
                    prod != null
                            ? prod.toString()
                            : "Producto \"" + nombre + "\" no encontrado."
            );
        });

        // Lógica de volver
        btnVolver.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
