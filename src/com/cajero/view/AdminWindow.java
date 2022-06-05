package com.cajero.view;

import com.cajero.model.Administrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminWindow extends JFrame implements ISettingFrame, ActionListener {
    private JPanel eastPanel, westPanel, southPanel;
    private JTextArea jTAllUsers;
    private JLabel jLNombreDeCliente, jLNumeroDeCuenta, jLNIP, jLTipoTarjeta;
    private JTextField jTNombreDeCliente, jTNumeroDeCuenta, jTNIP;
    private JButton jBAltaCliente, jBBajaCliente, jBModificacionCliente;
    private JComboBox<String> jCTarjeta;
    private Administrador administrador;

    public AdminWindow(Administrador administrador) {
        this.administrador = administrador;
        initPanels();
        initComponents();
        initWindow();
    }

    @Override
    public void initPanels() {
        eastPanel = new JPanel(new GridLayout(12,1,0,0));
        westPanel = new JPanel();
        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    }

    @Override
    public void initComponents() {
        jBAltaCliente = new JButton("Alta Cliente");
        jBBajaCliente = new JButton("Baja Cliente");
        jBModificacionCliente = new JButton("Modificacion Cliente");
        jTAllUsers = new JTextArea(20,35);
        jLNombreDeCliente = new JLabel("Nombre del cliente: ");
        jTNombreDeCliente = new JTextField("", 8);
        jLNumeroDeCuenta = new JLabel("Numero de cuenta: ");
        jTNumeroDeCuenta = new JTextField("",8);
        jLNIP = new JLabel("NIP: ");
        jTNIP = new JTextField("",8);
        String[] options = {"Credito", "Debito"};
        jCTarjeta = new JComboBox<>(options);
        jLTipoTarjeta = new JLabel("Tarjeta: ");
        addActionInButtons();
        addComponents();
    }

    @Override
    public void addActionInButtons() {
        jBAltaCliente.addActionListener(this);
        jBBajaCliente.addActionListener(this);
        jBModificacionCliente.addActionListener(this);
    }

    @Override
    public void addComponents() {
        // Panel components
        westPanel.add(jTAllUsers);
        eastPanel.add(jLNombreDeCliente);
        eastPanel.add(jTNombreDeCliente);
        eastPanel.add(jLNumeroDeCuenta);
        eastPanel.add(jTNumeroDeCuenta);
        eastPanel.add(jLNIP);
        eastPanel.add(jTNIP);
        eastPanel.add(jLTipoTarjeta);
        eastPanel.add(jCTarjeta);
        southPanel.add(jBAltaCliente);
        southPanel.add(jBBajaCliente);
        southPanel.add(jBModificacionCliente);

        // This components
        this.add(westPanel, BorderLayout.WEST);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(southPanel, BorderLayout.SOUTH);
    }

    @Override
    public void initWindow() {
        super.setTitle("Administrador Del Sistema");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(540,380);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
        super.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) { //todo: Agregar actionPerformed
        if (e.getSource() == jBAltaCliente) {
            System.out.println("Se crea nuevo usuario");
        }

        if (e.getSource() == jBBajaCliente) {
            System.out.println("Se da de baja un cliente");
        }

        if (e.getSource()==jBModificacionCliente) {
            System.out.println("Se modifica un cliente");
        }
    }
}
