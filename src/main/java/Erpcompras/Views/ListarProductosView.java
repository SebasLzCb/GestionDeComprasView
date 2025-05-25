package Erpcompras.Views;

import Erpcompras.Datos.BaseDeDatos;
import Erpcompras.Models.Producto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListarProductosView extends BaseView {

    public ListarProductosView() {
        super("Lista de Productos");

        // Panel “card” de BaseView
        JPanel card = (JPanel)((JPanel)getContentPane()).getComponent(0);
        card.setLayout(new BorderLayout(0, 20));

        // Título
        JLabel lblTitulo = new JLabel("Lista de Productos", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        card.add(lblTitulo, BorderLayout.NORTH);

        // Tabla con encabezados
        String[] columnas = {"ID", "Nombre", "Precio", "Unidad", "Proveedor"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override public boolean isCellEditable(int row, int col) { return false; }
        };

        // Poblar modelo desde BaseDeDatos
        for (Producto p : BaseDeDatos.productos) {
            modelo.addRow(new Object[]{
                    p.getId(),
                    p.getNombre(),
                    String.format("%.2f", p.getPrecioUnitario()),
                    p.getUnidad(),
                    p.getProveedor().getPersona().getNombre() + " " +
                            p.getProveedor().getPersona().getApellido()
            });
        }

        JTable tabla = new JTable(modelo);
        JScrollPane pane = new JScrollPane(tabla);
        // Reducir altura de la tabla para dejar espacio al botón
        pane.setPreferredSize(new Dimension(500, 200));
        card.add(pane, BorderLayout.CENTER);

        // Botón Volver
        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        acciones.setOpaque(false);
        acciones.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        JButton btnVolver = createButton("Volver");
        acciones.add(btnVolver);
        card.add(acciones, BorderLayout.SOUTH);

        btnVolver.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}