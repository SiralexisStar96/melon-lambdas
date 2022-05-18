package com.sinensia.lambdas;

import java.util.ArrayList;
import java.util.List;

public final class Filters {
    //Es una guarda para ver que nadie instancia el constructor
    public Filters(){
        throw new AssertionError("Utility class can not be instantiated");

    }


    //Creamos un metodo statico para filtrar los tipos de melones
    public static  List<Melon> filterByType(List<Melon> melons, String bailan) {
        //Primero guardamos un sitio donde guardar los melones
        List<Melon> x = new ArrayList<>();

        //Iteramos dentro de la propia lista de melones
        for(int i=0 ; i< melons.size(); ++i) {

            //Buscamos entre nuestra lista los de tipo Bailan
            //Hacemos control de nulos

            if (melons!= null && melons.get(i).getType().equals("Bailan")) {

                //Añadimos a la nueva lista
                x.add(melons.get(i));

            }
        }
        return x;

    }

}
