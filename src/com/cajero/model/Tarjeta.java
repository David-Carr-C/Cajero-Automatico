package com.cajero.model;

import com.cajero.exceptions.CajeroException;
import com.cajero.exceptions.TarjetaException;

/**
 * Recrear funciones de una tarjeta como tener saldo, consultarl saldo, retirar, depositar y en base a esta clase
 * se extendera para obtener una tarjeta ya sea de credito o debito
 * */
public abstract class Tarjeta {
    private double saldo; //Saldo tiempo real de la tarjeta

    /**
     * Todas las tarjetas tienen un saldo inicial
     * @param saldoInicial Este varia dependiendo si es de credito o debito
     * */
    public Tarjeta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    /**
     * Se debe poder consultar el saldo de la tarjeta, esta funcion tambien es conocida como getSaldo();
     * */
    public double consultarSaldo() {
        return saldo;
    }

    /**
     * Se obtendra mediante una string el tipo de tarjeta que es
     * */
    public abstract String getWhatIs();

    /**
     * Metodo retirar para sacar dinero de la tarjeta
     * @param montoARetirar Este no puede ser mayor al saldo actual
     * @exception CajeroException debe tener control del saldo actual y el monto que se desea retirar
     * */
    public double retirar(double montoARetirar)throws TarjetaException {
        if (montoARetirar > saldo) {
            throw new TarjetaException("No hay suficiente dinero para retirar");
        } else if (montoARetirar <= 0) {
            throw new TarjetaException("No se puede retirar un monto negativo");
        }  else {
            saldo = saldo - montoARetirar;
        }
        return montoARetirar; //todo Obtener cuanto se retiro, aunque hace falta?
    }

    /**
     * Deposita a la tarjeta un monto
     * @param montoADepositar Este no puede ser negativo o 0
     * @exception CajeroException se debe depositar un monto valido
     * */
    public double depositar(double montoADepositar)throws TarjetaException {
        if (montoADepositar<=0) {
            throw new TarjetaException("El monto a depositar no puede ser negativo o cero");
        } else {
            saldo = saldo + montoADepositar;
        }

        return montoADepositar;
    }

}
