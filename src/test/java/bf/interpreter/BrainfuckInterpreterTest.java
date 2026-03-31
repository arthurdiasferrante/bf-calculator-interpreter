package bf.interpreter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BrainfuckInterpreterTest {

    @Test
    void shouldReturnHelloWorld() {
        BrainfuckInterpreter interpreter = new BrainfuckInterpreter();

        String bfHelloWorld = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
        String result = interpreter.interpret(bfHelloWorld).toString();

        assertEquals("Hello World!\n", result);
    }

    @Test
    void shouldReturnEmptyStringForEmptyCode() {
        BrainfuckInterpreter interpreter = new BrainfuckInterpreter();

        String result = interpreter.interpret("").toString();

        assertNotNull(result);
        assertEquals("", result);
    }
}
