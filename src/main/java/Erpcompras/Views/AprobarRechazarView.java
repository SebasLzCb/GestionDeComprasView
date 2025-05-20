package Erpcompras.Views;

import java.awt.*;
import java.awt.event.*;

public class AprobarRechazarView extends Frame {
    public AprobarRechazarView() {
        setTitle("Aprobar o Rechazar Solicitudes");
        setSize(400, 300);
        setLayout(new GridLayout(3, 2));

        Label idLabel = new Label("ID de Solicitud:");
        TextField idField = new TextField();

        Button aprobarBtn = new Button("Aprobar");
        Button rechazarBtn = new Button("Rechazar");
        Button volverBtn = new Button("Volver");

        add(idLabel); add(idField);
        add(aprobarBtn); add(rechazarBtn);
        add(volverBtn);

        aprobarBtn.addActionListener(e -> {
            System.out.println("Solicitud " + idField.getText() + " aprobada.");
        });

        rechazarBtn.addActionListener(e -> {
            System.out.println("Solicitud " + idField.getText() + " rechazada.");
        });

        volverBtn.addActionListener(e -> {
            dispose();
            new MenuPrincipalView().setVisible(true);
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }
}
