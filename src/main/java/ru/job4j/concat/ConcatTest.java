package ru.job4j.concat;

public class ConcatTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String str = "Job4j";
        for (int index = 0; index < 9999; index++) {
            str = str + index;
        }
        System.out.println("Миллисекунд: " + (System.currentTimeMillis() - startTime));

        long startTime2 = System.currentTimeMillis();
        StringBuilder str2 = new StringBuilder("Job4j");
        for (int index = 0; index < 9999; index++) {
            str2.append(index);
        }
        System.out.println("Миллисекунд: " + (System.currentTimeMillis() - startTime));
    }
}