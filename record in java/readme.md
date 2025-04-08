# ☕ What is `record` in Java?

A `record` is a special kind of class introduced in **Java 14 (preview)** and became a **standard feature in Java 16**. It's designed to **hold immutable data** in a **concise and boilerplate-free** way.

You can think of it as a **data carrier**—perfect for simple classes where you only need to store data, without requiring mutable fields, custom logic, or repetitive code like constructors, getters, `equals()`, `hashCode()`, and `toString()`.

---

## ✏️ Basic Syntax

```java
public record Person(String name, int age) { }
```

This single line automatically provides:

- A constructor: `Person(String name, int age)`
- Accessor methods: `name()` and `age()` (like getters)
- `equals()` and `hashCode()` implementations
- A `toString()` method: `Person[name=Alice, age=30]`

---

## 🧪 Scenario: Representing a Person

Let's say we need to model a `Person` with `name` and `age`.

---

### 🔸 Regular Class Version

```java
public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
```

- **Lines of code**: ~30
- **Boilerplate**: A lot! Especially for `equals()`, `hashCode()`, `toString()`, and the constructor.

---

### ✅ Record Version

```java
public record Person(String name, int age) { }
```

- **Lines of code**: 1
- **Boilerplate**: Gone! Java handles it for you.

---

## ⚙️ What Java Generates Automatically

When you declare a record like this:

```java
public record Person(String name, int age) { }
```

Java automatically provides:

- `String name()` and `int age()` methods
- A canonical constructor: `Person(String name, int age)`
- `equals()` and `hashCode()` methods
- A clean `toString()` output: `Person[name=Alice, age=30]`

---

📌 Records are ideal for:

- Data Transfer Objects (DTOs)
- API request/response models
- Immutable value objects

