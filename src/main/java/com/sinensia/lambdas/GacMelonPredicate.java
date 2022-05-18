package com.sinensia.lambdas;

public class GacMelonPredicate implements MelonPredicate {

    //Creamos la clase con el método a implementar
    @Override
    public boolean test(Melon melon) {
      //  return melon.getType().equalsIgnoreCase("gac");
        return"gac".equalsIgnoreCase(melon.getType());
    }
}
