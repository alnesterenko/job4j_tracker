package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionCalculatorTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(26D, 37D, 50D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> Math.pow(2, x) + 1);
        List<Double> expected = Arrays.asList(33D, 65D, 129D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenExponentialFunctionStart3End9ThenExponentialResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(3, 9, x -> Math.pow(2, x) + 1);
        List<Double> expected = Arrays.asList(9D, 17D, 33D, 65D, 129D, 257D);
        assertThat(result).containsAll(expected);
    }
}