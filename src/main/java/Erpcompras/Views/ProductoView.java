package Erpcompras.Views;

import Erpcompras.Models.*;
import java.awt.*;
import java.awt.event.*;

public class ProductoView {
    private Frame frame;
    private TextField txtId, txtNombre, txtPrecio, txtAtributoExtra;
    private TextArea resultadoArea;
    private Choice cbTipoProducto;
    private Choice cbUnidad;
    private Label lblAtributoExtra;

    public ProductoView() {
        frame = new Frame("Registrar Producto");
        frame.setLayout(new GridLayout(9, 2));

        frame.add(new Label("ID:"));
        txtId = new TextField();
        frame.add(txtId);

        frame.add(new Label("Nombre:"));
        txtNombre = new TextField();
        frame.add(txtNombre);

        frame.add(new Label("Precio:"));
        txtPrecio = new TextField();
        frame.add(txtPrecio);

        frame.add(new Label("Unidad de Medida:"));
        cbUnidad = new Choice();
        for (UnidadMedida unidad : UnidadMedida.values()) {
            cbUnidad.add(unidad.name());
        }
        frame.add(cbUnidad);

        frame.add(new Label("Tipo de Producto:"));
        cbTipoProducto = new Choice();
        cbTipoProducto.add("Simple");
        cbTipoProducto.add("Cosmetico");
        cbTipoProducto.add("Dulce");
        cbTipoProducto.add("Periferico");
        frame.add(cbTipoProducto);

        lblAtributoExtra = new Label("Extra:");
        txtAtributoExtra = new TextField();
        frame.add(lblAtributoExtra);
        frame.add(txtAtributoExtra);

        // Actualizar etiqueta según tipo seleccionado
        cbTipoProducto.addItemListener(e -> actualizarEtiquetaExtra());

        Button btnRegistrar = new Button("Registrar");
        frame.add(btnRegistrar);

        resultadoArea = new TextArea();
        frame.add(resultadoArea);

        btnRegistrar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String nombre = txtNombre.getText();
                double precio = Double.parseDouble(txtPrecio.getText());
                UnidadMedida unidad = UnidadMedida.valueOf(cbUnidad.getSelectedItem());
                String tipoSeleccionado = cbTipoProducto.getSelectedItem();
                String valorExtra = txtAtributoExtra.getText();

                // Proveedor simulado
                Persona persona = new Persona("Juan", "Pérez", "12345678", "999999999", "juan@email.com");
                Proveedor proveedor = new Proveedor(1, persona);

                Producto producto;

                switch (tipoSeleccionado) {
                    case "Cosmetico":
                        producto = new ProductoCosmetico(id, nombre, precio, unidad, valorExtra, proveedor);
                        break;
                    case "Dulce":
                        producto = new ProductoDulce(id, nombre, precio, unidad, valorExtra, proveedor);
                        break;
                    case "Periferico":
                        producto = new ProductoPeriferico(id, nombre, precio, unidad, valorExtra, proveedor);
                        break;
                    default:
                        producto = new ProductoSimple(id, nombre, precio, unidad, proveedor);
                        break;
                }

                resultadoArea.setText("Producto registrado exitosamente:\n" + producto.toString());

            } catch (Exception ex) {
                resultadoArea.setText("Error al registrar producto: " + ex.getMessage());
            }
        });

        frame.setSize(500, 500);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        // Inicializar etiqueta extra
        actualizarEtiquetaExtra();
    }

    private void actualizarEtiquetaExtra() {
        String tipo = cbTipoProducto.getSelectedItem();
        switch (tipo) {
            case "Cosmetico":
                lblAtributoExtra.setText("Descripción:");
                break;
            case "Dulce":
                lblAtributoExtra.setText("Sabor:");
                break;
            case "Periferico":
                lblAtributoExtra.setText("Tipo periférico:");
                break;
            default:
                lblAtributoExtra.setText("N/A:");
                break;
        }
        txtAtributoExtra.setEnabled(!tipo.equals("Simple"));
        txtAtributoExtra.setText("");
    }
}
