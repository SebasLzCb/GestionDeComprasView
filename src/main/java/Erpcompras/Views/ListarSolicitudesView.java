package Erpcompras.Views;

import Erpcompras.Datos.BaseDeDatos;
import Erpcompras.Models.SolicitudCompra;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListarSolicitudesView extends BaseView {

    public ListarSolicitudesView() {
        super("Lista de Solicitudes");

        // Panel “card” de BaseView
        JPanel card = (JPanel)((JPanel)getContentPane()).getComponent(0);
        card.setLayout(new BorderLayout(0, 20));

        // Título
        JLabel lblTitulo = new JLabel("Lista de Solicitudes", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        card.add(lblTitulo, BorderLayout.NORTH);

        // Configurar tabla con encabezados
        String[] columnas = {"#", "Número", "Proveedor", "Email", "Estado", "Total"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override public boolean isCellEditable(int row, int col) { return false; }
        };

        // Llenar modelo desde BaseDeDatos
        int idx = 1;
        for (SolicitudCompra s : BaseDeDatos.solicitudes) {
            modelo.addRow(new Object[]{
                    idx++,
                    s.getNumero(),
                    s.getProveedor().getPersona().getNombre() + " " +
                            s.getProveedor().getPersona().getApellido(),
                    s.getProveedor().getPersona().getEmail(),
                    s.getEstado(),
                    String.format("%.2f", s.calcularTotal())
            });
        }

        // Si no hay datos, mostrar mensaje
        if (modelo.getRowCount() == 0) {
            modelo.addRow(new Object[]{"", "", "No hay solicitudes registradas.", "", "", ""});
        }

        JTable tabla = new JTable(modelo);
        JScrollPane pane = new JScrollPane(tabla);
        pane.setPreferredSize(new Dimension(500, 250));
        card.add(pane, BorderLayout.CENTER);

        // Botón Volver
        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        acciones.setOpaque(false);
        JButton btnVolver = createButton("Volver");
        acciones.add(btnVolver);
        card.add(acciones, BorderLayout.SOUTH);

        btnVolver.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}