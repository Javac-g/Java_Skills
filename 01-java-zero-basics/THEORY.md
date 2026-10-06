# Theory — Module 01: Java Zero Basics

This file contains the theory required for Module 01. It is intentionally focused on concepts and language rules, not on the task solutions.

## 1. Complete Java source-file structure

For this course, think about Java structure at **two levels**:

1. the structure of the **source file**;
2. the structure of the **type declared inside it**.

A conventional Java source file is organized in this general order:

1. package declaration;
2. import declarations;
3. top-level type declaration;
4. members of that type.

Example:

```java
package com.javacg.skills.basics;

import java.util.List;
import java.util.Objects;

public class StudentProfile {

    // class members
}
```

### 1.1 Package declaration

If present, the package declaration appears before imports and type declarations.

Example:

```java
package com.javacg.skills.basics;
```

There can be at most one package declaration in a source file.

The package name normally follows lowercase reverse-domain naming conventions.

### 1.2 Imports

Imports come after the package declaration and before the top-level type declaration.

Example:

```java
import java.util.List;
import java.util.Map;
```

Static imports are also possible:

```java
import static java.lang.Math.PI;
```

Imports do not "copy" classes into a file. They allow types or static members to be referenced by shorter names.

Types from `java.lang`, such as `String`, `Object`, and `System`, are implicitly available without explicit imports.

### 1.3 Top-level type declaration

After package and imports comes a top-level declaration such as:

- `class`;
- `interface`;
- `enum`;
- `record`;
- annotation interface.

Examples:

```java
public class StudentProfile {}
```

```java
public interface Repository {}
```

```java
public record Point(int x, int y) {}
```

A source file can technically contain multiple top-level types, but at most one top-level public type is normally declared, and its name must match the file name.

Example:

```text
StudentProfile.java
            ↓
public class StudentProfile
```

### 1.4 Complete class header

A class declaration may include:

- annotations;
- access modifier;
- other class modifiers;
- the `class` keyword;
- class name;
- generic type parameters;
- `extends`;
- `implements`;
- `permits` for sealed hierarchies.

Example:

```java
public final class StudentProfile implements Comparable<StudentProfile> {
}
```

More advanced combinations such as `abstract`, `sealed`, `non-sealed`, generics, records, and nested types are covered in later modules.

### 1.5 Conventional order of class members

Inside a class, a common readable layout is:

1. constants (`static final`);
2. static fields;
3. instance fields;
4. static initializer blocks;
5. instance initializer blocks;
6. constructors;
7. public methods;
8. protected methods;
9. package-private methods;
10. private helper methods;
11. getters/setters when explicit accessors are appropriate;
12. nested types.

Example skeleton:

```java
package com.javacg.skills.basics;

import java.util.List;

public class Example {

    // 1. Constants
    public static final int DEFAULT_LIMIT = 10;

    // 2. Static fields
    private static int createdCount;

    // 3. Instance fields
    private String name;

    // 4. Static initializer blocks
    static {
        // class-level initialization
    }

    // 5. Instance initializer blocks
    {
        // object-level initialization
    }

    // 6. Constructors
    public Example(String name) {
        this.name = name;
    }

    // 7. Public methods
    public String describe() {
        return buildDescription();
    }

    // 8. Protected methods
    protected void validateState() {
    }

    // 9. Package-private methods
    void reset() {
    }

    // 10. Private helper methods
    private String buildDescription() {
        return name;
    }

    // 11. Getters/setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 12. Nested types
    static class Helper {
    }
}
```

This ordering is a **style convention**, not a Java compiler requirement. Different teams may use slightly different conventions. The important goals are consistency, readability, and predictability.

## 2. Identifiers and naming conventions

Identifiers can contain letters, digits, underscores, and dollar signs, but cannot start with a digit and cannot be a Java keyword.

Typical conventions:

- class / interface / enum / record: `PascalCase`;
- method / variable / parameter: `camelCase`;
- constant: `UPPER_SNAKE_CASE`;
- package: lowercase, usually reverse-domain style.

Examples:

```java
class PaymentService {}
int retryCount;
static final int MAX_RETRIES = 3;
package com.javacg.skills.basics;
```

## 3. Declaration, initialization, assignment

Declaration introduces a variable:

```java
int count;
```

Initialization gives it its first value:

```java
int count = 10;
```

Assignment changes the value later:

```java
count = 20;
```

## 4. Variable categories

### Local variables

Declared inside methods, constructors, or blocks.

They do **not** receive default values automatically.

```java
void run() {
    int count;
    // System.out.println(count); // compile error
}
```

### Parameters

Variables declared in a method or constructor parameter list.

They receive values from the caller.

### Instance fields

Belong to an object.

Each instance has its own copy unless the field is static.

### Static fields

Belong to the class itself, not to each instance.

## 5. Default initialization

Fields are default-initialized:

- numeric primitives → `0` / `0.0`;
- `boolean` → `false`;
- `char` → `'\u0000'`;
- references → `null`.

Local variables are not automatically initialized.

## 6. Primitive types

Java primitive types:

- `byte`
- `short`
- `int`
- `long`
- `float`
- `double`
- `char`
- `boolean`

Primitive variables store primitive values directly.

## 7. Reference types

Reference variables store references to objects.

Examples:

```java
String name = "Java";
int[] numbers = {1, 2, 3};
StudentProfile profile = new StudentProfile("Alex");
```

The reference variable and the referenced object are conceptually distinct.

## 8. Java is pass-by-value

Java always passes arguments by value.

For primitives, the primitive value is copied.

For objects, the **reference value** is copied.

That means a method can mutate the object reached through the copied reference, but assigning a new object to the method parameter does not replace the caller's variable.

## 9. Identity vs equality

For primitives, `==` compares values.

For references, `==` compares whether two references point to the same object.

Logical equality is usually expressed through `equals()`, which will be covered in a later module.

## 10. Arrays

Arrays are objects in Java.

```java
int[] values = new int[3];
```

The array object is allocated separately from the local reference variable.

Array length is fixed after creation.

Primitive arrays store primitive values directly.

Reference arrays store references.

## 11. Primitive arrays and collections

Collections cannot use primitive type arguments:

```java
List<Integer> values; // valid
// List<int> values;  // invalid
```

This requires boxing between `int` and `Integer`.

An important pitfall:

```java
int[] numbers = {1, 2, 3};
List<int[]> list = Arrays.asList(numbers);
```

This produces a list containing one element: the entire `int[]` array.

## 12. Boxing and unboxing

Boxing:

```java
Integer x = 10;
```

The primitive `int` is converted to `Integer`.

Unboxing:

```java
int y = x;
```

Be careful: unboxing `null` throws `NullPointerException`.

## 13. Static vs instance members

Static members belong to the class:

```java
StudentProfile.getCreatedCount();
```

Instance members belong to an object:

```java
profile.getName();
```

Calling a static method through an instance is legal Java syntax but discouraged because it hides the fact that the method is class-level.

## 14. Initialization order

For a class used for the first time:

1. static fields are initialized in textual order;
2. static initializer blocks run in textual order.

When an object is created:

1. memory is allocated and fields receive default values;
2. instance field initializers run in textual order;
3. instance initializer blocks run in textual order;
4. the constructor body runs.

With inheritance, superclass initialization happens before subclass initialization. We will cover the full hierarchy rules later.

## 15. Constructors

A constructor:

- has the same name as the class;
- has no return type;
- initializes a new object.

Constructor chaining inside the same class uses `this(...)`.

A superclass constructor is invoked with `super(...)`.

## 16. Heap and call stack — first model

For this stage, use this simplified model:

- objects and arrays are typically allocated on the heap;
- each thread has its own call stack;
- method calls create stack frames;
- parameters and local variables belong to the active method frame conceptually;
- reference variables can point to objects on the heap.

Later we will refine this model with JVM internals, escape analysis, scalar replacement, stack frames, operand stacks, and JIT behavior.

## 17. Scope and lifetime

Scope means where a variable name is visible in source code.

Lifetime means how long the variable or object exists during execution.

These are related but not identical.

A local variable can go out of scope while the referenced object remains reachable elsewhere.

## 18. Common mistakes

- assuming local variables get default values;
- confusing reference copying with object copying;
- using `==` when logical equality is intended;
- assuming changing a method parameter reference changes the caller's variable;
- assuming arrays and collections behave the same way;
- forgetting integer overflow;
- calling static methods through instances;
- exposing mutable fields directly;
- mixing class-level state and instance-level state unnecessarily.

## 19. Integer overflow

Arithmetic with `int` operands is normally performed as `int`.

Therefore this can overflow before being assigned to a `long`:

```java
int a = 2_000_000;
int b = 3_000;
long result = a * b;
```

One operand must be promoted before multiplication:

```java
long result = (long) a * b;
```

## 20. What you should be able to explain after this module

You should be able to explain, without memorized wording:

- what a variable is;
- primitive vs reference semantics;
- local vs field initialization;
- static vs instance state;
- scope vs lifetime;
- pass-by-value;
- object identity;
- arrays as objects;
- boxing/unboxing;
- initialization order;
- constructor purpose and chaining;
- the simplified heap/call-stack model;
- why class organization and naming conventions matter.
