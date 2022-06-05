package com.cajero.test;

import com.cajero.exceptions.AccountException;
import com.cajero.model.Credito;
import com.cajero.model.Debito;
import com.cajero.model.Usuario;
import junit.framework.TestCase;

public class UsuarioTest extends TestCase {

    // Configuracion de los test
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }


    public void testNIPExceptionCreateUsuario() {
        try {
            Usuario usuario = new Usuario("NombreCliente","12345678901","NiP", new Debito());
            fail("Nip incorrecto");
        }catch (AccountException e) {
            e.printStackTrace();
        }
    }

    public void testNumeroCuentaExceptionCreateUsuario() {
        try {
            Usuario usuario = new Usuario("NombreCliente","NoCuenta","1234", new Debito());
            fail("No. de cuenta invalido");
        }catch (AccountException e) {
            e.printStackTrace();
        }
    }

    public void testIlegalArgumentCreateUsuario() {
        try {
            Usuario usuario = new Usuario("NombreCliente","12345678901","1234", null);
            fail("Tarjeta invalida");
        }catch (AccountException e) {
            e.printStackTrace();
        }
    }

    public void testCreditoCreateUsuario() throws AccountException {
        Usuario usuario =  new Usuario("NombreCliente","12345678901","1234", new Credito());
        assertTrue(usuario.getTarjeta() instanceof Debito || usuario.getTarjeta() instanceof Credito);
    }

    public void testDebitoCreateUsuario() throws AccountException {
        Usuario usuario =  new Usuario("NombreCliente","12345678901","1234", new Debito());
        assertTrue(usuario.getTarjeta() instanceof Debito || usuario.getTarjeta() instanceof Credito);
    }
}
