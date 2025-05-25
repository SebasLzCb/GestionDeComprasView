package Erpcompras.Views;

import java.awt.*;
import java.awt.event.*;

public class AprobarRechazarView extends Frame {
    public AprobarRechazarView() {
        setTitle("Aprobar o Rechazar Solicitudes");
        setSize(400, 300);
        setLayout(new GridLayout(3, 2));


        TextArea resultadoArea = new TextArea("Aquí se mostraría la solicitud pendiente...");
        Panel botonPanel = new Panel(new FlowLayout());

        Button aprobarBtn = new Button("Aprobar");
        Button rechazarBtn = new Button("Rechazar");
        Button volverBtn = new Button("Volver");

        aprobarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultadoArea.setText("Solicitud aprobada.");
            }
        });

        rechazarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultadoArea.setText("Solicitud rechazada.");
            }
        });

        volverBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        botonPanel.add(aprobarBtn);
        botonPanel.add(rechazarBtn);
        botonPanel.add(volverBtn);

        add(resultadoArea, BorderLayout.CENTER);
        add(botonPanel, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}
