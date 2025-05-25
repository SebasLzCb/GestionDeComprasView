package Erpcompras.Views;

import java.awt.*;
import java.awt.event.*;

public class CalcularTotalView extends Frame {
    public CalcularTotalView() {
        setTitle("Calcular Total");
        setSize(400, 250);
        setLayout(new GridLayout(4, 2, 10, 10));

        Label cantidadLabel = new Label("Cantidad:");
        TextField cantidadField = new TextField();

        Label precioLabel = new Label("Precio Unitario:");
        TextField precioField = new TextField();

        Label totalLabel = new Label("Total:");
        TextField totalField = new TextField();
        totalField.setEditable(false);

        Button calcularBtn = new Button("Calcular");
        Button volverBtn = new Button("Volver");

        calcularBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int cantidad = Integer.parseInt(cantidadField.getText());
                    double precio = Double.parseDouble(precioField.getText());
                    double total = cantidad * precio;
                    totalField.setText(String.format("%.2f", total));
                } catch (NumberFormatException ex) {
                    totalField.setText("Error de entrada");
                }
            }
        });

        volverBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(cantidadLabel);
        add(cantidadField);
        add(precioLabel);
        add(precioField);
        add(totalLabel);
        add(totalField);
        add(calcularBtn);
        add(volverBtn);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}
