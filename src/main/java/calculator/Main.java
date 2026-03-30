package calculator;

import calculator.controller.Controller;
import calculator.model.interpreter.BrainfuckInterpreter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        try {
            var resource = Main.class.getResource("/scripts/greetings.bf");
            if (resource == null) {
                System.err.println("Arquivo .bf não encontrado na pasta resources/scripts/");
                return;
            }

            controller.start();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}