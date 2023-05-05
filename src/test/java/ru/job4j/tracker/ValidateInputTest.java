package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"6"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(6);
    }

    @Test
    public void manyTimesValidInput() {
        String[] answers = {"6", "5", "4", "3", "2", "1"};
        Output out = new StubOutput();
        Input in = new StubInput(answers);
        ValidateInput input = new ValidateInput(out, in);
        for (int i = 0; i < answers.length; i++) {
            int selected = input.askInt("Enter menu:");
            assertThat(selected).isEqualTo(Integer.parseInt(answers[i]));
        }

    }

    @Test
    public void whenNegotiveDigitInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-6"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-6);
    }
    /*Комментарий, для того, чтобы можно было повторить попытку пуша.
    * Предыдущая не удалась из-за проблем с интернетом.*/
}