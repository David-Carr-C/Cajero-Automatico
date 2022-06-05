package com.cajero.view;

import com.cajero.controller.UserController;
import com.cajero.exceptions.CajeroException;
import com.cajero.exceptions.TarjetaException;
import com.cajero.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Deprecated
public class MainJavaFrame extends JFrame implements ActionListener {
    private JButton jButton, close;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;

    private JTextField jTextField;



    public MainJavaFrame(Usuario cuenta) {
        init(cuenta);

        configLayout(cuenta);

    }

    public void init(Usuario cuenta) {
        super.setTitle("Banco de "+ cuenta.getNombreCliente());
        super.setVisible(true);
        super.setSize(0,0)/*(1365,860)*/;
        super.setLocation(75,350);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void configLayout(Usuario cuenta) {
        super.setLayout(new FlowLayout());
        jButton = new JButton("Consultar saldo");
        jButton1 = new JButton("Retirar");
        jButton2 = new JButton("Depositar");
        jButton3 = new JButton("Cambiar NIP");
        close = new JButton("Salir");


        super.add(jButton);
        jButton.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                UserController controller = new UserController(cuenta);


                JOptionPane.showMessageDialog(null, "Saldo actual: "+controller.mostrarSaldo());
            }
        });


        JLabel jLabel = new JLabel("Monto a retirar");
        jTextField = new JTextField("0", 10);
        add(jLabel);
        add(jTextField);

        super.add(jButton1);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserController controller = new UserController(cuenta);
                double num = Double.parseDouble(jTextField.getText());
                try {
                    JOptionPane.showMessageDialog(null, "Se retiro: "+controller.retirar(num));
                }  catch (TarjetaException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        JLabel retirar = new JLabel("Cuanto desea depositar?");
        super.add(retirar);
        JTextField campoAEscribir = new JTextField("0",10);
        super.add(campoAEscribir);

        super.add(jButton2);
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserController controller = new UserController(cuenta);
                double aqui = Double.parseDouble(campoAEscribir.getText());
                try {
                    controller.depositar(aqui);

                    JOptionPane.showMessageDialog(null, "Se deposito: "+controller.depositar(aqui));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        JLabel cambiarNIP = new JLabel("Nuevo NIP: ");
        super.add(cambiarNIP);

        JTextField nuevonip = new JTextField("0000",4);
        super.add(nuevonip);

        super.add(jButton3);
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nuevoNIP = nuevonip.getText();
                UserController controller = new UserController(cuenta);
                try {
                    String otraString = controller.cambiarNIP(nuevoNIP);
                    JOptionPane.showMessageDialog(null, otraString);
                }catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }

            }
        });

        super.add(close);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Saliendo");
                salir();
            }
        });


        super.pack();
    }

    public void salir() {
        super.setVisible(false);
        super.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
