package com.cajero.test;

import com.cajero.exceptions.AccountException;
import com.cajero.model.Credito;
import com.cajero.model.DBManager;
import com.cajero.model.Debito;
import com.cajero.model.Usuario;
import junit.framework.TestCase;

public class DBManagerTest extends TestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        DBManager.Refresh();
    }

    public void testWriteNRead() throws Exception {
        Usuario prueba = null;
        DBManager.Create(new Usuario("Doomie", "12341234123", "1111", new Credito()));
        for (Usuario account:DBManager.usuarios) {
            if (account.getNombreCliente().equals("Doomie")) {
                prueba = account;
            }
        }
        assertEquals("Doomie", prueba.getNombreCliente());
    }

    public void testReadName() {
        Usuario prueba = DBManager.usuarios.get(1);
        assertEquals("Test", prueba.getNombreCliente());
    }

    public void testReadNoCuenta() {
        Usuario prueba = DBManager.usuarios.get(1);
        assertEquals("11223344556", prueba.getNumeroCuenta());
    }

    public void testReadNIP() {
        Usuario prueba = DBManager.usuarios.get(1);
        assertEquals("2222", prueba.getNIP());
    }

    public void testReadDebito() {
        Usuario prueba = DBManager.usuarios.get(1);
        assertEquals("Debito", prueba.getTarjeta().getWhatIs());
        assertTrue(prueba.getTarjeta() instanceof Debito);
    }

    public void testReadCredito() {
        Usuario prueba = DBManager.usuarios.get(0);
        assertEquals("Credito", prueba.getTarjeta().getWhatIs());
        assertTrue(prueba.getTarjeta() instanceof Credito);
    }

    public void testReadSaldo() {
        Usuario prueba = DBManager.usuarios.get(0);
        assertEquals(8000.0, prueba.getTarjeta().consultarSaldo());
    }

    public void testDeleteUser() throws AccountException {
        String numeroDeCuentaAEliminar = "12341234123"; //Los demas atributos no sirven, es mejor solo necesitar un no cuenta y nip
        Usuario prueba = new Usuario("Doomie", numeroDeCuentaAEliminar, "1111", new Credito());
        DBManager.Delete(prueba); //Mejor pasar solo nip y numero de cuenta(?

        for (Usuario usuario:DBManager.usuarios) {
            assertTrue(!usuario.getNumeroCuenta().equals(numeroDeCuentaAEliminar));
        }
    }

    public void testCreateUser() throws Exception {
        Usuario prueba = null;
        DBManager.Create(new Usuario("TestUser", "11111111111", "1111", new Debito()));
        for (Usuario account:DBManager.usuarios) {
            if (account.getNombreCliente().equals("TestUser")) {
                prueba = account;
            }
        }
        assertEquals("TestUser", prueba.getNombreCliente());
    }

    public void testUpdateUser() throws AccountException {
        String numeroDeCuentaAActualizar = "11111111111"; //De TestUser
        Usuario prueba = new Usuario("ChangingTest", numeroDeCuentaAActualizar, "0000", new Credito(10_000));
        DBManager.Update(prueba); //Actualizacion de datos metiante la creacion de un nuevo usuario pero un unico noCuenta
        //Si el noCuenta no se encuentra, no se actualiza nada

        for (Usuario usuario:DBManager.usuarios) {
            if (usuario.getNumeroCuenta().equals(numeroDeCuentaAActualizar)) {
                assertTrue(usuario.getNumeroCuenta().equals(numeroDeCuentaAActualizar));
                assertEquals(numeroDeCuentaAActualizar, usuario.getNumeroCuenta());
                assertEquals("0000", usuario.getNIP());
                assertEquals(new Credito(10000).getWhatIs(), usuario.getTarjeta().getWhatIs());
                assertEquals(new Credito(10000).consultarSaldo(), usuario.getTarjeta().consultarSaldo());
            }
        }
    }
}
