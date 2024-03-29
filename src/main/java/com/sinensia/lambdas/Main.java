package com.sinensia.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
        List<Melon> heavy = Filters.filterMelons(melons, new HeavyMelonPredicate());

        for(Melon m : heavy){
            System.out.println(m);
        }
        System.out.println("");

        //Interficie como parametro del metodo. Asi nos ahorramos de generar clases
        System.out.println("melones super-peasados: ");
        //Remplazamos por un lambda.
        List<Melon> superheavy = Filters.filterMelons(melons, melon -> melon !=null && melon.getWeight()>=6000);

        for(Melon m : superheavy){
            System.out.println(m);
        }

        System.out.println("melones europeos: ");
        //Remplazamos por un lambda.
        for(Melon m : Filters.filterMelons(melons, melon -> melon !=null && melon.getOrigin().equalsIgnoreCase("Europe"))){
            System.out.println(m);
        }

        //Probamos el filtrado generico
        System.out.println("Lista de sandias");
        List<Melon> watermelons = Filters.filter(melons, (Melon m) ->m.getType().equalsIgnoreCase("watermelon") );
        for(Melon m : watermelons)
        {
            System.out.println(m);
        }

        //Vamos a ver la implementación de Streams
            //implementamos el forEach bucle de lectura
        System.out.println("Stream de melones");
        melons.stream()
                .forEach(melon ->System.out.println(melon));

        //Aplicamos un filtro
        //Imprimimos
        System.out.println("Stream de melones filtrados");
        melons.stream()
                .filter(melon-> "gac".equalsIgnoreCase(melon.getType()))
                .forEach(melon -> System.out.println(melon));


        System.out.println("primer elemento del stream");
        //Encapsulacion de un tipo arbitrario. Control de excepciones
        Optional<Melon> primero = melons.stream()
                .findFirst();
       //Si hay un elemento presente. Lo devolvemos con el get.

        if(primero.isPresent()){
            System.out.println(primero.get());
        }

        //El Bucle if con lamda:
        primero.ifPresent(melon -> System.out.println(melon));

        //Aun más simplificado.
        melons.stream()
                .findFirst()
                .ifPresent(melon -> System.out.println(melon));

        //Mapeo y obtengo pesos y el promedio
        melons.stream()
                .mapToInt(melon -> melon.getWeight())
                .average()
                .ifPresent(average -> System.out.println("Peso promedio: " +average));



    }





}
