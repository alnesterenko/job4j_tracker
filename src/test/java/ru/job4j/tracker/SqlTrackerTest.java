package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenReplaceItemAndFindByIdThenMustBeEqualToNewName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item firstItem = new Item("First_item");
        Item secondItem = new Item("Second_item");
        firstItem = tracker.add(firstItem);
        tracker.replace(firstItem.getId(), secondItem);
        assertThat(tracker.findById(firstItem.getId())).isEqualTo(secondItem);
    }

    @Test
    public void whenDeleteItemAndCouldntFindItById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item firstItem = new Item("First_item");
        firstItem = tracker.add(firstItem);
        assertThat(tracker.findById(firstItem.getId())).isEqualTo(firstItem);
        tracker.delete(firstItem.getId());
        assertThat(tracker.findById(firstItem.getId())).isNull();
    }

    @Test
    public void whenAddedTwoItemsAndFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item firstItem = new Item("First_item");
        Item secondItem = new Item("Second_item");
        List<Item> testList = List.of(firstItem, secondItem);
        tracker.add(firstItem);
        tracker.add(secondItem);
        assertThat(tracker.findAll()).isEqualTo(testList);
    }

    @Test
    public void whenAddedTwoItemsToDBAndListsNotEquals() {
        SqlTracker tracker = new SqlTracker(connection);
        Item firstItem = new Item("First_item");
        Item secondItem = new Item("Second_item");
        Item thirdItem = new Item("Third_item");
        List<Item> testList = List.of(firstItem, secondItem, thirdItem);
        tracker.add(firstItem);
        tracker.add(secondItem);
        assertThat(tracker.findAll()).isNotEqualTo(testList);
    }

    @Test
    public void whenAddedTwoItemsWithTheSameNamesAndFoundThemAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item firstItem = new Item("First_item");
        Item secondItem = new Item("Second_item");
        Item thirdItem = new Item("Second_item");
        List<Item> testList = List.of(secondItem, thirdItem);
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        assertThat(tracker.findByName("Second_item")).isEqualTo(testList);
    }

    @Test
    public void whenAddedTwoItemsWithTheSameNamesAndFoundOneById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item firstItem = new Item("First_item");
        Item secondItem = new Item("Second_item");
        Item thirdItem = new Item("Second_item");
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        assertThat(tracker.findById(thirdItem.getId())).isEqualTo(thirdItem);
    }
}