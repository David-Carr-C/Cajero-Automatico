package com.cajero.controller;

import com.cajero.exceptions.AccountException;
import com.cajero.exceptions.TarjetaException;
import com.cajero.model.*;

@Deprecated
public class UserController {
    private Usuario cuenta; //Tipos de objetos a utilizar

    public UserController(Usuario cuenta) {
        this.cuenta = cuenta;

        if (cuenta.getTarjeta() instanceof Credito) {
            System.out.println("Se evalua una instancia con tarjeta de Credito");
        } else {
            System.out.println("Se evalua una instancia con tarjeta de Debito");
        }
    }

    public double mostrarSaldo(){
        return cuenta.getTarjeta().consultarSaldo();
    }

    public double retirar(double num) throws TarjetaException {
        return cuenta.getTarjeta().retirar(num);
    }

    public double depositar(double num)throws TarjetaException {
        return cuenta.getTarjeta().depositar(num);
    }

    public String cambiarNIP(String nuevoNIP)throws AccountException {
        //cuenta.cambiarNIP(nuevoNIP);

        return "NIP Cambiado exitosamente";
    }

}
