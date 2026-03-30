package calculator.controller;

import calculator.Main;
import calculator.model.Calculator;
import calculator.model.interpreter.BrainfuckInterpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    private final BrainfuckInterpreter bfInterpreter;
    private boolean isRunning;
    private BufferedReader bufferedReader;
    private final Calculator calculator;

    public Controller() {
        this.bfInterpreter = new BrainfuckInterpreter();
        this.isRunning = true;
        this.calculator = new Calculator();
    }

    public void start() throws IOException {
        System.out.println("Olá bem vindo a calculadora simples e normal.");    
        while (isRunning) {
            calculatorInterface();
        }
    }

    public void calculatorInterface() throws IOException {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine().toLowerCase();
        if (input.equals("sair")) {
            System.out.println("Saindo..");
            isRunning = false;
            return;
        }

        String result = "";

        switch (input) {
            case "-":
                calculator.subtractionOperation();
                break;
            case "+":
                calculator.sumOperation();
                break;
            case "check":
                System.out.println(calculator.getBfCode());
                break;
            case "pronto":
                calculator.printResult();

                String code = calculator.getBfCode();
                System.out.println("Executando:" + code);
                result = bfInterpreter.execute(code);
                calculator.clearBfCode();
                break;
            case "estresse":
                try (var inputStream = Main.class.getResourceAsStream("/scripts/maldebrot.bf")) {
                    if (inputStream == null) {
                        System.err.println("Arquivo .bf não encontrado na pasta resources/scripts/");
                        return;
                    }

                    String bfCode = new String(inputStream.readAllBytes());
                    System.out.println("Executando... por favor aguarde.");
                    result = bfInterpreter.execute(bfCode);
                } catch (Exception e) {
                    System.out.println("Falha ao ler o arquivo: " + e.getMessage());
                    result = "Erro de I/O";
                }
                break;
            default:
                try {
                    int number = Integer.parseInt(input);
                    if (number >= 10 || number <= -1) {
                        System.out.println("Apenas números de 0-9");
                        return;
                    }
                    calculator.newNumber(number);
                } catch (Exception ignored) {
                    System.out.println("Não entendi o comando");
                }
                break;
        }
        showResult(result);
    }

    public void showResult(String result) {
        System.out.println(result);
    }
}
