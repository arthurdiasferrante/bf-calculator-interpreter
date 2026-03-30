package calculator.controller;

import calculator.Main;
import calculator.model.Calculator;
import calculator.model.interpreter.BrainfuckInterpreter;

import java.io.*;
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
        System.out.println("Digite somar para fazer uma soma");
        while (isRunning) {
            calculatorInterface();

        }
    }

    public void calculatorInterface() throws IOException {
        String input = bufferedReader.readLine().toLowerCase();
        if (input.equals("sair")) {
            System.out.println("Saindo..");
            isRunning = false;
            return;
        }


        String result = "";
        switch (input) {
            case "somar":
                System.out.println("Digite o primeiro número");
                String number1 = bufferedReader.readLine();

                System.out.println("Digite o segundo numero");
                String number2 = bufferedReader.readLine();
                result = calculator.addNumbersBf(Integer.parseInt(number1), Integer.parseInt(number2));
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
        }


        showResult(result);


    }

    public void showResult(String result) {
        System.out.println(result);
    }
}
