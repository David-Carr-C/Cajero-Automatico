package com.cajero.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    public static List<Usuario> usuarios;

    /**
     * Actualiza la lista de usuarios en el programa
     * */
    public static void Refresh() {
        usuarios = Read();
    }

    /**
     * Añade un usuario a la base de datos, el orden sera: Nombre, No° Cuenta, NIP, TipoTarjeta, Saldo
     * @param usuario
     * */
    public static void Create(Usuario usuario) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Usuarios.txt", true))) {
            bufferedWriter.write(usuario.getNombreCliente()+"$ "+usuario.getNumeroCuenta()+"$ "
                                    +usuario.getNIP()+"$ "+ usuario.getTarjeta().getWhatIs()+"$ "
                                    +usuario.getTarjeta().consultarSaldo()+"$\n");
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Refresh(); //Necesitamos este metodo aqui para que automaticamente cada vez que se cree un nuevo usuario se actualice el array
    }

    /**
     * Lee toda la base de datos de usuarios
     * @return {@code List< Usuario > Array de usuarios}
     * */
    public static List<Usuario> Read() {
        List<Usuario> users = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Usuarios.txt"))) {
            String line = "";
            while ( (line = bufferedReader.readLine()) != null) {
                SepareString separeString = new SepareString(line);
                List<String> arrData = separeString.sub$tring();

                if (arrData.get(3).equals("Credito"))
                    users.add(new Usuario(arrData.get(0), arrData.get(1), arrData.get(2) , new Credito(Double.parseDouble(arrData.get(4)) )));
                else
                    users.add(new Usuario(arrData.get(0), arrData.get(1), arrData.get(2) , new Debito(Double.parseDouble(arrData.get(4))  )));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * Actualiza el usuario. Actualiza el usuario en el array de usuarios, y reescribimos el archivo con el contenido
     * de todos los usuarios
     * */
    public static void Update(Usuario usuario) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Usuarios.txt", true))) {
            ChangeAttributeUser(usuario); //Actualiza el usuario en el array de usuarios
            DropDB(); //Vacia el archivo
            usuarios.forEach(DBManager::Create); //Reescribe el archivo con los usuarios en el array
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina el usuario. Elimina el usuario en el array de usuarios, sobreescribe el archivo de la base de datos con un "" y
     * despues escribe sobre el archivo 'Usuarios.txt' toda nuestra array de usuarios
     * */
    public static void Delete(Usuario usuario) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Usuarios.txt", true))) {
            EliminateUser(usuario); //Elimina el usuario en el array de usuarios
            DropDB(); //Vacia el archivo
            usuarios.forEach(DBManager::Create); //Reescribe el archivo con los usuarios en el array
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

                    // Seccion extra: Metodos sobre el array de usuarios y DropDB

    /**
     * Vacia el archivo Usuarios.txt. Escribe sin el argumento append, por lo tanto se
     * sobreescribe en el archivo una string vacia ""
     * */
    private static void DropDB() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Usuarios.txt"))) {
            bufferedWriter.write("");
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza el usuario en el array de usuarios. busca el usuario a actualizar, compara los numeros de cuentas
     * y hace una asignacion del nuevo usuario (con los stats cambiados) al usuario encontrado
     * */
    private static void ChangeAttributeUser(Usuario user) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNumeroCuenta().equals(user.getNumeroCuenta())) {
                usuarios.set(i,user);
            }
        }
        // Excepcion de usuario no encontrado
    }

    /**
     * Elimina el usuario en el array de usuarios. busca el usuario a eliminar, compara los numeros de cuenta y
     * ejecuta remove() en el usuario que coincide
     * */
    private static void EliminateUser(Usuario user) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNumeroCuenta().equals(user.getNumeroCuenta())) {
                usuarios.remove(i);
            }
        }
        // Excepcion de usuario no encontrado
    }
}
