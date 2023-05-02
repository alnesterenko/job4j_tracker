package ru.job4j.tracker;

public class ConsoleOutput implements Output {
    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }
    /*Комментарий для того, чтобы можно было снова закоммитить этот файл*/
}