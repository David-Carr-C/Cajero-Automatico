package com.cajero.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ISettingFrame, ActionListener {
    private JPanel seccionNorte, seccionSur, seccionCentro;
    private JLabel imagenPrincipal, bienvenida;
    private JButton login;

    public Login() {
        initPanels();
        initComponents();
        initWindow();
    }

    @Override
    public void initPanels() {
        seccionCentro = new JPanel();
        seccionNorte = new JPanel(new FlowLayout(FlowLayout.CENTER));
        seccionNorte.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        seccionNorte.setBorder(BorderFactory.createTitledBorder(""));
        seccionSur = new JPanel(new FlowLayout(FlowLayout.CENTER));
        seccionSur.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        seccionSur.setBorder(BorderFactory.createTitledBorder(""));
    }

    @Override
    public void initComponents() {
        ImageIcon imageIcon = new ImageIcon("cajero.jpg");
        imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(260,320,Image.SCALE_SMOOTH));
        imagenPrincipal = new JLabel(imageIcon);
        login = new JButton("Login");
        bienvenida = new JLabel("Cajero Automático");
        addActionInButtons();
        addComponents();
    }

    @Override
    public void addActionInButtons() {
        login.addActionListener(this);
    }

    @Override
    public void addComponents() {
        // Panels
        seccionNorte.add(bienvenida);
        seccionCentro.add(imagenPrincipal);
        seccionSur.add(login);

        // This JFrame
        this.add(seccionNorte, BorderLayout.NORTH);
        this.add(seccionCentro, BorderLayout.CENTER);
        this.add(seccionSur, BorderLayout.SOUTH);
    }

    @Override
    public void initWindow() {
        super.setTitle("Bienvenido");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(280,425);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
        super.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==login) {
            FormLogin formLogin = new FormLogin();
            login.setEnabled(false);

            // Thread: When is logged close this window
            CloseWindow closeWindow = new CloseWindow( formLogin,this);
            Thread oneThread = new Thread(closeWindow);
            oneThread.start();
        }
    }
}
