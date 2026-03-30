package bf.interpreter;

import java.io.IOException;

public class BrainfuckInterpreter {
    private StringBuilder output = new StringBuilder();

    private String interpret(String code) {

        int[] memory = new int[30000];
        int pointer = 0;
        int codePointer = 0;
        output.setLength(0);

        while (codePointer < code.length()) {
            char command = code.charAt(codePointer);

            switch (command) {
                case '>' -> pointer = (pointer + 1) % memory.length;
                case '<' -> pointer = (pointer - 1 < 0) ? memory.length - 1 : pointer - 1;
                case '+' -> memory[pointer] = (memory[pointer] + 1) % 256;
                case '-' -> memory[pointer] = (memory[pointer] == 0) ? 256 : memory[pointer] - 1;
                case '.' -> output.append((char) memory[pointer]);
                case ',' -> {
                    try {
                        memory[pointer] = System.in.read();
                    } catch (IOException e) {
                        memory[pointer] = 0;
                    }
                }
                case '[' -> {
                    if (memory[pointer] == 0) {
                        int loop = 1;
                        while (loop > 0) {
                            command = code.charAt(++codePointer);
                            if (command == '[') loop++;
                            else if (command == ']') loop--;
                        }
                    }
                }
                case ']' -> {
                    if (memory[pointer] != 0) {
                        int loop = 1;
                        while (loop > 0) {
                            command = code.charAt(--codePointer);
                            if (command == '[') loop--;
                            else if (command == ']') loop++;
                        }
                    }
                }
            }
            codePointer++;
        }
        return output.toString();
    }

    public String execute(String code) {
        return this.interpret(code);
    }
}
