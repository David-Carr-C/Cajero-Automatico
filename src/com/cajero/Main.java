package com.cajero;

import com.cajero.model.DBManager;
import com.cajero.view.Login;

/**
 * @author David
 * */
public class Main {
    public static void main(String[] args) {
        DBManager.Refresh(); //Carga los datos
        Login login = new Login();
    }
}
