# Java Skills

Hands-on software-engineering training repository.

This repository is organized as a sequence of practical modules. Each module contains:

- `THEORY.md` — required theory in English;
- `THEORY_RU.md` — the same module theory in Russian;
- a focused topic and learning objectives;
- implementation tasks;
- constraints and engineering questions;
- self-checking tests;
- submission expectations for review and grading.

## Rules

1. Implement the production code yourself.
2. Do not modify tests merely to make a failing solution pass.
3. Prefer clear, idiomatic Java over clever code.
4. Commit your work with meaningful commit messages.
5. When a module is complete, submit the branch/commit for review.
6. Be prepared to explain every design and language decision.

## Progress

| Module | Topic | Status |
|---|---|---|
| 01 | Java Zero Basics | Ready |

The curriculum will expand from literal Java fundamentals through Core Java, OOP, Collections, Generics, JVM internals, algorithms/data structures, Spring, PostgreSQL, Hibernate, networking, concurrency, testing, Docker, Kubernetes, CI/CD, Linux, observability, cloud, design patterns, system design, and production engineering.


## Test organization rule

For every training module:

- One learning task = one independently runnable test class.
- Unfinished later tasks must not prevent an earlier task from being compiled and tested.
- Each task gets its own Gradle verification task such as `task1Test`, `task2Test`, and so on.
- The module-level `test` task runs the complete set after all tasks are implemented.

This keeps feedback immediate while preserving a full final regression run.
