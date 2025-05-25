package Erpcompras.Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Vista de inicio de sesión. Usuario "admin", contraseña "12345".
 */
public class LoginView extends JFrame {

    public LoginView() {
        setTitle("Login - Sistema de Compras");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);
        setResizable(false);

        // Panel principal
        JPanel panel = new JPanel(new BorderLayout(0, 20));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(245, 245, 250));

        // Formulario
        JPanel form = new JPanel(new GridLayout(0, 2, 10, 10));
        form.setOpaque(false);

        JLabel lblUser = new JLabel("Usuario:");
        lblUser.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        JTextField txtUser = new JTextField();

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        JPasswordField txtPass = new JPasswordField();

        form.add(lblUser);
        form.add(txtUser);
        form.add(lblPass);
        form.add(txtPass);

        panel.add(form, BorderLayout.CENTER);

        // Botón Ingresar
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.setOpaque(false);
        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnIngresar.setBackground(new Color(153, 102, 204));
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setFocusPainted(false);
        btnPanel.add(btnIngresar);
        panel.add(btnPanel, BorderLayout.SOUTH);


        setContentPane(panel);

        // Acción del botón
        btnIngresar.addActionListener(e -> {
            String user = txtUser.getText().trim();
            String pass = new String(txtPass.getPassword());
            if ("admin".equals(user) && "12345".equals(pass)) {
                // Abrir menú principal
                SwingUtilities.invokeLater(() -> new MenuPrincipalView());
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Usuario o contraseña incorrectos.",
                        "Error de autenticación",
                        JOptionPane.ERROR_MESSAGE);
                txtPass.setText("");
            }
        });

        setVisible(true);
    }
}

