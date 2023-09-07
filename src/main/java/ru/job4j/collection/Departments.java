package ru.job4j.collection;

import java.util.*;

/**
 * Класс, который добавляет пропущенные подразделения, а также производит сортировку подразделений
 *
 * @author alnesterenko
 * @version 1.0
 */
public class Departments {

    /**
     * Метод принимает список подразделений. Режет полные названия подразделений
     * и создаёт все возможные названия подразделений.
     * Полученные резултаты складывает в набор LinkedHashSet, чтобы избежать дублирования.
     *
     * @param deps -- список подразделений.(Может быть не полным.)
     * @return List<String> -- итоговый список подразделений,
     * полученный после копирования всех значений из временного набора LinkedHashSet.
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmpSet = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start += (start.equals("") ? "" : "/") + el;
                tmpSet.add(start);
            }
        }
        return new ArrayList<>(tmpSet);
    }

    /**
     * Метод производящий сортировку естественным порядком(в порядке возрастания).
     *
     * @param orgs -- список, который нужно отсортировать.
     */
    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    /**
     * Метод производящий хитрозакрученную сортировку.
     *
     * @param orgs -- список, который нужно отсортировать.
     * @link DepDescComp
     */
    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}