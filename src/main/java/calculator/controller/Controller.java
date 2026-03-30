package calculator.controller;

import calculator.model.interpreter.BrainfuckInterpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Controller {
    private BrainfuckInterpreter bfInterpreter;
    private boolean isRunning;
    private BufferedReader bufferedReader;



    public Controller() {
        this.bfInterpreter = new BrainfuckInterpreter();
        this.isRunning = true;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void start() throws IOException {
        System.out.println("COLOQUE AQUI UM CÓDIGO EM BRAINFUCK E EU VOU TRADUZI-LO?????");
        String bfCommands = "+-><[]., ";
        while (isRunning) {
            calculatorInterface(bfCommands);

        }
    }

    public void calculatorInterface(String bfCommands) throws IOException {
        String input = bufferedReader.readLine();

        if (input.equals("sair")) {
            System.out.println("Saindo..");
            isRunning = false;
            return;
        }
        char[] inputCharArray = input.toCharArray();
        for (Character chars : inputCharArray) {
            if (!bfCommands.contains(chars.toString())) {
                System.out.println("Comando inválido");
                return;
            }
        }

        String result = bfInterpreter.execute(input);
        showResult(result);

    }

    public void showResult(String result) {
        System.out.println(result);
    }
}
