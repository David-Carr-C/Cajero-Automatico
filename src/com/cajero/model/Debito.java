package com.cajero.model;

public class Debito extends Tarjeta{

    /**
     * Las tarjetas de debito inician con un saldo de 2,000$
     * */
    public Debito() {
        super(2000);
    }
    public Debito(double saldo) {
        super(saldo);
    }

    @Override
    public String getWhatIs() {
        return "Debito";
    }

    @Override
    public String toString() {
        return "Debito, su Saldo actual es: $"+ super.consultarSaldo();
    }
}
