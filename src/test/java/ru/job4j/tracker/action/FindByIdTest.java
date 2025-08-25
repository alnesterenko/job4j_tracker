package ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class FindByIdTest {

    @Test
    public void whenItemFindByIdSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();

        Item item = new Item("New item");

        tracker.add(item);
        UserAction findByIdAction = new FindById(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        findByIdAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by id ===" + ln
                        + item + ln
        );
    }

    @Test
    public void whenItemFindByIdFailure() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("New item"));
        int id = 2;
        UserAction findByIdAction = new FindById(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(id);

        findByIdAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by id ===" + ln
                        + "Заявка с введенным id: " + id + " не найдена." + ln
        );
    }
}