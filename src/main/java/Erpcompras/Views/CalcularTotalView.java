package Erpcompras.Views;

import Erpcompras.Datos.BaseDeDatos;
import Erpcompras.Models.SolicitudCompra;
import javax.swing.*;
import java.awt.*;

/**
 * Vista para calcular el total de una solicitud existente.
 */
public class CalcularTotalView extends BaseView {

    public CalcularTotalView() {
        super("Calcular Total");

        // Panel “card” heredado de BaseView
        JPanel card = (JPanel)((JPanel)getContentPane()).getComponent(0);

        // Título
        JLabel lblTitulo = new JLabel("Calcular Total de Solicitud", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        card.add(lblTitulo, BorderLayout.NORTH);

        // Formulario
        JPanel form = new JPanel(new GridLayout(0, 2, 10, 10));
        form.setOpaque(false);

        // Selector de solicitud (solo muestra número)
        form.add(new JLabel("Número de solicitud:"));
        JComboBox<SolicitudCompra> cbSolicitud = new JComboBox<>(
                BaseDeDatos.solicitudes.toArray(new SolicitudCompra[0])
        );
        cbSolicitud.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list,
                                                          Object value,
                                                          int index,
                                                          boolean isSelected,
                                                          boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof SolicitudCompra sc) {
                    setText(String.valueOf(sc.getNumero()));
                }
                return this;
            }
        });
        form.add(cbSolicitud);

        // Campo para mostrar el total
        form.add(new JLabel("Total:"));
        JTextField txtTotal = new JTextField();
        txtTotal.setEditable(false);
        form.add(txtTotal);

        card.add(form, BorderLayout.CENTER);

        // Botones de acción
        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        acciones.setOpaque(false);
        JButton btnCalcular = createButton("Calcular");
        JButton btnVolver   = createButton("Volver");
        acciones.add(btnCalcular);
        acciones.add(btnVolver);
        card.add(acciones, BorderLayout.SOUTH);

        // Lógica de cálculo
        btnCalcular.addActionListener(e -> {
            SolicitudCompra sc = (SolicitudCompra) cbSolicitud.getSelectedItem();
            if (sc != null) {
                txtTotal.setText(String.format("%.2f", sc.calcularTotal()));
            }
        });

        // Cierra ventana y reabre menú
        btnVolver.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}