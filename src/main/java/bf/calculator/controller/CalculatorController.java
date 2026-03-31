package bf.calculator.controller;

import bf.Main;
import bf.calculator.model.Calculator;
import bf.calculator.view.CalculatorConsoleView;
import bf.interpreter.BrainfuckInterpreter;

import java.io.IOException;


public class CalculatorController {

    private final BrainfuckInterpreter bfInterpreter;
    private boolean isRunning;
    private final Calculator calculator;
    private final CalculatorConsoleView view;

    public CalculatorController() {
        this.bfInterpreter = new BrainfuckInterpreter();
        this.isRunning = true;
        this.calculator = new Calculator();
        this.view = new CalculatorConsoleView();
    }

    public void start() throws IOException {
        view.showWelcome();
        while (isRunning) {
            calculatorInterface();
        }
    }

    public void calculatorInterface() throws IOException {
        String input = view.readLine();
        if (input.equals("sair")) {
            view.showLeaving();
            isRunning = false;
            return;
        }

        String result = "";

        switch (input) {
            case "-":
                try {
                    calculator.subtractionOperation();
                } catch (IOException | IllegalStateException e) {
                    view.showError(e.getMessage() != null ? e.getMessage() : e.toString());
                }
                break;
            case "+":
                try {
                    calculator.sumOperation();
                } catch (IOException | IllegalStateException e) {
                    view.showError(e.getMessage() != null ? e.getMessage() : e.toString());
                }
                break;
            case "check":
                view.showBfCode(calculator.getBfCode());
                break;
            case "pronto":
                String code = calculator.getBfCode();
                BrainfuckInterpreter.ExecutionResult executionResult = bfInterpreter.interpret(code);

                var frames = executionResult.getFrames();
                var lastFrame = frames.get(frames.size() - 1);
                int[] finalMemory = lastFrame.getMemorySnapshot();

                StringBuilder mathResult = new StringBuilder();
                for (int i = 0; i <=7; i++) {
                    mathResult.append(finalMemory[i]);
                }

                result = String.valueOf(Integer.parseInt(mathResult.toString()));
                calculator.clearBfCode();
                break;
            case "estresse":
                try (var inputStream = Main.class.getResourceAsStream("/scripts/maldebrot.bf")) {
                    if (inputStream == null) {
                        view.showScriptNotFound();
                        return;
                    }

                    String bfCode = new String(inputStream.readAllBytes());
                    view.showStressWait();
                    result = bfInterpreter.interpret(bfCode).toString();
                } catch (Exception e) {
                    view.showIoFailure(e.getMessage());
                    result = "Erro de I/O";
                }
                break;
            default:
                try {
                    int number = Integer.parseInt(input);
                    if (number <= -1) {
                        view.showDigitRangeError();
                        return;
                    }
                    calculator.injectNumber(number);
                } catch (Exception ignored) {
                    view.showUnknownCommand();
                }
                break;
        }
        view.showResultLine(result);
    }
}
