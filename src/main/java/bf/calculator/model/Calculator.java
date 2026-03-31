package bf.calculator.model;

import bf.interpreter.BrainfuckInterpreter;

import java.io.IOException;

public class Calculator {

    private final BrainfuckInterpreter interpreter = new BrainfuckInterpreter();
    private StringBuilder bfCode = new StringBuilder();
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

        return interpreter.interpret(bfCode.toString()).toString();
    }

    public void newNumber(int number) {
        ascii = number + '0';
        bfCode.append("+".repeat(number)).append(">");
    }

    public int getCurrentAscii() {
        return this.ascii;
    }

    public void sumOperation() throws IOException {
        try (var inputStream = Calculator.class.getResourceAsStream("/scripts/soma.bf")) {
            if (inputStream == null) {
                throw new IllegalStateException("Arquivo .bf não encontrado na pasta resources/scripts/");
            }
            String sumCode = new String(inputStream.readAllBytes());
            bfCode.append("<").append(sumCode);
        }
    }

    public void subtractionOperation() throws IOException {
        try (var inputStream = Calculator.class.getResourceAsStream("/scripts/subtração.bf")) {
            if (inputStream == null) {
                throw new IllegalStateException("Arquivo .bf não encontrado na pasta resources/scripts/");
            }
            String sumCode = new String(inputStream.readAllBytes());
            bfCode.append("<").append(sumCode);
        }
    }

    public String getBfCode() {
        return bfCode.toString();
    }

    public void printResult() {
        bfCode.append("<").append("+".repeat(48)).append(".");
    }

    public void clearBfCode() {
        bfCode.setLength(0);
    }

}
