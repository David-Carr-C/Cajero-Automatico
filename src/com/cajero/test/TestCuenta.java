package com.cajero.test;

import com.cajero.exceptions.AccountException;
import com.cajero.model.Credito;
import com.cajero.model.Usuario;
import com.cajero.model.Debito;

@Deprecated
public class TestCuenta {
    public static void main(String[] args) {
        Credito cuentadeCredito = new Credito();
        Debito cuentadeDebito = new Debito();

        Usuario cuenta = null;
        try {
            cuenta = new Usuario( "Paco","1122334455","1234",cuentadeDebito);
        }catch (AccountException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println(cuenta);

    }
}
