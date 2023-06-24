package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        ArrayList<String> answers = new ArrayList<>();
        answers.add("0");
        answers.add("Item name");
        answers.add("1");
        Input in = new StubInput(answers);
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitProgramAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ArrayList<String> answers = new ArrayList<>();
        answers.add("0");
        answers.add(Integer.toString(item.getId()));
        answers.add(replacedName);
        answers.add("1");
        Input in = new StubInput(answers);
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new EditItemAction(out));
        actions.add(new ExitProgramAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        ArrayList<String> answers = new ArrayList<>();
        answers.add("0");
        answers.add(Integer.toString(item.getId()));
        answers.add("1");
        Input in = new StubInput(answers);
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteItemAction(out));
        actions.add(new ExitProgramAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        ArrayList<String> answers = new ArrayList<>();
        answers.add("0");
        Input in = new StubInput(answers);
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitProgramAction());
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
        ArrayList<String> answers = new ArrayList<>();
        answers.add("0");
        answers.add(String.valueOf(one.getId()));
        answers.add(replaceName);
        answers.add("1");
        Input in = new StubInput(answers);
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new EditItemAction(out));
        actions.add(new ExitProgramAction());
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
        ArrayList<String> answers = new ArrayList<>();
        answers.add("0");
        answers.add(needFindId);
        answers.add("1");
        Input in = new StubInput(answers);
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemByIdAction(out));
        actions.add(new ExitProgramAction());
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
        ArrayList<String> answers = new ArrayList<>();
        answers.add("0");
        answers.add(needFindItemName);
        answers.add("1");
        Input in = new StubInput(answers);
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemByNameAction(out));
        actions.add(new ExitProgramAction());
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
        ArrayList<String> answers = new ArrayList<>();
        answers.add("0");
        answers.add("1");
        Input in = new StubInput(answers);
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllItemsAction(out));
        actions.add(new ExitProgramAction());
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
        ArrayList<String> answers = new ArrayList<>();
        answers.add("99");
        answers.add("0");
        Input in = new StubInput(answers);
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitProgramAction());
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