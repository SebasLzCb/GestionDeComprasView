package Erpcompras.Views;

import java.awt.*;
import java.awt.event.*;

public class BuscarSolicitudView extends Frame {
    public BuscarSolicitudView() {
        setTitle("Buscar Solicitud");
        setSize(300, 200);
        setLayout(new GridLayout(3, 2));

        Label idLabel = new Label("ID Solicitud:");
        TextField idField = new TextField();
        Button buscarBtn = new Button("Buscar");
        Button volverBtn = new Button("Volver");

        add(idLabel);
        add(idField);
        add(buscarBtn);
        add(volverBtn);

        buscarBtn.addActionListener(e -> {
            System.out.println("Buscando solicitud con ID: " + idField.getText());
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
