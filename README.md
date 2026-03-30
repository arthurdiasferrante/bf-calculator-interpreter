# Brainfuck Visualizer (Portfolio Project)

A Java project that turns Brainfuck from a black box into something you can **see**: the memory tape, the pointer, and how each instruction changes the machine state-plus the program’s text output when execution finishes.

The goal is a small **playground:** runnable examples that stay interesting while staying educational (calculator-style flows, sorting, and other “beginner algorithm” ideas expressed in BF).

## Why this direction

A plain interpreter is easy to underestimate; a **visualizer** shows that you understand the execution model (tape, cells, loops) and can build tooling around it. Pairing that with a **library of example programs** makes the repo useful for others learning the language.

## Planned features

- **Tape view** — cells updating as the program runs; highlight the data pointer.
- **Output** — show accumulated output (e.g. after a run, or step-by-step depending on how far you take it).
- **Example suite** — programs such as a BF-based calculator flow, a sort, and other short “starter” algorithms written in Brainfuck.

## Current stack

- Java 24  
- Maven  
- JavaFX and FlatLaf in `pom.xml`, intended for the desktop UI around the interpreter.

## Project layout (evolving)

- `src/main/java/calculator/interpreter/` — Brainfuck interpreter core.  
- `src/main/resources/scripts/` — `.bf` example programs.  
- `src/main/java/calculator/Main.java` — entry point (console runner while the visualizer is wired up).

## Run (console)

```bash
mvn compile
java -cp target/classes calculator.Main
```

By default, `Main` loads a script from `src/main/resources/scripts/` (e.g. `greetings.bf`). You can point it at another file to try different examples.

## Portfolio angle

- Interpreter design (instruction dispatch, loops, memory model).  
- UI/UX for making an abstract language tangible (tape + output).  
- Curated BF examples that balance “impressive” with readable.

---

*This README describes the product direction; the visualizer UI and full example set may grow incrementally. Check commits for what’s implemented today.*
