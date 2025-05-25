package Erpcompras.Views;

import java.awt.*;
import java.awt.event.*;

public class BuscarSolicitudView extends Frame {
    public BuscarSolicitudView() {
        setTitle("Buscar Solicitud de Compra");
        setSize(400, 300);
        setLayout(new BorderLayout());

        Label idLabel = new Label("ID Solicitud:");
        TextField idField = new TextField();
        TextArea resultadoArea = new TextArea();

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
        Panel topPanel = new Panel(new BorderLayout());
        topPanel.add(new Label("N° Solicitud:"), BorderLayout.WEST);
        topPanel.add(idField, BorderLayout.CENTER);
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
