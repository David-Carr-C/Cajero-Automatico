package com.cajero.model;

import java.util.ArrayList;
import java.util.List;

public class SepareString {
    private String principal;

    // Se instancia la clase con una string a ser evaluada
    public SepareString(String principal) {
        this.principal = principal;
    }

    /**
     * Este metodo evalua la string {@code principal}, crea una copia de esta para la modificacion y creacion de substrings,
     * siendo asi, realizaremos un while el cual terminara cuando deje de haber '$' en las substrings, por cada iteracion
     * del while crearemos una cadena {@code out} que corta la cadena hasta el '$', {@code out} se guardara en el
     * array {@code palabras}, y despues se sobreescribira la copia actual a una donde se corte desde el '$' hasta el final
     * de la cadena, siendo asi que cada iteracion añadimos una cadena al array, y acortamos mas {@code copy} hasta terminar
     * el while.
     * @return {@code List<<String>> palabras}
     * */
    public List<String> sub$tring() {
        List<String> arr = new ArrayList<>();
        String copy = principal;

        while (copy.contains("$")){
            int position = copy.indexOf('$');
            String out = copy.substring(0,position);
            arr.add(out);

            if (copy.length() < position+2)
                break;

            copy = copy.substring(position+2);
        }

        return arr;
    }
}

/* *
 *
 * posicion = principal.indexOf('$');
 * out = principal.substring(posicion,principal.length());
 * arr.add(out);
 * */