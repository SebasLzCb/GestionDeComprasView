package Erpcompras.Views;

import java.awt.*;
import java.awt.event.*;
import Erpcompras.Datos.BaseDeDatos;

public class ListarProveedoresView extends Frame {
    public ListarProveedoresView() {
        setTitle("Lista de Proveedores");
        setSize(400, 300);
        setLayout(new BorderLayout());

        TextArea listaProveedores = new TextArea();
        listaProveedores.setEditable(false);

        StringBuilder contenido = new StringBuilder();
        int i = 1;
        for (String proveedor : BaseDeDatos.proveedores) {
            contenido.append(i++).append(". ").append(proveedor).append("\n");
        }

        listaProveedores.setText(contenido.toString());

        Button volverBtn = new Button("Volver");
        volverBtn.addActionListener(e -> dispose());

        add(listaProveedores, BorderLayout.CENTER);

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
