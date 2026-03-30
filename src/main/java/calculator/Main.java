package calculator;

import calculator.controller.Controller;

public class Main {

    public static void main(String[] args) {
        try {
            new Controller().start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
