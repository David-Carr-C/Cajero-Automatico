package com.cajero.test;

import com.cajero.exceptions.AccountException;
import com.cajero.model.Credito;
import com.cajero.model.Debito;
import com.cajero.model.Usuario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Deprecated
public class TestLecturaArchivo {
    private static Credito cre;
    private static Debito deb;
    private static Usuario cuenta;

    public static void main(String[] args) throws Exception {
        String currentPath = new File(".").getCanonicalPath(); //Obtener el path dentro de una carpeta o lugar ubicado en el sistema
        System.out.println(currentPath);
        currentPath = currentPath+"/Testfile.txt";
        //Si el archivo de texto se encuentra en la parte mas externa del proyecto, pero dentro del proyecto solo basta con poner "Database.txt"

        //Podemos usar la ruta o un objeto file para ocupar el FILEREADER
        File miArchivo = new File(currentPath); //Se crea un archivo con el path previo
        FileReader miArchivoComoLectura = new FileReader(miArchivo); //Se hace un fileReader
        BufferedReader miArchivoComoLecturaBuffered = new BufferedReader(miArchivoComoLectura); //Se transforma a objeto Buffered
        String datos = miArchivoComoLecturaBuffered.readLine(); //Se hace la lectura de una sola linea

        String datosEspecificos = datos.substring(0,11); //Sabemos que del caracter 0 al 11 son los numeros de la cuenta
        System.out.println(datosEspecificos); //Numero de cuenta
        String noCuenta = datosEspecificos;

        datosEspecificos = datos.substring(12,16); //Se obtiene el nip que sabemos que ocupa 4 caracteres y van del 12 al 16
        System.out.println(datosEspecificos); //Nip
        String nip = datosEspecificos;

        datosEspecificos = datos.substring(17,18); //Habra un booleano entre la posicion 17 y 18 el cual dira si es debito o credito
        System.out.println(datosEspecificos); //Debito o credito
        String creditoODebito = datosEspecificos;

        //Datos.length es la variable que salio al leer una linea
        datosEspecificos = datos.substring(19,datos.length()); //Y de la posicion 19 en adelante se obtendra el nombre del usuario
        System.out.println(datosEspecificos); //Nombre
        String nombre = datosEspecificos; //Administrador por ejemplo

        try {
            if (creditoODebito.equals("1")) {
                cre = new Credito();
                cuenta = new Usuario(nombre,noCuenta,nip,cre);
            } else {
                deb = new Debito();
                cuenta = new Usuario(nombre,noCuenta,nip,deb);
            }
        } catch (AccountException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println(miArchivoComoLecturaBuffered.readLine());
        System.out.println("De la linea leida sale una cuenta: "+cuenta);

        boolean contiene = datos.contains("Administrador");
        System.out.println("El usuario es administrador?: "+contiene);

        miArchivoComoLectura.close();//Todo fichero que se abre se debe cerrar
    }
}
