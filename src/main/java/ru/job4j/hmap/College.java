package ru.job4j.hmap;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {

    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        return students.keySet()
                .stream()
                .filter(s -> s.account().equals(account))
                .findFirst();
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional foundStudent = findByAccount(account);
        Optional<Subject> result = Optional.empty();
        if (foundStudent.isPresent()) {
            result = students.get(foundStudent.get())
                    .stream()
                    .filter(s -> s.name().equals(name))
                    .findFirst();
        }
        return result;
    }

}