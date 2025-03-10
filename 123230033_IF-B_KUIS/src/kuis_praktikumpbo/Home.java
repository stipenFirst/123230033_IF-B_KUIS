/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kuis_praktikumpbo;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
/**
 *
 * @author andika dwi saktiawan
 */

public class Home extends JFrame implements ActionListener {
    JLabel welcomeLabel, subLabel;
    JButton buttonApel, buttonJeruk, buttonMangga;
    private String username;

    public Home(String username) {
        this.username = username;

        // Konfigurasi Frame
        setSize(480, 300);
        setTitle("Home Page");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Menambahkan Label
        welcomeLabel = new JLabel("Selamat Datang, " + username);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        subLabel = new JLabel("Silahkan beli buah yang ingin dibeli"); // Perbaikan titik koma
        add(welcomeLabel);
        add(subLabel);
        welcomeLabel.setBounds(20, 20, 300, 30);
        subLabel.setBounds(20, 45, 350, 25); // Memperbaiki posisi label kedua

        // Membuat tombol kategori majalah
        buttonApel = new JButton("Buah Apel");
        buttonJeruk = new JButton("Buah Jeruk");
        buttonMangga = new JButton("Buah Mangga");

        // Menambahkan tombol ke frame
        add(buttonApel);
        add(buttonJeruk);
        add(buttonMangga);

        // Mengatur posisi tombol
        buttonApel.setBounds(115, 110, 250, 40);
        buttonJeruk.setBounds(115, 160, 250, 40);
        buttonMangga.setBounds(115, 210, 250, 40);

        // Menambahkan event listener
        buttonApel.addActionListener(this);
        buttonJeruk.addActionListener(this);
        buttonMangga.addActionListener(this);

        // Menampilkan frame
        setVisible(true);
    }

    Home() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String kategori = "";
        if (e.getSource() == buttonApel) {
            kategori = "Buah Apel";
        } else if (e.getSource() == buttonJeruk) {
            kategori = "Buah Jeruk";
        } else if (e.getSource() == buttonMangga) {
            kategori = "Buah ";
        }

        // Pastikan PembelianPage sudah ada sebelum dipanggil
        new Pembelian(username, kategori);
        dispose();
    }
}