package Erpcompras.Views;

import Erpcompras.Datos.BaseDeDatos;
import java.awt.*;
import java.awt.event.*;

public class ListarSolicitudesView extends Frame {

    public ListarSolicitudesView() {
        setTitle("Lista de Solicitudes");
        setSize(400, 300);
        setLayout(new BorderLayout());

        TextArea listaSolicitudes = new TextArea();
        listaSolicitudes.setEditable(false);

        StringBuilder contenido = new StringBuilder();
        int i = 1;
        for (String solicitud : BaseDeDatos.solicitudes) {
            contenido.append(i++).append(". ").append(solicitud).append("\n");
        }

        if (contenido.length() == 0) {
            contenido.append("No hay solicitudes registradas.");
        }

        listaSolicitudes.setText(contenido.toString());

        Button volverBtn = new Button("Volver");
        volverBtn.addActionListener(e -> dispose());

        add(listaSolicitudes, BorderLayout.CENTER);

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
