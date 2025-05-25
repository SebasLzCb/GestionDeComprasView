package Erpcompras.Views;

import Erpcompras.Models.Producto;

import java.awt.*;
import java.awt.event.*;

// Aquí asumo que tienes una clase Producto con método estático buscarPorNombre
// import Erpcompras.Models.Producto; // o donde tengas tu modelo Producto

public class BuscarProductoView extends Frame {
    public BuscarProductoView() {
        setTitle("Buscar Producto");
        setSize(400, 300);
        setLayout(new BorderLayout());

        TextField nombreField = new TextField();
        TextArea resultadoArea = new TextArea();

        Button buscarBtn = new Button("Buscar");

        buscarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                // Aquí puedes conectar a tu modelo Producto si existe
                resultadoArea.setText("Resultado de búsqueda: " + nombre);
            }
        });

        Panel topPanel = new Panel(new BorderLayout());
        topPanel.add(new Label("Nombre:"), BorderLayout.WEST);
        topPanel.add(nombreField, BorderLayout.CENTER);
        topPanel.add(buscarBtn, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);
        add(resultadoArea, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}
