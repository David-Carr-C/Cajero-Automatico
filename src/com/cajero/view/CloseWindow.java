package com.cajero.view;

/**
 * Cierra la ventana Login al iniciar sesion con exito
 * */
public class CloseWindow extends Thread{
    private Login login;
    private FormLogin formLogin;

    /**
     * Obtiene la ventana {@code formLogin} que es la ventana nueva y la ventana actual {@code login}, estas dos interactuan
     * y si se da un inicio con exito en {@code formLogin} se cierra la ventana login
     * */
    public CloseWindow(FormLogin formLogin,Login login) {
        this.formLogin = formLogin;
        this.login = login;
    }

    /**
     * Se inicia el hilo esperando a que isLogged cambie para ejecutar dispose() a la ventana {@code login}
     * */
    @Override
    public void run() {
        while (!formLogin.isLogged) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        login.dispose();
    }
}
