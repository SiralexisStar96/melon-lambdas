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


        System.out.println("");
        List<Melon> mayor = Filters.filterByWeigthMasGrande(melons);
        System.out.println("Lista melones de mas de 1200g:" + mayor);


        System.out.println("");

        //APLICAMOS EL GAC PARA FILTRAR.
        System.out.println("melones gac:");
        //GacMelonPredicate gacMelonPredicate = new GacMelonPredicate();
        List<Melon> gac = Filters.filterMelons(melons, new GacMelonPredicate());

        for(Melon m : gac){
            System.out.println(m);


        }
        System.out.println("");

        //Otro ejemplo con melones pesados
        System.out.println("melones heavy:");
        //GacMelonPredicate gacMelonPredicate = new GacMelonPredicate();
        List<Melon> heavy = Filters.filterMelons(melons, new HeavyMelonPredicate());

        for(Melon m : heavy){
            System.out.println(m);

        }
        System.out.println("");

        System.out.println("melones super-peasados: ");
        //GacMelonPredicate gacMelonPredicate = new GacMelonPredicate();
        List<Melon> superheavy = Filters.filterMelons(melons, new MelonPredicate() {
            @Override
            public boolean test(Melon melon) {
                return melon !=null && melon.getWeight()>=6000;
            }
        });

        for(Melon m : superheavy){
            System.out.println(m);

        }




    }





}
