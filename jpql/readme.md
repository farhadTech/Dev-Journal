# JPQL (Java Persistence Query Language) in Spring Boot

JPQL (Java Persistence Query Language) is an object-oriented query language defined by JPA (Java Persistence API). It is similar to SQL but works with **entity objects** instead of database tables.

---

## 1. Basics of JPQL

### Why use JPQL?
- Works with **entity objects** instead of raw tables.
- Provides a **database-independent** query mechanism.
- Uses **object-oriented** syntax, making it easier to work with.
- Supports **named queries, dynamic queries, and native queries**.

### JPQL vs SQL
| Feature         | JPQL Example                                   | SQL Example |
|---------------|----------------------------------|-----------|
| Table Reference | `FROM User u` (uses entity class) | `FROM users` (uses table name) |
| Column Selection | `SELECT u.name FROM User u` | `SELECT name FROM users` |
| Where Clause | `WHERE u.age > 18` | `WHERE age > 18` |

---

## 2. JPQL Annotations in Spring Boot

### Example: Entity Class
```java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String email;

    // Getters and Setters
}
```

### Example: Writing JPQL Queries in a Repository
```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u")
    List<User> findAllUsers();

    @Query("SELECT u FROM User u WHERE u.name = :name")
    User findByName(@Param("name") String name);

    @Query("SELECT u FROM User u WHERE u.age > :age")
    List<User> findUsersOlderThan(@Param("age") int age);

    @Query("SELECT COUNT(u) FROM User u")
    long countTotalUsers();
}
```

---

## 3. Using JPQL in a Service Layer
```java
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> getUsersOlderThan(int age) {
        return userRepository.findUsersOlderThan(age);
    }
}
```

---

## 4. Advanced JPQL Queries

### Sorting Results
```java
@Query("SELECT u FROM User u ORDER BY u.age DESC")
List<User> findAllUsersSortedByAge();
```

### Using LIKE for Partial Search
```java
@Query("SELECT u FROM User u WHERE u.name LIKE %:name%")
List<User> searchUsersByName(@Param("name") String name);
```

### Joins in JPQL
```java
@Query("SELECT u FROM User u JOIN u.address a WHERE a.city = :city")
List<User> findUsersByCity(@Param("city") String city);
```

---

## 5. Named Queries in JPQL

### Defining Named Query in Entity
```java
@Entity
@NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String email;
}
```

### Using Named Query in Repository
```java
@Query(name = "User.findByEmail")
User findByEmail(@Param("email") String email);
```

---

## 6. Using Native SQL Queries in Spring Boot
```java
@Query(value = "SELECT * FROM users WHERE age > ?1", nativeQuery = true)
List<User> findUsersByAgeNative(int age);
```

---

## 7. JPQL Aggregation Functions
```java
@Query("SELECT AVG(u.age) FROM User u")
double findAverageAge();

@Query("SELECT MAX(u.age) FROM User u")
int findMaxAge();

@Query("SELECT MIN(u.age) FROM User u")
int findMinAge();
```

---

## 8. Pagination in JPQL
```java
@Query("SELECT u FROM User u")
Page<User> findAllUsersWithPagination(Pageable pageable);
```

### Calling Pagination in Service
```java
Page<User> usersPage = userRepository.findAllUsersWithPagination(PageRequest.of(0, 5));
List<User> users = usersPage.getContent();
```

---

## Conclusion
- **JPQL is powerful** and works with entity objects instead of raw SQL tables.
- Use `@Query` to write JPQL queries in repositories.
- Use **Named Queries** for reusable JPQL queries.
- Use **Aggregation Functions**, **Joins**, **Pagination**, and **Native Queries** as needed.

📌 _Happy Coding! 🚀_

