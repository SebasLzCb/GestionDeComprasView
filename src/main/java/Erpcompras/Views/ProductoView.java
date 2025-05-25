package Erpcompras.Views;

import Erpcompras.Datos.BaseDeDatos;
import Erpcompras.Models.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProductoView extends BaseView {

    public ProductoView() {
        super("Registrar Producto");

        // Obtener el panel “card” de BaseView
        JPanel card = (JPanel)((JPanel)getContentPane()).getComponent(0);

        // Título
        JLabel lblTitulo = new JLabel("Registrar Producto", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        card.add(lblTitulo, BorderLayout.NORTH);

        // Formulario
        JPanel form = new JPanel(new GridLayout(0, 2, 10, 10));
        form.setOpaque(false);

        JTextField txtId       = new JTextField();
        JTextField txtNombre   = new JTextField();
        JTextField txtPrecio   = new JTextField();
        JComboBox<UnidadMedida> cbUnidad    = new JComboBox<>(UnidadMedida.values());

        // JComboBox de proveedores, pero mostrando solo nombre y apellido
        JComboBox<Proveedor> cbProveedor = new JComboBox<>(BaseDeDatos.proveedores.toArray(new Proveedor[0]));
        cbProveedor.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list,
                                                          Object value,
                                                          int index,
                                                          boolean isSelected,
                                                          boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Proveedor p) {
                    setText(p.getPersona().getNombre() + " " + p.getPersona().getApellido());
                }
                return this;
            }
        });

        JComboBox<TipoProducto> cbTipo      = new JComboBox<>(TipoProducto.values());
        JLabel lblExtra        = new JLabel("Atributo:");
        JTextField txtExtra    = new JTextField();

        form.add(new JLabel("ID:"));               form.add(txtId);
        form.add(new JLabel("Nombre:"));           form.add(txtNombre);
        form.add(new JLabel("Precio unitario:"));  form.add(txtPrecio);
        form.add(new JLabel("Unidad de medida:")); form.add(cbUnidad);
        form.add(new JLabel("Proveedor:"));        form.add(cbProveedor);
        form.add(new JLabel("Tipo de producto:")); form.add(cbTipo);
        form.add(lblExtra);                        form.add(txtExtra);

        card.add(form, BorderLayout.CENTER);

        // Ajustar etiqueta y campo extra según tipo
        cbTipo.addActionListener(e -> {
            TipoProducto t = (TipoProducto)cbTipo.getSelectedItem();
            switch (t) {
                case COSMETICO -> lblExtra.setText("Marca:");
                case DULCE      -> lblExtra.setText("Sabor:");
                case PERIFERICO -> lblExtra.setText("Conexión:");
                default         -> lblExtra.setText("N/A:");
            }
            txtExtra.setEnabled(t != TipoProducto.SIMPLE);
            txtExtra.setText("");
        });

        // Botones
        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        acciones.setOpaque(false);
        JButton btnGuardar  = createButton("Guardar");
        JButton btnCancelar = createButton("Cancelar");
        acciones.add(btnGuardar);
        acciones.add(btnCancelar);
        card.add(acciones, BorderLayout.SOUTH);

        // Lógica de guardado
        btnGuardar.addActionListener(e -> {
            try {
                int id       = Integer.parseInt(txtId.getText().trim());
                String nombre= txtNombre.getText().trim();
                double precio= Double.parseDouble(txtPrecio.getText().trim());
                UnidadMedida unidad = (UnidadMedida)cbUnidad.getSelectedItem();
                Proveedor prov      = (Proveedor)cbProveedor.getSelectedItem();
                TipoProducto tipo   = (TipoProducto)cbTipo.getSelectedItem();
                String extra        = txtExtra.getText().trim();

                Producto p = switch (tipo) {
                    case COSMETICO ->
                            new ProductoCosmetico(id, nombre, precio, unidad, extra, prov);
                    case DULCE ->
                            new ProductoDulce(id, nombre, precio, unidad, extra, prov);
                    case PERIFERICO ->
                            new ProductoPeriferico(id, nombre, precio, unidad, extra, prov);
                    default ->
                            new ProductoSimple(id, nombre, precio, unidad, prov);
                };

                BaseDeDatos.productos.add(p);
                JOptionPane.showMessageDialog(this,
                        "Producto registrado exitosamente.",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "ID o precio inválido. Verifica los valores.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Error al registrar: " + ex.getMessage(),
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