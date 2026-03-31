package bf.calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void newNumberMethodShouldConvertDigitToAsciiCode() {
        Calculator calculator = new Calculator();
        calculator.injectNumber(5);

        Assertions.assertEquals(53, calculator.getCurrentAscii());
    }
}
