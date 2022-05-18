package com.sinensia.lambdas;

public class Melon {
    //CREAMOS LAS VARIABLES EN ESTE CASO CONSTANTES DE CLASE
    private final  String type;
    private final int weight;
    private final  String origin;

    //DECLARAMOS EL CONSTRUCTOR CON LAS VARIABLES
    public Melon(String type, int weight, String origin) {


        this.type = type;

        this.weight = weight;

        this.origin = origin;
    }

    //GENERAMOS UN GETTER DEL TIPO TYPE
    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public String getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        return "Melon{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                ", origin='" + origin + '\'' +
                '}';
    }
}
