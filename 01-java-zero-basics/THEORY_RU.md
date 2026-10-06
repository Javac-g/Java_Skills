# Теория — Модуль 01: Java с абсолютного нуля

Этот файл содержит теорию, необходимую для Module 01. Он специально сосредоточен на понятиях и правилах языка, а не на готовых решениях заданий.

## 1. Полная структура Java source file

В рамках этого курса структуру Java нужно рассматривать на **двух уровнях**:

1. структура самого **исходного файла**;
2. структура **типа**, объявленного внутри него.

Типичный Java source file организуется в таком общем порядке:

1. package declaration;
2. import declarations;
3. top-level type declaration;
4. члены этого типа.

Пример:

```java
package com.javacg.skills.basics;

import java.util.List;
import java.util.Objects;

public class StudentProfile {

    // class members
}
```

### 1.1 Package declaration

Если package declaration присутствует, оно располагается перед imports и объявлениями типов.

Пример:

```java
package com.javacg.skills.basics;
```

В одном source file может быть не более одного package declaration.

Имена пакетов обычно пишутся строчными буквами и следуют reverse-domain convention.

### 1.2 Imports

Imports располагаются после package declaration и до top-level type declaration.

Пример:

```java
import java.util.List;
import java.util.Map;
```

Возможны и static imports:

```java
import static java.lang.Math.PI;
```

Import не «копирует» класс в файл. Он позволяет ссылаться на типы или static members по короткому имени.

Типы из `java.lang`, например `String`, `Object` и `System`, доступны неявно и не требуют explicit import.

### 1.3 Top-level type declaration

После package и imports идёт top-level declaration, например:

- `class`;
- `interface`;
- `enum`;
- `record`;
- annotation interface.

Примеры:

```java
public class StudentProfile {}
```

```java
public interface Repository {}
```

```java
public record Point(int x, int y) {}
```

Технически один source file может содержать несколько top-level типов, но обычно объявляется не более одного top-level public type, и его имя должно совпадать с именем файла.

Пример:

```text
StudentProfile.java
            ↓
public class StudentProfile
```

### 1.4 Полный class header

Объявление класса может включать:

- annotations;
- access modifier;
- другие class modifiers;
- ключевое слово `class`;
- имя класса;
- generic type parameters;
- `extends`;
- `implements`;
- `permits` для sealed hierarchy.

Пример:

```java
public final class StudentProfile implements Comparable<StudentProfile> {
}
```

Более сложные комбинации с `abstract`, `sealed`, `non-sealed`, generics, records и nested types будут разобраны в следующих модулях.

### 1.5 Типичный порядок членов класса

Внутри класса распространён такой читаемый порядок:

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
11. getters/setters, если явные accessors уместны;
12. nested types.

Пример каркаса:

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

Этот порядок — **style convention**, а не требование Java compiler. Разные команды могут использовать немного разные conventions. Главные цели — consistency, readability и predictability.

## 2. Identifiers и naming conventions

Identifier может содержать буквы, цифры, underscore и знак доллара, но не может начинаться с цифры и не может совпадать с Java keyword.

Типичные conventions:

- class / interface / enum / record: `PascalCase`;
- method / variable / parameter: `camelCase`;
- constant: `UPPER_SNAKE_CASE`;
- package: lowercase, обычно reverse-domain style.

Примеры:

```java
class PaymentService {}
int retryCount;
static final int MAX_RETRIES = 3;
package com.javacg.skills.basics;
```

## 3. Declaration, initialization, assignment

Declaration вводит переменную:

```java
int count;
```

Initialization задаёт ей первое значение:

```java
int count = 10;
```

Assignment изменяет значение позже:

```java
count = 20;
```

## 4. Категории переменных

### Local variables

Объявляются внутри methods, constructors или blocks.

Они **не получают default values автоматически**.

```java
void run() {
    int count;
    // System.out.println(count); // compile error
}
```

### Parameters

Переменные, объявленные в parameter list метода или конструктора.

Они получают значения от caller.

### Instance fields

Принадлежат конкретному объекту.

У каждого instance есть собственное значение такого поля, если поле не `static`.

### Static fields

Принадлежат самому классу, а не каждому отдельному instance.

## 5. Default initialization

Fields получают default values автоматически:

- numeric primitives → `0` / `0.0`;
- `boolean` → `false`;
- `char` → `'\u0000'`;
- references → `null`.

Local variables автоматически не инициализируются.

## 6. Primitive types

Примитивные типы Java:

- `byte`
- `short`
- `int`
- `long`
- `float`
- `double`
- `char`
- `boolean`

Primitive variable хранит примитивное значение непосредственно.

## 7. Разрядность примитивов, диапазоны и numeric conversions

Важно различать две вещи:

1. **логическую разрядность/диапазон Java primitive type**;
2. **фактический объём памяти, используемый конкретной JVM implementation**.

Для numeric primitives Java точно определяет диапазоны значений. Но реальный memory footprint полей, элементов массивов, local variables и stack-frame slots может отличаться из-за JVM implementation details, alignment, object layout и JIT optimizations.

### 7.1 Primitive types и диапазоны

| Type | Логическая разрядность | Диапазон |
|---|---:|---|
| `byte` | 8 bits | -128 .. 127 |
| `short` | 16 bits | -32,768 .. 32,767 |
| `int` | 32 bits | -2^31 .. 2^31 - 1 |
| `long` | 64 bits | -2^63 .. 2^63 - 1 |
| `float` | 32 bits | IEEE 754 single precision |
| `double` | 64 bits | IEEE 754 double precision |
| `char` | 16 bits | 0 .. 65,535 |
| `boolean` | storage зависит от JVM/context | значения языка: `true` / `false` |

### 7.2 Важное замечание о `boolean`

Язык Java определяет только два boolean values:

```java
true
false
```

Не следует считать, что каждый boolean всегда занимает ровно один byte памяти.

Физическое хранение зависит от контекста и JVM implementation.

### 7.3 `char` — не всегда один полный Unicode character

Java `char` хранит один UTF-16 code unit.

Некоторые Unicode characters требуют двух `char`, образующих surrogate pair.

Поэтому `char` не всегда равен «одному отображаемому человеку символу».

### 7.4 Integer literal defaults

Integer literal вроде:

```java
100
```

обычно имеет тип `int`.

Для `long` literal обычно используется `L`:

```java
100L
```

Лучше использовать uppercase `L`, потому что lowercase `l` легко спутать с цифрой `1`.

### 7.5 Floating-point literal defaults

Floating-point literal вроде:

```java
3.14
```

по умолчанию имеет тип `double`.

Для `float` нужен суффикс `F` или `f`:

```java
3.14F
```

### 7.6 Widening primitive conversions

Java может автоматически выполнять многие widening conversions.

Основная цепочка:

```text
byte -> short -> int -> long -> float -> double
```

Для `char`:

```text
char -> int -> long -> float -> double
```

Пример:

```java
byte b = 10;
int i = b;
long l = i;
double d = l;
```

Explicit cast не требуется.

### 7.7 Widening не всегда означает сохранение точной precision

Это важный нюанс.

Conversion может быть законным widening conversion, даже если exact numeric precision теряется.

Пример:

```java
long value = 9_007_199_254_740_993L;
double converted = value;
```

Conversion законен, но `double` не может точно представить каждое возможное значение `long`.

### 7.8 Narrowing primitive conversions

Переход к меньшему или несовместимому primitive type обычно требует explicit cast.

Пример:

```java
int value = 130;
byte result = (byte) value;
```

Информация может быть потеряна.

Cast не делает conversion безопасным — он лишь сообщает compiler, что программист осознанно принимает это преобразование.

### 7.9 Специальные compile-time constant assignments

Java разрешает некоторые constant integer expressions присваивать меньшим integral types без cast, если значение помещается в диапазон.

Пример:

```java
byte b = 100;
short s = 30_000;
char c = 65;
```

Но это не распространяется на произвольные runtime values:

```java
int x = 100;
// byte b = x; // compile error without cast
```

### 7.10 Binary numeric promotion

В арифметических выражениях маленькие integral types часто автоматически продвигаются до `int`.

Пример:

```java
byte a = 10;
byte b = 20;

// byte c = a + b; // compile error
int c = a + b;
```

Выражение `a + b` вычисляется как `int`.

Это относится к `byte`, `short` и `char` во многих arithmetic expressions.

### 7.11 Promotion при смешанных numeric types

Удобная модель для обычной binary arithmetic:

- если хотя бы один operand — `double`, второй продвигается до `double`;
- иначе, если хотя бы один — `float`, второй продвигается до `float`;
- иначе, если хотя бы один — `long`, второй продвигается до `long`;
- иначе оба operands продвигаются до `int`.

Примеры:

```java
int + long     -> long
long + float   -> float
float + double -> double
byte + byte    -> int
char + short   -> int
```

### 7.12 Почему return type не управляет типом выражения

Это особенно важно для Task 1.

```java
long result = intA * intB;
```

Сначала выполняется multiplication.

Так как оба operands имеют тип `int`, само multiplication выполняется как `int`.

Только после этого результат widening-конвертируется в `long`.

Следовательно, overflow может произойти ещё до присваивания.

Чтобы заставить арифметику выполняться как `long`:

```java
long result = (long) intA * intB;
```

Теперь один operand имеет тип `long`, поэтому binary numeric promotion сначала преобразует второй operand в `long`.

### 7.13 Compound assignment содержит implicit narrowing behavior

Это законно:

```java
byte b = 10;
b += 1;
```

Но это:

```java
byte b = 10;
// b = b + 1; // compile error
```

не эквивалентно с точки зрения type checking compiler.

Compound assignment выполняет implicit conversion обратно к типу левой части.

Это может скрывать narrowing и потерю информации, поэтому важно понимать правило, а не просто запоминать синтаксис.

### 7.14 Unary numeric promotion

Unary operators `+`, `-` и `~` могут продвигать маленькие integral types до `int`.

Пример:

```java
byte b = 10;
int x = -b;
```

### 7.15 Primitive width и фактическая память JVM

Не используем слишком упрощённое правило:

```text
"int всегда занимает ровно 4 bytes в памяти"
```

Для `int` действительно определён 32-bit signed диапазон.

Но фактическое использование памяти зависит от контекста:

- object fields зависят от object alignment и padding;
- arrays имеют object header плюс storage элементов;
- stack frames — implementation detail JVM;
- JIT может вообще устранить некоторые переменные;
- compressed references влияют на размер references, а не на логическую разрядность primitive values.

В будущих JVM-модулях отдельно разберём object layout, stack frames, alignment, compressed ordinary object pointers, escape analysis и inspection через инструменты вроде JOL.

### 7.16 Карта widening conversions

Для automatic widening:

```text
byte
  ↓
short
  ↓
int
  ↓
long
  ↓
float
  ↓
double

char
  ↓
int
  ↓
long
  ↓
float
  ↓
double
```

Automatic numeric conversion между `boolean` и numeric types отсутствует.

## 8. Reference types

Reference variable хранит reference на object.

Примеры:

```java
String name = "Java";
int[] numbers = {1, 2, 3};
StudentProfile profile = new StudentProfile("Alex");
```

Reference variable и object, на который она указывает, концептуально являются разными сущностями.

## 9. Java — pass-by-value

Java всегда передаёт arguments **по значению**.

Для primitives копируется primitive value.

Для objects копируется **значение reference**.

Поэтому method может изменить object через скопированный reference, но присваивание нового object параметру метода не заменяет переменную caller.

## 10. Identity vs equality

Для primitives оператор `==` сравнивает значения.

Для references `==` проверяет, указывают ли две references на один и тот же object.

Logical equality обычно задаётся через `equals()`, который будет подробно изучаться в отдельном модуле.

## 11. Arrays

Array в Java является object.

```java
int[] values = new int[3];
```

Array object существует отдельно от local reference variable.

Размер массива фиксируется после создания.

Primitive arrays хранят primitive values.

Reference arrays хранят references.

## 12. Primitive arrays и Collections

Collections не могут использовать primitive type arguments:

```java
List<Integer> values; // valid
// List<int> values;  // invalid
```

Поэтому между `int` и `Integer` требуется boxing/unboxing.

Важная ловушка:

```java
int[] numbers = {1, 2, 3};
List<int[]> list = Arrays.asList(numbers);
```

Результат — list из одного элемента, где этот единственный элемент является всем массивом `int[]`.

## 13. Boxing и unboxing

Boxing:

```java
Integer x = 10;
```

Primitive `int` преобразуется в `Integer`.

Unboxing:

```java
int y = x;
```

Важно: unboxing значения `null` приводит к `NullPointerException`.

## 14. Static vs instance members

Static members принадлежат классу:

```java
StudentProfile.getCreatedCount();
```

Instance members принадлежат конкретному object:

```java
profile.getName();
```

Вызов static method через instance синтаксически допустим, но нежелателен, потому что скрывает class-level nature метода.

## 15. Initialization order

При первом использовании класса:

1. static fields инициализируются в textual order;
2. static initializer blocks выполняются в textual order.

При создании object:

1. выделяется память и fields получают default values;
2. instance field initializers выполняются в textual order;
3. instance initializer blocks выполняются в textual order;
4. выполняется constructor body.

При inheritance superclass initialization происходит раньше subclass initialization. Полный порядок по иерархии будет отдельной темой.

## 16. Constructors

Constructor:

- имеет то же имя, что и class;
- не имеет return type;
- участвует в initialization нового object.

Constructor chaining внутри одного класса выполняется через `this(...)`.

Superclass constructor вызывается через `super(...)`.

## 17. Heap и call stack — первая модель

На этом этапе используем упрощённую, но полезную модель:

- objects и arrays обычно размещаются в heap;
- у каждого thread есть собственный call stack;
- method calls создают stack frames;
- parameters и local variables концептуально относятся к активному method frame;
- reference variables могут указывать на objects в heap.

Позже эта модель будет уточнена через JVM internals, escape analysis, scalar replacement, stack frames, operand stack и JIT behavior.

## 18. Scope и lifetime

Scope — где имя переменной видимо в source code.

Lifetime — как долго variable или object существует во время execution.

Это связанные, но не одинаковые понятия.

Local variable может выйти из scope, а referenced object продолжит существовать, если на него остаются другие reachable references.

## 19. Типичные ошибки

- считать, что local variables получают default values;
- путать копирование reference с копированием object;
- использовать `==`, когда нужна logical equality;
- считать, что присваивание parameter внутри метода меняет caller variable;
- считать arrays и collections взаимозаменяемыми;
- забывать про integer overflow;
- вызывать static methods через instance;
- открывать mutable fields напрямую;
- без необходимости смешивать class-level state и instance-level state.

## 20. Integer overflow

Арифметика с двумя `int` operands обычно выполняется как `int`.

Поэтому:

```java
int a = 2_000_000;
int b = 3_000;
long result = a * b;
```

может переполниться до присваивания в `long`.

Нужно заранее поднять хотя бы один operand до `long`:

```java
long result = (long) a * b;
```

## 21. Что нужно уметь объяснить после модуля

После завершения Module 01 ты должен уметь своими словами объяснить:

- что такое variable;
- primitive vs reference semantics;
- local vs field initialization;
- static vs instance state;
- scope vs lifetime;
- pass-by-value;
- object identity;
- arrays как objects;
- boxing/unboxing;
- initialization order;
- назначение constructors и constructor chaining;
- упрощённую модель heap/call stack;
- почему naming и class/source-file organization важны;
- numeric widening/narrowing и promotion;
- почему арифметическое expression может overflow до присваивания результату более широкого типа.
