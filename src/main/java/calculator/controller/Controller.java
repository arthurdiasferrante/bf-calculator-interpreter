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
        while (isRunning) {
            calculatorInterface();


        }
    }

    public void calculatorInterface() throws IOException {
        System.out.println("COLOQUE AQUI UM CODIGO EM BRAINFUCK E EU VOU TRADUZI-LO?????");

        String result = bfInterpreter.execute(bufferedReader.readLine());

        showResult(result);
    }

    public void showResult(String result) {
        System.out.println(result);
    }
}
