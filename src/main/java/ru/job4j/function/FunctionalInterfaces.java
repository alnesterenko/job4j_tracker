package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (intg, str) -> map.put(intg, str);
        biCon.accept(1, "one");
        biCon.accept(2, "two");
        biCon.accept(3, "three");
        biCon.accept(4, "four");
        biCon.accept(5, "five");
        biCon.accept(6, "six");
        biCon.accept(7, "seven");
        BiPredicate<Integer, String> biPred = (intg, str) -> intg % 2 == 0 || str.length() == 4;
        for (Integer i : map.keySet()) {
            String tempStr = map.get(i);
            if (biPred.test(i, tempStr)) {
                System.out.println("key: " + i + " value: " + tempStr);
            }
        }
        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        List<String> strings = sup.get();
        Consumer<String> con = (str) -> System.out.println(str);
        Function<String, String> func = (str) -> str.toUpperCase();
        for (String s : strings) {
            con.accept(func.apply(s));
        }
    }
}