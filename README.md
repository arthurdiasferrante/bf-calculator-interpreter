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

- Java 21  
- Maven  
- Spring Boot Web in `pom.xml` 

## Project layout 

- `calculator` — `Main` (entry point).  
- `calculator.controller` —  orchestrates user interaction (console today; Spring `@RestController` can live here later).  
- `calculator.model` — `Calculator` (builds BF programs).  
- `calculator.model.interpreter` — interpreter used by the model (still “model layer,” not HTTP).  
- `src/main/resources/scripts/` — `.bf` example programs.  
- Viewer: terminal I/O today; a future React app would be the view in front of the same API.

## Run (console)

```bash
mvn compile
java -cp target/classes calculator.Main
```

The console flow is driven by `calculator.controller.Controller` (commands like `+`, `pronto`, `estresse`, etc.).

## Portfolio angle

- Interpreter design (instruction dispatch, loops, memory model).  
- UI/UX for making an abstract language tangible (tape + output).  
- Curated BF examples that balance “impressive” with readable.

---

*This README describes the product direction; the visualizer UI and full example set may grow incrementally. Check commits for what’s implemented today.*
