package Erpcompras.Views;

import Erpcompras.Datos.BaseDeDatos;
import Erpcompras.Models.SolicitudCompra;
import javax.swing.*;
import java.awt.*;

/**
 * Vista para buscar una solicitud por número y mostrar su detalle.
 */
public class BuscarSolicitudView extends BaseView {

    public BuscarSolicitudView() {
        super("Buscar Solicitud de Compra");

        // Panel “card” de BaseView
        JPanel card = (JPanel)((JPanel)getContentPane()).getComponent(0);
        card.setLayout(new BorderLayout(0, 20));

        // Título
        JLabel lblTitulo = new JLabel("Buscar Solicitud de Compra", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        card.add(lblTitulo, BorderLayout.NORTH);

        // Panel intermedio con formulario y resultados
        JPanel middle = new JPanel();
        middle.setOpaque(false);
        middle.setLayout(new BoxLayout(middle, BoxLayout.Y_AXIS));

        // Formulario: número + botón
        JPanel form = new JPanel(new BorderLayout(10, 0));
        form.setOpaque(false);
        JLabel lblNumero = new JLabel("Número de solicitud:");
        lblNumero.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        JTextField txtNumero = new JTextField();
        JButton btnBuscar = createButton("Buscar");
        form.add(lblNumero, BorderLayout.WEST);
        form.add(txtNumero, BorderLayout.CENTER);
        form.add(btnBuscar, BorderLayout.EAST);
        form.setAlignmentX(Component.CENTER_ALIGNMENT);

        middle.add(form);
        middle.add(Box.createRigidArea(new Dimension(0, 10)));

        // Área de texto para mostrar el detalle
        JTextArea txtResult = new JTextArea(6, 30);
        txtResult.setEditable(false);
        txtResult.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(txtResult);
        scroll.setAlignmentX(Component.CENTER_ALIGNMENT);
        middle.add(scroll);

        card.add(middle, BorderLayout.CENTER);

        // Botón Volver
        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        acciones.setOpaque(false);
        JButton btnVolver = createButton("Volver");
        acciones.add(btnVolver);
        card.add(acciones, BorderLayout.SOUTH);

        // Lógica de búsqueda
        btnBuscar.addActionListener(e -> {
            String text = txtNumero.getText().trim();
            try {
                int numero = Integer.parseInt(text);
                SolicitudCompra sc = BaseDeDatos.solicitudes.stream()
                        .filter(s -> s.getNumero() == numero)
                        .findFirst().orElse(null);
                if (sc != null) {
                    txtResult.setText(sc.toString());
                } else {
                    txtResult.setText("Solicitud #" + numero + " no encontrada.");
                }
            } catch (NumberFormatException ex) {
                txtResult.setText("Número inválido.");
            }
        });

        // Volver al menú
        btnVolver.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}