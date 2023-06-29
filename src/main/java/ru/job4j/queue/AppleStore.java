package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Customer happyCustomer = null;
        for (int i = 0; i < count; i++) {
            happyCustomer = queue.poll();
        }
        return happyCustomer.name();
    }

    public String getFirstUpsetCustomer() {
        Customer firstUpsetCustomer = null;
        for (int i = 0; i <= count; i++) {
            firstUpsetCustomer = queue.poll();
        }
        return firstUpsetCustomer.name();
    }
}