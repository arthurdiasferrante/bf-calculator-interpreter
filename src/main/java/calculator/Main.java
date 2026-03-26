package calculator;

import calculator.interpreter.BrainfuckInterpreter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        BrainfuckInterpreter bf = new BrainfuckInterpreter();

        try {
            var resource = Main.class.getResource("/scripts/greetings.bf");
            if (resource == null) {
                System.err.println("Arquivo .bf não encontrado na pasta resources/scripts/");
                return;
            }

            String script = Files.readString(Path.of(resource.toURI()));
            String result = bf.execute(script);

            System.out.println(result);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}