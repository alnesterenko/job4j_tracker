package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;

public class OrderConvert {
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        // for orders
        for (Order oneOrder : orders) {
            map.put(oneOrder.getNumber(), oneOrder);
        }
        return map;
    }
}