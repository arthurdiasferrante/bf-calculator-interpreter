package bf;

import bf.calculator.controller.CalculatorController;

public class Main {

    public static void main(String[] args) {
        try {
            new CalculatorController().start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
