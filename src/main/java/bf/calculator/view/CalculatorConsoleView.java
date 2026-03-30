package bf.calculator.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CalculatorConsoleView {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void showWelcome() {
        System.out.println("Olá bem vindo a calculadora simples e normal.");
    }

    public String readLine() throws IOException {
        return reader.readLine().toLowerCase();
    }

    public void showLeaving() {
        System.out.println("Saindo..");
    }

    public void showBfCode(String code) {
        System.out.println(code);
    }

    public void showExecuting(String code) {
        System.out.println("Executando:" + code);
    }

    public void showStressWait() {
        System.out.println("Executando... por favor aguarde.");
    }

    public void showScriptNotFound() {
        System.err.println("Arquivo .bf não encontrado na pasta resources/scripts/");
    }

    public void showIoFailure(String message) {
        System.out.println("Falha ao ler o arquivo: " + message);
    }

    public void showDigitRangeError() {
        System.out.println("Apenas números de 0-9");
    }

    public void showUnknownCommand() {
        System.out.println("Não entendi o comando");
    }

    public void showError(String message) {
        System.err.println(message);
    }

    public void showResultLine(String result) {
        System.out.println(result);
    }
}
