package ru.job4j.oop;

public class Cat {
    private String name;
    private String food;

    public void giveNick(String nike) {
        this.name = nike;
    }

    public void show() {
        System.out.println(this.name + " ate " + this.food + ".");
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("kotleta");
        gav.show();
        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        black.show();
    }
}
