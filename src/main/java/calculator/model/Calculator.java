package calculator.model;

import calculator.Main;
import calculator.model.interpreter.BrainfuckInterpreter;

import java.io.IOException;

public class Calculator {
    private final BrainfuckInterpreter interpreter = new BrainfuckInterpreter();
    private StringBuilder bfCode = new StringBuilder("");;
    private int ascii;

    public String addNumbersBf(int number1, int number2) {

        // o que isso faz? cheque

        // coloca o primeiro número na célula 0 (ex: "+++")
        bfCode.append("+".repeat(number1));

        // depois, move para a célula 1 (">") e coloca o segundo número ("ex: "++")
        bfCode.append(">");
        bfCode.append("+".repeat(number2));

        // loop da soma
        bfCode.append("[<+>-]");

        // o resultado está na célula 0, voltamos o ponteiro para lá
        bfCode.append("<");

        bfCode.append("+".repeat(48));
        bfCode.append(".");

        //

        return interpreter.execute(bfCode.toString());
    }

    public void newNumber(int number) {
        ascii = number + '0';
        bfCode.append(",").append(ascii);
    }

    public int getCurrentAscii() {
        return this.ascii;
    }


    public void sumOperation() {
        try (var inputStream = Main.class.getResourceAsStream("/scripts/soma.bf")) {
            if (inputStream == null) {
                System.err.println("Arquivo .bf não encontrado na pasta resources/scripts/");
                return;
            }
            String sumCode = new String(inputStream.readAllBytes());
            bfCode.append(sumCode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void subtractionOperation() {
        try (var inputStream = Main.class.getResourceAsStream("/scripts/subtração.bf")) {
            if (inputStream == null) {
                System.err.println("Arquivo .bf não encontrado na pasta resources/scripts/");
                return;
            }
            String sumCode = new String(inputStream.readAllBytes());
            bfCode.append(sumCode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getBfCode() {
        return bfCode.toString();
    }

    public String confirmationMethod() {
        return interpreter.execute(bfCode.toString());
    }
}