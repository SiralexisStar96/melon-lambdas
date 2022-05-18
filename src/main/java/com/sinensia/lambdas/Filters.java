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



    public static List<Melon> filterByWeight(List<Melon> melons, int weigth) {
        if(melons == null ) {
            throw new IllegalArgumentException("Melons/type cannot be null");
        }
        if(melons.isEmpty()) {
            return melons;
        }
        List<Melon> pesos = new ArrayList<>();

        for(Melon melon : melons) {
            if(melon!=null && melon.getWeight() == weigth) {
                pesos.add(melon);
            }
        }
        return pesos;
    }


    public static List<Melon> filterByWeigthMasGrande(List<Melon> melons){

        int i = 1200;

        if(melons == null ) {
            throw new IllegalArgumentException("Melons/type cannot be null");
        }
        if(melons.isEmpty()) {
            return melons;
        }
        List<Melon> masGrande = new ArrayList<>();
        for(Melon melon : melons) {
            if(melon!=null && melon.getWeight() >  i) {

                masGrande.add(melon);
            }
        }
        return masGrande;

    }

    public static List<Melon> filterMelons(List<Melon> melons, MelonPredicate predicate){
        if(melons == null){
            //reviento
            throw new AssertionError("Utility class can not be instantiated");
        }

        List<Melon> result = new ArrayList<>();
        for(Melon melon : melons){
            if(melon!=null && predicate.test(melon))
            {
                result.add(melon);
            }

        }
        return result;
    }
    //Filtro generico para filtrar por melones
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate){
        if(list == null){
            //reviento
            throw new AssertionError("List cannot be null");
        }

        List<T> result = new ArrayList<>();
        for(T t: list){
            if(t!=null && predicate.test(t))
            {
                result.add(t);
            }

        }
        return result;
    }

}
