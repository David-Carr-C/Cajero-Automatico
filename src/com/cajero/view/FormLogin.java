package com.cajero.view;

import com.cajero.controller.DBManagerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormLogin extends JFrame implements ISettingFrame, ActionListener {
    private JPanel centerPanel, southPanel;
    private JLabel jLNumeroDeCuenta, jLNIP;
    private JTextField jTNumeroDeCuenta, jTNIP;
    private JButton summit;
    public boolean isLogged;

    public FormLogin() {
        initPanels();
        initComponents();
        initWindow();
    }

    @Override
    public void initPanels() {
        centerPanel = new JPanel(new FlowLayout());
        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
    }

    @Override
    public void initComponents() {
        jLNumeroDeCuenta = new JLabel("Inserte su numero de cuenta");
        jLNIP = new JLabel("Inserte su NIP");
        jTNumeroDeCuenta = new JTextField("", 8);
        jTNIP = new JTextField("", 8);
        summit = new JButton("Confirm");
        addActionInButtons();
        addComponents();
    }

    @Override
    public void addActionInButtons() {
        summit.addActionListener(this);
    }

    @Override
    public void addComponents() {
        // Panels
        centerPanel.add(jLNumeroDeCuenta);
        centerPanel.add(jTNumeroDeCuenta);
        centerPanel.add(jLNIP);
        centerPanel.add(jTNIP);
        southPanel.add(summit);

        // This Jframe
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
    }

    @Override
    public void initWindow() {
        super.setTitle("Login");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(320,120);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
        super.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==summit) {
            String numeroDeCuenta = jTNumeroDeCuenta.getText();
            String nIP = jTNIP.getText();

            isLogged = DBManagerController.SearchForAUser(numeroDeCuenta, nIP);
            if (DBManagerController.isAdmin(numeroDeCuenta) && isLogged) {
                AdminWindow adminWindow = new AdminWindow((DBManagerController.getSearchedAdmin(numeroDeCuenta)));
                this.dispose();
            } else if (isLogged) {
                ClienteWindow clienteWindow = new ClienteWindow(DBManagerController.getSearchedUser(numeroDeCuenta));
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null,"Intente de nuevo, algo salio mal!");
            }
        }
    }
}
