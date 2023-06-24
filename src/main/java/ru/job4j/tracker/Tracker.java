package ru.job4j.tracker;

import java.util.ArrayList;

public class Tracker {
    private ArrayList<Item> items = new ArrayList<>(100);
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        int index = 0;
        for (Item oneItem : items) {
            if (oneItem.getId() == id) {
                rsl = index;
                break;
            }
            index++;
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public ArrayList<Item> findAll() {
        return items;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> rsl = new ArrayList<>();
        for (Item oneItem : items) {
            if (key.equals(oneItem.getName())) {
                rsl.add(oneItem);
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean wasReplaced = false;
        if (index != -1) {
            item.setId(id);
            wasReplaced = items.set(index, item) != null;
        }
        return wasReplaced;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean wasDeleted = false;
        if (index != -1) {
            items.remove(index);
        }
        return wasDeleted;
    }
}