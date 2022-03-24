package lab04;

import lab03.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTests {

    @ParameterizedTest(name = "{0} plus {1} should be equal to {2}.")
    @CsvSource({"1,2,3", "2,3,5", "69, 420, 489"})
    public void add_addsAandB_returnsC(int a, int b, int c) {
        Calculator calc = new Calculator();

        int expectedResult = c;

        int result = calc.add(a, b);

        assertEquals(expectedResult, result);
    }

    @ParameterizedTest(name = "{0} times {1} should be equal to {2}.")
    @CsvSource({"1,2,2", "2,3,6", "69, 420, 28980"})
    public void mull_multipliesAandB_returnsC(int a, int b, int c) {
        Calculator calc = new Calculator();

        int expectedResult = c;

        int result = calc.mul(a, b);

        assertEquals(expectedResult, result);
    }

    @ParameterizedTest(name = "{0} times {1} should be equal to {2}.")
    @CsvSource({"1,2,-1", "6,3,3", "420, 69, 351"})
    public void sub_multipliesAandB_returnsC(int a, int b, int c) {
        Calculator calc = new Calculator();

        int expectedResult = c;

        int result = calc.sub(a, b);

        assertEquals(expectedResult, result);
    }

    @ParameterizedTest(name = "{0} times {1} should be equal to {2}.")
    @CsvSource({"2,2,1", "6,3,2", "28980, 420, 69"})
    public void div_multipliesAandB_returnsC(int a, int b, int c) {
        Calculator calc = new Calculator();

        int expectedResult = c;

        int result = calc.div(a, b);

        assertEquals(expectedResult, result);
    }

    @Test
    public void div_by_zero() {
        Calculator calc = new Calculator();

        assertThrows(ArithmeticException.class, () -> calc.div(12,0));
    }
}
