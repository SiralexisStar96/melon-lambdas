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
        List<Melon> bailan = Filters.filterByType(melons, "Bailan");

        //Imprimimos el resultado.
        System.out.println("Esta es la lista melones bailan:");
        for (int i = 0; i < bailan.size(); ++i) {

            System.out.println(bailan.get(i).toString());
        }

        //Generamos una nueva lista para filtrar por peso
        List<Melon> found = Filters.filterByWeight(melons, 1200);
        System.out.println("Lista melones de 1200g:" + found);

        List<Melon> mayor = Filters.filterByWeigthMasGradne(melons, 1200);
        System.out.println("Lista melones de mas de 1200g:" + mayor);




    }





}
