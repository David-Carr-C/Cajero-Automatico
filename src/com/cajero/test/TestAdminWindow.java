package com.cajero.test;

import com.cajero.exceptions.AccountException;
import com.cajero.model.Administrador;
import com.cajero.view.AdminWindow;

public class TestAdminWindow {
    public static void main(String[] args) throws AccountException {
        AdminWindow adminWindow = new AdminWindow(new Administrador());
    }
}
