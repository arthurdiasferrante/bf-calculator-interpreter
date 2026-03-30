package calculator.interpreter;

import calculator.model.interpreter.BrainfuckInterpreter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrainfuckInterpreterTest {

    @Test
    void shouldReturnHelloWorld() {
        BrainfuckInterpreter interpreter = new BrainfuckInterpreter();

        String bfHelloWorld = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
        String result = interpreter.execute(bfHelloWorld);

        assertEquals("Hello World!\n", result);
    }

    @Test
    void shouldReturnEmptyStringForEmptyCode() {
        BrainfuckInterpreter interpreter = new BrainfuckInterpreter();

        String result = interpreter.execute("");

        assertNotNull(result);
        assertEquals("", result);
    }
}