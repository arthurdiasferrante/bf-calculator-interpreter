package calculator.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;


class CalculatorTest {

    @Test
    void newNumberMethodShouldConvertDigitToAsciiCode() {
        Calculator calculator = new Calculator();
        calculator.newNumber(5);

        Assertions.assertEquals(53, calculator.getCurrentAscii());

    }
}