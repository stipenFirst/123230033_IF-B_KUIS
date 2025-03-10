/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kuis_praktikumpbo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JButton buttonLogin, buttonReset; 

    private final String USERNAME = "andika";
    private final String PASSWORD = "123230033";

    public Login() {
        setTitle("Login page");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel utama dengan BoxLayout (Vertical)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Judul
        JLabel titleLabel = new JLabel("SIGN IN");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        JLabel usernameLabel = new JLabel("username: ");
        usernameTextField = new JTextField(15);
        usernameTextField.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel passwordLabel = new JLabel("password: ");
        passwordTextField = new JPasswordField(15);
        passwordTextField.setFont(new Font("Arial", Font.PLAIN, 12));

        inputPanel.add(usernameLabel);
        inputPanel.add(usernameTextField);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordTextField);

        // Panel tombol dengan FlowLayout agar sejajar
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 5));

        buttonLogin = new JButton("Login");
        buttonLogin.setFont(new Font("Arial", Font.BOLD, 12));
        buttonLogin.setPreferredSize(new Dimension(120, 40));       //LOGIN
        buttonLogin.addActionListener(this);

        
        buttonReset = new JButton("Reset");
        buttonReset.setFont(new Font("Arial", Font.BOLD, 12));
        buttonReset.setPreferredSize(new Dimension(120, 40));       // RESET
        buttonReset.addActionListener(e -> {
            usernameTextField.setText("");
            passwordTextField.setText("");
        });

        buttonPanel.add(buttonLogin);
        buttonPanel.add(buttonReset);

        // tambah ke main panel
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(inputPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(buttonPanel);

        // tambah ke frame panel
        add(mainPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonLogin) {
            String username = usernameTextField.getText();
            String password = new String(passwordTextField.getPassword());

            if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                JOptionPane.showMessageDialog(this, "login sukses!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                new Home(username);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Login Gagal! Username atau Password salah.", "Error", JOptionPane.ERROR_MESSAGE);// pesan error yang ditampilkan
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Login::new);
    }
}
