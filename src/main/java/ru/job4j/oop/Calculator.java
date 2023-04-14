package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int d) {
        return sum(d) + multiply(d) + minus(d) + divide(d);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println("Method sum result: " + result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println("Method multiply result: " + rsl);
        System.out.println("Method minus result: " + minus(6));
        System.out.println("Method divide result: " + calculator.divide(10));
        System.out.println("Method sumAllOperation result, when d == 5: " + calculator.sumAllOperation(5));
    }
}