package com.cajero.model;

public class Credito extends Tarjeta {
    private final double INTERES = 3.0/100.0; //Las tarjetas de credito tienen un interes

    /**
     * Su saldo inicial es 10,000$, aunque tendra las propiedades de una tarjeta de credito
     * */
    public Credito() {
        super(10000);
    }
    public Credito(double saldo) {
        super(saldo);
    }

    @Override
    public String getWhatIs() {
        return "Credito";
    }

    @Override
    public String toString() {
        return "Credito, su Saldo actual es: $"+ super.consultarSaldo();
    }
}
