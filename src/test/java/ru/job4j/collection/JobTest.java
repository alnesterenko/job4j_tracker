package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {

    @Test
    public void whenCompatorByIncreaseName() {
        Comparator<Job> cmpName = new JobIncrByName();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorByIncreasePriority() {
        Comparator<Job> cmpPriority = new JobIncrByPriority();
        int rsl = cmpPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByIncreasePriorityButElementsIsEquals() {
        Comparator<Job> cmpPriority = new JobIncrByPriority();
        int rsl = cmpPriority.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isEqualTo(0);
    }

    @Test
    public void whenCompatorByDecreaseName() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByDecreasePriority() {
        Comparator<Job> cmpPriority = new JobDescByPriority();
        int rsl = cmpPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorByDescNameAndDescPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("it is not for beauty )))", 0),
                new Job("it is not for beauty )))", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorByIncrNameAndIncrPrority() {
        Comparator<Job> cmpNamePriority = new JobIncrByName().thenComparing(new JobIncrByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("it is not for beauty )))", 0),
                new Job("it is not for beauty )))", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByIncrNameAndDescPrority() {
        Comparator<Job> cmpNamePriority = new JobIncrByName().thenComparing(new JobDescByPriority());
        List<Job> list = Arrays.asList(
                new Job("Impl task", 4),
                new Job("Fix bug", 5),
                new Job("To do something", 1),
                new Job("To do something", 2),
                new Job("Play with cat", 2),
                new Job("Play with cat", 0),
                new Job("Eat", 3)
        );
        Collections.sort(list, cmpNamePriority);
        List<Job> expectedList = Arrays.asList(
                new Job("Eat", 3),
                new Job("Fix bug", 5),
                new Job("Impl task", 4),
                new Job("Play with cat", 2),
                new Job("Play with cat", 0),
                new Job("To do something", 2),
                new Job("To do something", 1)
        );
        assertThat(list).isEqualTo(expectedList);
    }

    @Test
    public void whenCompatorByDescProrityAndIncrName() {
        Comparator<Job> cmpPriorityName = new JobDescByPriority().thenComparing(new JobIncrByName());
        List<Job> list = Arrays.asList(
                new Job("Impl task", 4),
                new Job("Fix bug", 5),
                new Job("To do something", 1),
                new Job("To do something", 2),
                new Job("Play with cat", 2),
                new Job("Play with cat", 0),
                new Job("Eat", 3)
        );
        Collections.sort(list, cmpPriorityName);
        List<Job> expectedList = Arrays.asList(
                new Job("Fix bug", 5),
                new Job("Impl task", 4),
                new Job("Eat", 3),
                new Job("Play with cat", 2),
                new Job("To do something", 2),
                new Job("To do something", 1),
                new Job("Play with cat", 0)
        );
        assertThat(list).isEqualTo(expectedList);
    }
}