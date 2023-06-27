package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public List<String> extractNumber(List<Task> tasks) {
        HashSet<String> numbersSet = new HashSet<>();
        for (Task oneTask : tasks) {
            numbersSet.add(oneTask.getNumber());
        }
        return List.copyOf(numbersSet);
    }
}
