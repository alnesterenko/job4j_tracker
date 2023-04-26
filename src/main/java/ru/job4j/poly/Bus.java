package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Автобус едет!");
    }

    @Override
    public void passengers(int number) {
        System.out.println("В автобусе " + number + " пассажиров.");
    }

    @Override
    public double refuel(double countOfFuel) {
        double priceForOneLiter = 2.5;
        return countOfFuel * priceForOneLiter;
    }
}
