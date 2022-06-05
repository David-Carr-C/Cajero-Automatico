package com.cajero.view;

import com.cajero.model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteWindow extends JFrame implements ISettingFrame, ActionListener {
    private Usuario usuario;

    public ClienteWindow(Usuario usuario) {//todo: este frame
        this.usuario = usuario;
        initPanels();
        initComponents();
        initWindow();
    }

    @Override
    public void initPanels() {

    }

    @Override
    public void initComponents() {

    }

    @Override
    public void addActionInButtons() {

    }

    @Override
    public void addComponents() {

    }

    @Override
    public void initWindow() {
        super.setTitle("Bienvenido "+usuario.getNombreCliente());
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(320,120);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
        super.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
