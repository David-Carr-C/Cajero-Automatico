package com.cajero.model;

import com.cajero.exceptions.AccountException;

public class Administrador extends Account {
    public Administrador() throws AccountException {
        super("Administrador", "00000000000", "0000");
    }

    // Metodos del administrador
    public void altaCliente(Usuario usuario) {
        DBManager.Create(usuario);
    }

    public void bajaCliente(Usuario usuario) {
        DBManager.Delete(usuario);
    }

    public void modificacionCliente(Usuario usuario) {
        DBManager.Update(usuario);
    }
}
