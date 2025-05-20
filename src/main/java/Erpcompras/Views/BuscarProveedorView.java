package Erpcompras.Views;

import java.awt.*;
import java.awt.event.*;

public class BuscarProveedorView extends Frame {
    public BuscarProveedorView() {
        setTitle("Buscar Proveedor");
        setSize(300, 200);
        setLayout(new GridLayout(3, 2));

        Label rucLabel = new Label("RUC:");
        TextField rucField = new TextField();
        Button buscarBtn = new Button("Buscar");
        Button volverBtn = new Button("Volver");

        add(rucLabel);
        add(rucField);
        add(buscarBtn);
        add(volverBtn);

        buscarBtn.addActionListener(e -> {
            System.out.println("Buscando proveedor con RUC: " + rucField.getText());
        });

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
