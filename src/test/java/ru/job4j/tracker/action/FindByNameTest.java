package ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByNameTest {

    @Test
    public void whenFindByNameOneItemSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();

        Item item = new Item("New item");

        tracker.add(item);
        UserAction findByNameAction = new FindByName(output);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("New item");

        findByNameAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + item + ln
        );
    }

    @Test
    public void whenFindByNameManyItemsSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();

        Item item = new Item("New item");
        tracker.add(item);

        Item item2 = new Item("First item");
        tracker.add(item2);

        Item item3 = new Item("New item");
        tracker.add(item3);

        UserAction findByNameAction = new FindByName(output);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("New item");

        findByNameAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + item + ln
                        + item3 + ln
        );
    }

    @Test
    public void whenFindByNameFailure() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();

        tracker.add(new Item("First item"));
        UserAction findByNameAction = new FindByName(output);

        Input input = mock(Input.class);
        String name = "New item";
        when(input.askStr(any(String.class))).thenReturn(name);

        findByNameAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + "Заявки с именем: " + name + " не найдены." + ln
        );
    }

    @Test
    public void whenFindByNameInEmptyTrackerFailure() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();

        UserAction findByNameAction = new FindByName(output);

        Input input = mock(Input.class);
        String name = "New item";
        when(input.askStr(any(String.class))).thenReturn(name);

        findByNameAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + "Заявки с именем: " + name + " не найдены." + ln
        );
    }
}