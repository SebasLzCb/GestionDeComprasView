package Erpcompras.Views;

import java.awt.*;
import java.awt.event.*;
import Erpcompras.Datos.BaseDeDatos;

public class ListarProductosView extends Frame {
    public ListarProductosView() {
        setTitle("Lista de Productos");
        setSize(400, 300);
        setLayout(new BorderLayout());

        TextArea listaProductos = new TextArea();
        listaProductos.setEditable(false);

        StringBuilder contenido = new StringBuilder();
        int i = 1;
        for (String producto : BaseDeDatos.productos) {
            contenido.append(i++).append(". ").append(producto).append("\n");
        }

        listaProductos.setText(contenido.toString());

        Button volverBtn = new Button("Volver");
        volverBtn.addActionListener(e -> dispose());

        add(listaProductos, BorderLayout.CENTER);

        Panel bottomPanel = new Panel();
        bottomPanel.add(volverBtn);
        add(bottomPanel, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}