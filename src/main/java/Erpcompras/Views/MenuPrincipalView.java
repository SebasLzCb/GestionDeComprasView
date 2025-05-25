package Erpcompras.Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Vista principal usando Swing para un diseño moderno y adaptativo.
 */
public class MenuPrincipalView extends JFrame {

    private static final Color PANEL_BG = new Color(245, 245, 250);
    private static final Color CARD_BG = Color.WHITE;
    private static final Color BUTTON_BG = new Color(235, 245, 255);
    private static final Color BUTTON_HOVER_BG = new Color(153, 102, 204);
    private static final Color BUTTON_TEXT = new Color(50, 50, 50);
    private static final Color BUTTON_HOVER_TEXT = Color.WHITE;
    private static final int INITIAL_WINDOW_HEIGHT = 780;

    public MenuPrincipalView() {
        setTitle("Sistema de Gestión de Compras ERP");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panel contenedor principal (fondo gris claro)
        JPanel outer = new JPanel(new GridBagLayout());
        outer.setBackground(PANEL_BG);
        outer.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Card panel (fondo blanco con borde redondeado)
        JPanel card = new RoundedPanel(20, CARD_BG);
        card.setLayout(new BorderLayout(0, 20));
        card.setBorder(new EmptyBorder(30, 30, 30, 30));

        // Título
        JLabel titulo = new JLabel("SISTEMA DE GESTIÓN DE COMPRAS ERP", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titulo.setForeground(new Color(50, 50, 50));
        card.add(titulo, BorderLayout.NORTH);

        // Panel de botones
        JPanel botonPanel = new JPanel(new GridLayout(0, 1, 0, 15));
        botonPanel.setOpaque(false);

        String[] opciones = {
                "1. Registrar proveedor",
                "2. Registrar producto",
                "3. Registrar solicitud de compra",
                "4. Listar proveedores",
                "5. Listar productos",
                "6. Listar solicitudes de compra",
                "7. Buscar proveedor por ID",
                "8. Buscar producto por nombre",
                "9. Buscar solicitud por número",
                "13. Aprobar / Rechazar solicitud de compra",
                "14. Calcular total de una solicitud",
                "15. Salir"
        };
        for (String texto : opciones) {
            JButton btn = new JButton(texto);
            btn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            btn.setFocusPainted(false);
            btn.setBackground(BUTTON_BG);
            btn.setForeground(BUTTON_TEXT);
            btn.setPreferredSize(new Dimension(350, 45));
            btn.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true));
            btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            // Hover effect
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btn.setBackground(BUTTON_HOVER_BG);
                    btn.setForeground(BUTTON_HOVER_TEXT);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setBackground(BUTTON_BG);
                    btn.setForeground(BUTTON_TEXT);
                }
                @Override
                public void mousePressed(MouseEvent e) {
                    btn.setBackground(BUTTON_HOVER_BG.darker());
                }
                @Override
                public void mouseReleased(MouseEvent e) {
                    btn.setBackground(BUTTON_HOVER_BG);
                }
            });

            btn.addActionListener(e -> handleOption(texto));
            botonPanel.add(btn);
        }
        card.add(botonPanel, BorderLayout.CENTER);

        // Añadir card al contenedor
        outer.add(card);
        setContentPane(outer);

        // Mostrar ventana con altura inicial ajustada
        pack();
        setSize(getWidth(), INITIAL_WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }

    private void handleOption(String opcion) {
        dispose();
        switch (opcion) {
            case "1. Registrar proveedor": new ProveedorView(); break;
            case "2. Registrar producto": new ProductoView(); break;
            case "3. Registrar solicitud de compra": new SolicitudCompraView(); break;
            case "4. Listar proveedores": new ListarProveedoresView(); break;
            case "5. Listar productos": new ListarProductosView(); break;
            case "6. Listar solicitudes de compra": new ListarSolicitudesView(); break;
            case "7. Buscar proveedor por ID": new BuscarProveedorView(); break;
            case "8. Buscar producto por nombre": new BuscarProductoView(); break;
            case "9. Buscar solicitud por número": new BuscarSolicitudView(); break;
            case "13. Aprobar / Rechazar solicitud de compra": new AprobarRechazarView(); break;
            case "14. Calcular total de una solicitud": new CalcularTotalView(); break;
            case "15. Salir": System.exit(0); break;
            default: break;
        }
    }

    /**
     * Panel con fondo redondeado.
     */
    @SuppressWarnings("serial")
    static class RoundedPanel extends JPanel {
        private int radius;
        private Color backgroundColor;

        public RoundedPanel(int radius, Color bgColor) {
            this.radius = radius;
            this.backgroundColor = bgColor;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(backgroundColor);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            super.paintComponent(g2);
        }
    }
}