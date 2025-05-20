package Erpcompras.Views;

import java.awt.*;
import java.awt.event.*;

public class CalcularTotalView extends Frame {
    public CalcularTotalView() {
        setTitle("Calcular Total de Solicitud");
        setSize(300, 200);
        setLayout(new GridLayout(3, 2));

        Label idLabel = new Label("ID Solicitud:");
        TextField idField = new TextField();
        Button calcularBtn = new Button("Calcular");
        Button volverBtn = new Button("Volver");

        add(idLabel);
        add(idField);
        add(calcularBtn);
        add(volverBtn);

        calcularBtn.addActionListener(e -> {
            System.out.println("Calculando total de la solicitud " + idField.getText());
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
