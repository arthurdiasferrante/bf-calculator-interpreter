package calculator.controller;

import calculator.model.Calculator;
import calculator.model.interpreter.BrainfuckInterpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Controller {
    private BrainfuckInterpreter bfInterpreter;
    private boolean isRunning;
    private BufferedReader bufferedReader;
    private Calculator calculator;



    public Controller() {
        this.bfInterpreter = new BrainfuckInterpreter();
        this.isRunning = true;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.calculator = new Calculator();

    }

    public void start() throws IOException {
        System.out.println("Olá bem vindo a calculadora simples e normal.");
        while (isRunning) {
            calculatorInterface();

        }
    }

    public void calculatorInterface() throws IOException {
//        String input = bufferedReader.readLine();
//        if (input.equals("sair")) {
//            System.out.println("Saindo..");
//            isRunning = false;
//            return;
//        }

        System.out.println("Digite o primeiro número");
        String number1 = bufferedReader.readLine();

        System.out.println("Digite o segundo numero");
        String number2 = bufferedReader.readLine();

        String result = calculator.addNumbersBf(Integer.parseInt(number1), Integer.parseInt(number2));

        showResult(result);

    }

    public void showResult(String result) {
        System.out.println(result);
    }
}
