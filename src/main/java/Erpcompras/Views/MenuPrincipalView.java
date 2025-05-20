package Erpcompras.Views;

import java.awt.*;
import java.awt.event.*;

public class MenuPrincipalView {
    private Frame frame;

    public MenuPrincipalView() {
        frame = new Frame("SISTEMA DE GESTIÓN DE COMPRAS ERP");
        frame.setLayout(new GridLayout(0, 1, 10, 10));

        Label titulo = new Label("===== SISTEMA DE GESTIÓN DE COMPRAS ERP =====", Label.CENTER);
        frame.add(titulo);

        agregarBoton("1. Registrar proveedor");
        agregarBoton("2. Registrar producto");
        agregarBoton("3. Registrar solicitud de compra");
        agregarBoton("4. Listar proveedores");
        agregarBoton("5. Listar productos");
        agregarBoton("6. Listar solicitudes de compra");
        agregarBoton("7. Buscar proveedor por ID");
        agregarBoton("8. Buscar producto por nombre");
        agregarBoton("9. Buscar solicitud por número");
        agregarBoton("13. Aprobar / Rechazar solicitud de compra");
        agregarBoton("14. Calcular total de una solicitud");
        agregarBoton("15. Salir");

        frame.setSize(500, 600);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

    private void agregarBoton(String texto) {
        Button btn = new Button(texto);
        frame.add(btn);

        btn.addActionListener(e -> {
            switch (texto) {
                case "1. Registrar proveedor":
                    frame.dispose(); // cierra el menú actual
                    new ProveedorView(); // abre el nuevo
                    break;
                case "2. Registrar producto":
                    new ProductoView();
                    break;
                case "3. Registrar solicitud de compra":
                    new SolicitudCompraView();
                    break;
                case "4. Listar proveedores":
                    new ListarProveedoresView();
                    break;
                case "5. Listar productos":
                    new ListarProductosView();
                    break;
                case "6. Listar solicitudes de compra":
                    new ListarSolicitudesView();
                    break;
                case "7. Buscar proveedor por ID":
                    new BuscarProveedorView();
                    break;
                case "8. Buscar producto por nombre":
                    new BuscarProductoView();
                    break;
                case "9. Buscar solicitud por número":
                    new BuscarSolicitudView();
                    break;
                case "13. Aprobar / Rechazar solicitud de compra":
                    new AprobarRechazarView();
                    break;
                case "14. Calcular total de una solicitud":
                    new CalcularTotalView();
                    break;
                case "15. Salir":
                    frame.dispose();
                    break;
                default:
                    System.out.println("Opción no implementada aún.");
            }
        });
    }

    public void setVisible(boolean b) {
    }
}


