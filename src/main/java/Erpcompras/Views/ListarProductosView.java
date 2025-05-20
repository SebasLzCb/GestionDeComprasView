package Erpcompras.Views;

import java.awt.*;
import java.awt.event.*;

public class ListarProductosView extends Frame {
    public ListarProductosView() {
        setTitle("Lista de Productos");
        setSize(400, 300);
        setLayout(new BorderLayout());

        TextArea area = new TextArea();
        area.setText("Aquí iría la lista de productos...");

        Button volverBtn = new Button("Volver");

        add(area, BorderLayout.CENTER);
        add(volverBtn, BorderLayout.SOUTH);

        volverBtn.addActionListener(e -> {
            dispose();
            new MenuPrincipalView().setVisible(true);
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
}
