package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        ArrayList<String> answers = new ArrayList<>();
        answers.add("one");
        answers.add("1");
        Input in = new StubInput(answers);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        ArrayList<String> answers = new ArrayList<>();
        answers.add("6");
        Input in = new StubInput(answers);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(6);
    }

    @Test
    public void manyTimesValidInput() {
        Output out = new StubOutput();
        ArrayList<String> answers = new ArrayList<>();
        answers.add("6");
        answers.add("5");
        answers.add("4");
        answers.add("3");
        answers.add("2");
        answers.add("1");
        Input in = new StubInput(answers);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(6);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(5);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(4);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(3);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(2);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenNegotiveDigitInput() {
        Output out = new StubOutput();
        ArrayList<String> answers = new ArrayList<>();
        answers.add("-6");
        Input in = new StubInput(answers);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-6);
    }
}