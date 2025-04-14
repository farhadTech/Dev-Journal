# 📌 What is `@MappedSuperclass`?

`@MappedSuperclass` is a JPA annotation used to define a **base class** whose fields should be inherited by child entity classes — but the base class **does not get its own table** in the database.

---

## ✨ Why Use `@MappedSuperclass`?

Think of it like this:

✅ You want to avoid repeating common fields like `id`, `createdAt`, `updatedAt`, etc., across multiple entities.

✅ You define those fields once in a superclass and annotate it with `@MappedSuperclass`.

---

## 📎 Key Points

- ❌ It’s **not an entity itself** — no table will be created for it.
- ✅ It can include annotations like `@Id`, `@Column`, `@Temporal`, etc.
- 🚫 It **cannot be queried directly** like `@Entity` or `@Inheritance`.

---

## 🧱 Example Usage

### 📂 Base Class

```java
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
```

### 👨‍💼 Child Entity

```java
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee extends BaseEntity {
    private String name;
    private String department;
}
```

### 🧾 Result

- The `Employee` table will have the fields: `id`, `createdAt`, `updatedAt`, `name`, and `department`.
- But **there will be no table named `BaseEntity`** in the database.

---

## 🧠 When to Use `@MappedSuperclass`?

Use `@MappedSuperclass` when:
- You have multiple entities **sharing common fields and behavior**.
- You **don’t need polymorphic queries** on the base class.
- You want **clean, DRY code** without repeating common field declarations.

---