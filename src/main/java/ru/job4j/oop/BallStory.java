package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ballBread = new Ball();
        Hare kosoy = new Hare();
        kosoy.tryEat(ballBread);
        Wolf seriy = new Wolf();
        seriy.tryEat(ballBread);
        Fox foxi = new Fox();
        foxi.tryEat(ballBread);

    }
}
