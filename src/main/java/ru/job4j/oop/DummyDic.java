package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        String s = "Неизвестное слово. " + eng;
        return s;
    }

    public static void main(String[] args) {
        DummyDic translator = new DummyDic();
        System.out.println(translator.engToRus("pipe"));
    }
}
