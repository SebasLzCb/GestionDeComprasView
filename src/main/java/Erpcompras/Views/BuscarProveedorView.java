package Erpcompras.Views;

import java.awt.*;
import java.awt.event.*;

public class BuscarProveedorView extends Frame {
    public BuscarProveedorView() {
        setTitle("Buscar Proveedor");
        setSize(400, 300);
        setLayout(new BorderLayout());

        TextField nombreField = new TextField();
        TextArea resultadoArea = new TextArea();

        Button buscarBtn = new Button("Buscar");
        Button volverBtn = new Button("Volver");

        buscarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                // Aquí iría la lógica real para buscar el proveedor
                resultadoArea.setText("Resultado de búsqueda: " + nombre);
            }
        });

        volverBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        Panel topPanel = new Panel(new BorderLayout());
        topPanel.add(new Label("ID:"), BorderLayout.WEST);
        topPanel.add(nombreField, BorderLayout.CENTER);
        topPanel.add(buscarBtn, BorderLayout.EAST);

        Panel bottomPanel = new Panel();
        bottomPanel.add(volverBtn);

        add(topPanel, BorderLayout.NORTH);
        add(resultadoArea, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}
