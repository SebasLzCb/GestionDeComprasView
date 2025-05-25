// BaseView.java
package Erpcompras.Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Clase base para vistas con estilo unificado.
 */
public abstract class BaseView extends JFrame {
    protected static final Color PANEL_BG = new Color(245, 245, 250);
    protected static final Color CARD_BG = Color.WHITE;
    protected static final Color BUTTON_BG = new Color(235, 245, 255);
    protected static final Color BUTTON_HOVER_BG = new Color(153, 102, 204);
    protected static final Color BUTTON_TEXT = new Color(50, 50, 50);
    protected static final Color BUTTON_HOVER_TEXT = Color.WHITE;

    public BaseView(String title) {
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel outer = new JPanel(new GridBagLayout());
        outer.setBackground(PANEL_BG);
        outer.setBorder(new EmptyBorder(20,20,20,20));
        RoundedPanel card = new RoundedPanel(20, CARD_BG);
        card.setLayout(new BorderLayout(0,20));
        card.setBorder(new EmptyBorder(20,20,20,20));
        outer.add(card);
        setContentPane(outer);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                new MenuPrincipalView();
            }
        });
    }

    protected JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn.setBackground(BUTTON_BG);
        btn.setForeground(BUTTON_TEXT);
        btn.setFocusPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(BUTTON_HOVER_BG);
                btn.setForeground(BUTTON_HOVER_TEXT);
            }
            public void mouseExited(MouseEvent e) {
                btn.setBackground(BUTTON_BG);
                btn.setForeground(BUTTON_TEXT);
            }
            public void mousePressed(MouseEvent e) {
                btn.setBackground(BUTTON_HOVER_BG.darker());
            }
            public void mouseReleased(MouseEvent e) {
                btn.setBackground(BUTTON_HOVER_BG);
            }
        });
        return btn;
    }

    /** Panel con esquinas redondeadas. */
    @SuppressWarnings("serial")
    public static class RoundedPanel extends JPanel {
        private int radius;
        private Color bg;
        public RoundedPanel(int radius, Color bg) {
            this.radius=radius; this.bg=bg; setOpaque(false);
        }
        protected void paintComponent(Graphics g) {
            Graphics2D g2=(Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(bg);
            g2.fillRoundRect(0,0,getWidth(),getHeight(),radius,radius);
            super.paintComponent(g2);
        }
    }
}