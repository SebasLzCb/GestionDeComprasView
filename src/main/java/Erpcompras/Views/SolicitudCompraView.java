// SolicitudCompraView.java
package Erpcompras.Views;

import Erpcompras.Datos.BaseDeDatos;
import Erpcompras.Models.DetalleSolicitud;
import Erpcompras.Models.Producto;
import Erpcompras.Models.Proveedor;
import Erpcompras.Models.SolicitudCompra;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class SolicitudCompraView extends BaseView {
    public SolicitudCompraView() {
        super("Registrar Solicitud de Compra");

        JPanel card = (JPanel)((JPanel)getContentPane()).getComponent(0);

        // Título
        JLabel lblTitulo = new JLabel("Registrar Solicitud de Compra", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        card.add(lblTitulo, BorderLayout.NORTH);

        // Panel central para formulario y tabla
        JPanel center = new JPanel(new BorderLayout(0, 20));
        center.setOpaque(false);

        // Formulario de ingreso
        JPanel form = new JPanel(new GridLayout(0, 2, 10, 10));
        form.setOpaque(false);
        JTextField txtNumero = new JTextField();
        JComboBox<Proveedor> cbProveedor = new JComboBox<>(BaseDeDatos.proveedores.toArray(new Proveedor[0]));
        cbProveedor.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Proveedor p) {
                    setText(p.getPersona().getNombre() + " " + p.getPersona().getApellido());
                }
                return this;
            }
        });
        JComboBox<Producto> cbProducto = new JComboBox<>(BaseDeDatos.productos.toArray(new Producto[0]));
        cbProducto.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Producto p) {
                    setText(p.getNombre());
                }
                return this;
            }
        });
        JTextField txtCantidad = new JTextField();

        form.add(new JLabel("Número:"));        form.add(txtNumero);
        form.add(new JLabel("Proveedor:"));     form.add(cbProveedor);
        form.add(new JLabel("Producto:"));      form.add(cbProducto);
        form.add(new JLabel("Cantidad:"));      form.add(txtCantidad);

        center.add(form, BorderLayout.NORTH);

        // Tabla de detalles
        String[] cols = {"Producto", "Cantidad"};
        DefaultTableModel model = new DefaultTableModel(cols, 0) {
            @Override public boolean isCellEditable(int row, int col) { return false; }
        };
        JTable table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(400, 150));
        center.add(scroll, BorderLayout.CENTER);

        // Botón para agregar detalle
        JButton btnAgregar = createButton("Agregar Detalle");
        btnAgregar.addActionListener(e -> {
            Producto prod = (Producto)cbProducto.getSelectedItem();
            String cantStr = txtCantidad.getText().trim();
            try {
                int cantidad = Integer.parseInt(cantStr);
                model.addRow(new Object[]{ prod.getNombre(), cantidad });
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Cantidad inválida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        JPanel addPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addPanel.setOpaque(false);
        addPanel.add(btnAgregar);
        center.add(addPanel, BorderLayout.SOUTH);

        card.add(center, BorderLayout.CENTER);

        // Botones finales Guardar/Cancelar
        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        acciones.setOpaque(false);
        JButton btnGuardar  = createButton("Guardar Solicitud");
        JButton btnCancelar = createButton("Cancelar");
        acciones.add(btnGuardar);
        acciones.add(btnCancelar);
        card.add(acciones, BorderLayout.SOUTH);

        btnGuardar.addActionListener(e -> {
            try {
                int numero = Integer.parseInt(txtNumero.getText().trim());
                Proveedor prov = (Proveedor)cbProveedor.getSelectedItem();
                List<DetalleSolicitud> detalles = new ArrayList<>();
                for (int i = 0; i < model.getRowCount(); i++) {
                    int finalI = i;
                    Producto pr = BaseDeDatos.productos.stream()
                            .filter(p -> p.getNombre().equals(model.getValueAt(finalI,0)))
                            .findFirst().orElse(null);
                    int cant = (Integer)model.getValueAt(i,1);
                    detalles.add(new DetalleSolicitud(pr, cant));
                }
                SolicitudCompra sc = new SolicitudCompra(numero, prov, detalles);
                BaseDeDatos.solicitudes.add(sc);
                JOptionPane.showMessageDialog(this, "Solicitud registrada.");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Número inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancelar.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}