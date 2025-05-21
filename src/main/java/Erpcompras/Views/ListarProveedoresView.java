package Erpcompras.Views;

import java.awt.*;
import java.awt.event.*;

public class ListarProveedoresView extends Frame {
    public ListarProveedoresView() {
        //Propiedades de ventana
        setTitle("Lista de Proveedores");
        setSize(400, 300);
        setLayout(new BorderLayout());

        //Mostrara la lista de proveedores
        TextArea area = new TextArea();
        area.setText("Aquí iría la lista de proveedores...");

        //Componentes de la ventana
        add(area, BorderLayout.CENTER);

        // Manejo de cierre
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
}
