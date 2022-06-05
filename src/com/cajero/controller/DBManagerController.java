package com.cajero.controller;

import com.cajero.exceptions.AccountException;
import com.cajero.model.Administrador;
import com.cajero.model.DBManager;
import com.cajero.model.Usuario;


public class DBManagerController {
    public static boolean SearchForAUser(String numeroCuenta, String nIP) {
        for (Usuario usuario:DBManager.usuarios) {
            if (usuario.getNumeroCuenta().equals(numeroCuenta) && usuario.getNIP().equals(nIP)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAdmin(String numeroCuenta) {
        return numeroCuenta.equals(DBManager.usuarios.get(0).getNumeroCuenta());
    }

    public static Usuario getSearchedUser(String numeroCuenta) {
        for (Usuario usuario:DBManager.usuarios) {
            if (usuario.getNumeroCuenta().equals(numeroCuenta)) {
                return usuario;
            }
        }
        return null;
    }

    public static Administrador getSearchedAdmin(String numeroCuenta) {
        try {
            return new Administrador();
        } catch (AccountException e) {
            e.printStackTrace();
        }
        return null;
    }
}
