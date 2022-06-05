package com.cajero.model;

import com.cajero.exceptions.AccountException;

public abstract class Account {
    private String nombreCliente;
    private String numeroCuenta;
    private String nIP;

    /**
     * Constructor para poder crear una cuenta, el administrador puede tener nombre, numero de cuenta y nip, mientras que
     * el usuario debera tener una tarjeta vigente
     * */
    public Account(String nombreCliente, String numeroCuenta, String nIP) throws AccountException {
        if (nombreCliente.equals("")) {
            throw new AccountException("Nombre de cliente no valido");
        }
        if (numeroCuenta.length() != 11) {
            throw new AccountException("El numero de la cuenta debe tener 11 numeros");
        }
        if (nIP.length() != 4) {
            throw new AccountException("El nip debe que tener 4 numeros");
        }

        this.nombreCliente = nombreCliente;
        this.numeroCuenta = numeroCuenta;
        this.nIP = nIP;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNIP() {
        return nIP;
    }

    @Override
    public String toString() {
        String estadoDelObjeto = "";
        estadoDelObjeto = "Estado de la cuenta.\nNumero de cuenta: "+numeroCuenta+"\nNombre del cliente: "+nombreCliente;
        return estadoDelObjeto;
    }
}
