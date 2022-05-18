package com.sinensia.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Melon> melons = Arrays.asList(
                new Melon("Gac", 5500, "Europe"),
                new Melon("Bailan", 6000, "China"),
                new Melon("Watermelon", 1200, "Europe"),
                new Melon("Gac", 3400, "US"),
                new Melon("Bailan", 1300, "China")
        );

        System.out.println("Esta es la lista melones:");
       for (int i = 0; i < melons.size(); ++i) {
          System.out.println(melons.get(i).toString());
        }

        System.out.println("");

        //Generamos un lista de Objetos Melones y filtramos por tipo.
        List<Melon> bailan = filterByType(melons, "Bailan");

        //Imprimimos el resultado.
        System.out.println("Esta es la lista melones bailan:");
        for (int i = 0; i < bailan.size(); ++i) {

            System.out.println(bailan.get(i).toString());
        }

    }


    //Creamos un metodo statico para filtrar los tipos de melones
    private static List<Melon> filterByType(List<Melon> melons, String bailan) {
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
