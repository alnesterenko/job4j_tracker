package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        List<String> answers = Arrays.asList("0", "Item name", "1");
        Input in = new StubInput(answers);
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(new CreateAction(out), new ExitProgramAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        List<String> answers = Arrays.asList("0", Integer.toString(item.getId()), replacedName, "1");
        Input in = new StubInput(answers);
        List<UserAction> actions = Arrays.asList(new EditItemAction(out), new ExitProgramAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        List<String> answers = Arrays.asList("0", Integer.toString(item.getId()), "1");
        Input in = new StubInput(answers);
        List<UserAction> actions = Arrays.asList(new DeleteItemAction(out), new ExitProgramAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        List<String> answers = Arrays.asList("0");
        Input in = new StubInput(answers);
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(new ExitProgramAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu." + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
        );
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        List<String> answers = Arrays.asList("0", String.valueOf(one.getId()), replaceName, "1");
        Input in = new StubInput(answers);
        List<UserAction> actions = Arrays.asList(new EditItemAction(out), new ExitProgramAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu." + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
        );
    }

    @Test
    public void findItemByIdActionTest() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test10"));
        String needFindId = String.valueOf(two.getId());
        List<String> answers = Arrays.asList("0", needFindId, "1");
        Input in = new StubInput(answers);
        List<UserAction> actions = Arrays.asList(new FindItemByIdAction(out), new ExitProgramAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + two + ln
                        + "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
        );
    }

    @Test
    public void findItemByNameActionTest() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test10"));
        String needFindItemName = "test10";
        List<String> answers = Arrays.asList("0", needFindItemName, "1");
        Input in = new StubInput(answers);
        List<UserAction> actions = Arrays.asList(new FindItemByNameAction(out), new ExitProgramAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + two + ln
                        + "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
        );
    }

    @Test
    public void showAllItemsActionTest() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test10"));
        List<String> answers = Arrays.asList("0", "1");
        Input in = new StubInput(answers);
        List<UserAction> actions = Arrays.asList(new ShowAllItemsAction(out), new ExitProgramAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + one + ln
                        + two + ln
                        + "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        List<String> answers = Arrays.asList("99", "0");
        answers.add("99");
        answers.add("0");
        Input in = new StubInput(answers);
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(new ExitProgramAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit Program" + ln
        );
    }
}