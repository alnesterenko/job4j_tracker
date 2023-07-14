package ru.job4j.collection;

import java.util.Comparator;

public class JobIncrByPriority implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o1.getPriority(), o2.getPriority());
    }
}
/*Специальный комментарий, чтобы можно было повторно закомитить этот файл*/