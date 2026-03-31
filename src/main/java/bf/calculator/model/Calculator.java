package bf.calculator.model;

import bf.interpreter.BrainfuckInterpreter;

import java.io.IOException;

public class Calculator {

    private final BrainfuckInterpreter interpreter = new BrainfuckInterpreter();
    private StringBuilder bfCode = new StringBuilder();
    private int ascii;

    public void injectNumber(int number) {
        // trabalhamos com 3 registradores, A (num 1) B (num 2) e o C é o resultado

        // A (num 1): sempre ocupa da célula 0 até a célula 7
        // B (num 2): sempre ocupa da célula 8 até a célula 15.
        // C (resultado): sempre ocupa da célula 16 até a 23.

        // saber onde se localiza cada número facilita no cálculo das contas

        // a ideia aqui é forçar o número ter 8 zeros a esquerda
        String paddedNumber = String.format("%08d", number);

        for (char digitChar : paddedNumber.toCharArray()) {
            int digit = digitChar - '0';

            bfCode.append("+".repeat(digit)).append(">");
        }
    }

    public int getCurrentAscii() {
        return this.ascii;
    }

    // voce não tem ideia o quao dificil e isso

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
        try (var inputStream = Calculator.class.getResourceAsStream("/scripts/subtracao.bf")) {
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
