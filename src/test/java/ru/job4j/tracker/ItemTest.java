package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Test
    public void sortAscending() {
        List<Item> items = Arrays.asList(
                new Item("First"),
                new Item("Fourth"),
                new Item("Third"),
                new Item("Second"),
                new Item("Fifth")
        );
        List<Item> expected = Arrays.asList(
                new Item("Fifth"),
                new Item("First"),
                new Item("Fourth"),
                new Item("Second"),
                new Item("Third")
        );
        Collections.sort(items, new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void sortDescending() {
        List<Item> items = Arrays.asList(
                new Item("First"),
                new Item("Fourth"),
                new Item("Third"),
                new Item("Second"),
                new Item("Fifth")
        );
        List<Item> expected = Arrays.asList(
                new Item("Third"),
                new Item("Second"),
                new Item("Fourth"),
                new Item("First"),
                new Item("Fifth")
        );
        Collections.sort(items, new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}