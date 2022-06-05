package com.cajero.test;

import com.cajero.model.Debito;
import junit.framework.TestCase;

public class DebitoTest extends TestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testCreateDebito() {
        Debito debito = new Debito();
        assertEquals(2000.00,debito.consultarSaldo());
    }

    public void testSaldoDebito() {
        Debito debito = new Debito();
        String saldo = debito.toString();
        assertTrue(saldo.contains("$2000"));
    }
}
