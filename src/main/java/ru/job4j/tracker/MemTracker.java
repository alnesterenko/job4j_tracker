package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {
    private List<Item> items = new ArrayList<>(100);
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public Item findById(Integer id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item oneItem : items) {
            if (key.equals(oneItem.getName())) {
                rsl.add(oneItem);
            }
        }
        return rsl;
    }

    public boolean replace(Integer id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public void delete(Integer id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
        }
    }

    @Override
    public void close() {
    }
}