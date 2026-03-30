package calculator.model;

import calculator.model.interpreter.BrainfuckInterpreter;

public class Calculator {
    private final BrainfuckInterpreter interpreter = new BrainfuckInterpreter();
    private StringBuilder bfCode;

    public String addNumbersBf(int number1, int number2) {
         bfCode = new StringBuilder();

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
}
