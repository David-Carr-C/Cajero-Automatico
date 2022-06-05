package com.cajero.model;

//Credito es true, y debito es false

import com.cajero.exceptions.AccountException;

public class Usuario extends Account{
    private Tarjeta tarjeta;

    /**
     * Constructor del usuario, este debera tener como extra la tarjeta como ultimo parametro
     * */
    public Usuario(String nombreDeCliente, String numeroDeCuenta, String nip, Tarjeta tarjeta) throws AccountException {
        super(nombreDeCliente, numeroDeCuenta, nip);
        if (tarjeta == null) {
            throw new AccountException("La tarjeta no es valida");
        }
        this.tarjeta = tarjeta;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    @Override
    public String toString() {
        String estadoDelObjeto = super.toString()+ "\nTarjeta: " +getTarjeta();
        return estadoDelObjeto;
    }
}
