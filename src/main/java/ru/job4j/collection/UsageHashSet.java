package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<>();
        autos.add("Lada");
        autos.add("BMW");
        autos.add("Volvo");
        autos.add("Toyota");
        for (String oneAuto : autos) {
            System.out.println(oneAuto);
        }
    }
    /*Push с первого разу не прошёл, поэтому появился этот комментарий*/
}