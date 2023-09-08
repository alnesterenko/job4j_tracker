package ru.job4j.collection;

import java.util.Comparator;

/**
 * Класс-компаратор, который реализует сложную сортировку.
 *
 * @author alnesterenko
 * @version 1.0
 */
public class DepDescComp implements Comparator<String> {
    /**
     * Метод, который сортирует строки в обратном порядке,
     * но если у строк первые два символа одинаковы, то сортирует в порядке возрастания.
     *
     * @param str1 строка для сравнения
     * @param str2 строка для сравнения
     * @return возвращает число -- результат сравнения.
     */
    @Override
    public int compare(String str1, String str2) {
        String[] splitStr1 = str1.split("/", 2);
        String[] splitStr2 = str2.split("/", 2);
        return splitStr2[0].compareTo(splitStr1[0]) != 0 ? splitStr2[0].compareTo(splitStr1[0]) : str1.compareTo(str2);
    }
}