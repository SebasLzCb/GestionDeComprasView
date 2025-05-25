package Erpcompras.Views;

import Erpcompras.Datos.BaseDeDatos;
import Erpcompras.Models.Proveedor;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListarProveedoresView extends BaseView {

    public ListarProveedoresView() {
        super("Lista de Proveedores");

        // Panel “card” de BaseView
        JPanel card = (JPanel)((JPanel)getContentPane()).getComponent(0);
        card.setLayout(new BorderLayout(0, 20));

        // Título
        JLabel lblTitulo = new JLabel("Lista de Proveedores", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        card.add(lblTitulo, BorderLayout.NORTH);

        // Configurar tabla con encabezados
        String[] columnas = {"ID", "Nombre", "Apellido", "DNI", "Teléfono", "Email"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override public boolean isCellEditable(int row, int col) { return false; }
        };

        // Llenar modelo desde BaseDeDatos
        for (Proveedor p : BaseDeDatos.proveedores) {
            modelo.addRow(new Object[]{
                    p.getId(),
                    p.getPersona().getNombre(),
                    p.getPersona().getApellido(),
                    p.getPersona().getDni(),
                    p.getPersona().getTelefono(),
                    p.getPersona().getEmail()
            });
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