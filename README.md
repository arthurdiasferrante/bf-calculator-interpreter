# Brainfuck Calculator (Portfolio Project)

A Java project focused on building a small calculator concept powered by a Brainfuck interpreter.

The current version executes `.bf` scripts from the project resources and prints the result to the console. It is designed as a portfolio piece to show language parsing/interpreting logic, control flow handling, and clean project organization.

## What this project does

- Interprets Brainfuck code (`> < + - . [ ]`).
- Uses a memory tape with 30,000 cells.
- Supports loop execution with nested bracket matching.
- Loads Brainfuck scripts from `src/main/resources/scripts/`.
- Prints the interpreted output through `Main`.

## Tech Stack

- Java 24
- Maven
- JavaFX dependencies configured in `pom.xml` (for future UI expansion)
- FlatLaf dependency configured (for future visual interface)

## Project Structure

- `src/main/java/calculator/Main.java`  
  Entry point that loads and runs a `.bf` script.
- `src/main/java/calculator/interpreter/BrainfuckInterpreter.java`  
  Core interpreter implementation.
- `src/main/resources/scripts/`  
  Example Brainfuck scripts.

## How to run

### Requirements

- Java 24 installed
- Maven installed

### Steps

```bash
mvn compile
java -cp target/classes calculator.Main
```

By default, `Main` loads:

`src/main/resources/scripts/greetings.bf`

You can change the loaded script in `Main.java` to run other examples.

## Why this is in my portfolio

This project demonstrates:

- Interpreter logic and command-by-command execution
- Control structures and pointer-based memory manipulation
- Code organization in a Java/Maven project
- Foundation for evolving from console execution to a full calculator UI
