package Erpcompras.Views;

import Erpcompras.Datos.BaseDeDatos;
import Erpcompras.Models.EstadoSolicitud;
import Erpcompras.Models.SolicitudCompra;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AprobarRechazarView extends BaseView {

    public AprobarRechazarView() {
        super("Aprobar / Rechazar Solicitud");

        // Panel “card” de BaseView
        JPanel card = (JPanel)((JPanel)getContentPane()).getComponent(0);

        // Título
        JLabel lblTitulo = new JLabel("Aprobar o Rechazar Solicitud", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        card.add(lblTitulo, BorderLayout.NORTH);

        // Selector de solicitudes pendientes
        JPanel center = new JPanel(new BorderLayout(0, 15));
        center.setOpaque(false);

        JComboBox<SolicitudCompra> cbSolicitudes = new JComboBox<>(
                BaseDeDatos.solicitudes.stream()
                        .filter(s -> s.getEstado() == EstadoSolicitud.PENDIENTE)
                        .toArray(SolicitudCompra[]::new)
        );
        cbSolicitudes.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list,
                                                          Object value,
                                                          int index,
                                                          boolean isSelected,
                                                          boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof SolicitudCompra sc) {
                    setText("Solicitud #" + sc.getNumero());
                }
                return this;
            }
        });
        center.add(cbSolicitudes, BorderLayout.NORTH);

        JTextArea resultadoArea = new JTextArea(5, 30);
        resultadoArea.setEditable(false);
        resultadoArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(resultadoArea);
        center.add(scroll, BorderLayout.CENTER);

        // Actualizar detalle al cambiar selección
        cbSolicitudes.addActionListener(e -> {
            SolicitudCompra sc = (SolicitudCompra)cbSolicitudes.getSelectedItem();
            resultadoArea.setText(sc != null ? sc.toString() : "");
        });
        // Inicializar texto
        if (cbSolicitudes.getItemCount() > 0) {
            cbSolicitudes.setSelectedIndex(0);
            resultadoArea.setText(((SolicitudCompra)cbSolicitudes.getItemAt(0)).toString());
        } else {
            resultadoArea.setText("No hay solicitudes pendientes.");
        }

        card.add(center, BorderLayout.CENTER);

        // Botones
        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        acciones.setOpaque(false);
        JButton btnAprobar  = createButton("Aprobar");
        JButton btnRechazar = createButton("Rechazar");
        JButton btnVolver   = createButton("Volver");
        acciones.add(btnAprobar);
        acciones.add(btnRechazar);
        acciones.add(btnVolver);
        card.add(acciones, BorderLayout.SOUTH);

        // Lógica de botones
        btnAprobar.addActionListener(e -> {
            SolicitudCompra sc = (SolicitudCompra)cbSolicitudes.getSelectedItem();
            if (sc != null) {
                sc.setEstado(EstadoSolicitud.APROBADA);
                JOptionPane.showMessageDialog(this,
                        "Solicitud #" + sc.getNumero() + " aprobada.",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });

        btnRechazar.addActionListener(e -> {
            SolicitudCompra sc = (SolicitudCompra)cbSolicitudes.getSelectedItem();
            if (sc != null) {
                sc.setEstado(EstadoSolicitud.RECHAZADA);
                JOptionPane.showMessageDialog(this,
                        "Solicitud #" + sc.getNumero() + " rechazada.",
                        "Información",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });

        btnVolver.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}