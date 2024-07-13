package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Store;

public class Delete implements UserAction {
    private final Output out;

    public Delete(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        if (tracker.findById(id) == null) {
            out.println("Ошибка удаления заявки.");
        } else {
            tracker.delete(id);
            if (tracker.findById(id) == null) {
                out.println("Заявка удалена успешно.");
            }
        }
        return true;
    }
}
