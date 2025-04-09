# 📜 DTO (Data Transfer Object) in Spring Boot

### Outline: By the end of this, you'll know:
* What a DTO is and why it's used
* How DTOs work in Spring Boot
* The difference between Entity and DTO
* How to map between Entity and DTO (manually and with MapStruct/ModelMapper)
* A full practical example

### What is DTO?
DTO stands for Data Transfer Object. It's a simple Java object used to transfer data between layers of an application-- for example, from the Controller to the Service or to the Client(API consumer).

It usually contains only fields and getters/setters -- no business logic.

### Why use DTOs?
* Encapsulation: Hide sensitive fields (like passwords, internal IDs).
* Security: Prevent exposing database structure to frontend users.
* Control: Customize what data to send/receive.
* Efficiency: Reduce unnecessay data transfer in APIs.
idation: Ensure that incoming data adheres to the required format.

By following the DTO pattern, we make our application more maintainable, secure, and efficient.


## 🛠 Project Overview
This project demonstrates the use of DTOs (Data Transfer Objects) in a Spring Boot application. DTOs are used to transfer data between the client and the server in a structured and clean way, while decoupling the internal model (entity) from the external API representation.

---

## 📦 Project Structure

```
src/main/java
├── com.example.demo.dto.request       # Request DTOs (e.g., UserRequestDTO)
├── com.example.demo.dto.response      # Response DTOs (e.g., UserResponseDTO)
├── com.example.demo.model             # JPA Entities
├── com.example.demo.mapper            # Mapper classes (Entity <-> DTO)
├── com.example.demo.repository        # Spring Data JPA Repositories
├── com.example.demo.service           # Business logic
└── com.example.demo.controller        # REST Controllers
```

---

## 📚 DTO Pattern

### What is a DTO?
A **Data Transfer Object (DTO)** is an object that carries data between processes, commonly used to:

- ✅ Encapsulate and expose only necessary data to the client
- ✅ Simplify API interaction and enhance security
- ✅ Prevent leaking sensitive or unnecessary internal data

### Types of DTOs Used

- **Request DTO:** Used in POST/PUT requests to receive data from the client
- **Response DTO:** Used in GET requests to return minimal and secure data to the client

---

## 📝 Request DTO Example

### `UserRequestDTO.java`

```java
package com.example.demo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record UserRequestDTO(
        @NotBlank(message = "user name cannot be empty.")
        String username,

        @Email(message = "provide a valid email")
        String email,

        String password
) implements Serializable {}
```

- `username`: Must not be blank
- `email`: Must be a valid format
- `password`: Optional, usually required for creation

---

## 📝 Response DTO Example

### `UserResponseDTO.java`

```java
package com.example.demo.dto.response;

public interface UserResponseDTO {
    Long getId();
    String getUsername();
    String getEmail();
}
```

- Uses **interface-based projection** to return only selected fields from the database
- Improves performance and ensures data privacy

---

## ⚙️ Service Layer

### `UserServiceImpl.java`

```java
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAllProjectedBy();
    }

    @Override
    public void createUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setUsername(userRequestDTO.username());
        user.setEmail(userRequestDTO.email());
        user.setPassword(userRequestDTO.password());
        userRepository.save(user);
    }
}
```

- `getAllUsers()`: Fetches projected users using `UserResponseDTO`
- `createUser()`: Maps `UserRequestDTO` to `User` entity and saves it

---

## 🧑‍💻 Controller Layer

### `UserController.java`

```java
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserResponseDTO findUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        userService.createUser(userRequestDTO);
        return ResponseEntity.ok("User created successfully.");
    }
}
```

- `GET /users/{id}`: Fetches user info using `UserResponseDTO`
- `POST /users`: Creates a user using `UserRequestDTO`

---

## 📡 API Endpoints

| HTTP Method | Endpoint      | Description           |
|-------------|---------------|-----------------------|
| GET         | `/users/{id}` | Get user by ID        |
| POST        | `/users`      | Create a new user     |

---

## ✅ Conclusion

DTOs play a vital role in structuring and optimizing data transfer in a Spring Boot application:

- ✅ **Separation of Concerns**: Internal model is decoupled from external API
- ✅ **Performance Optimization**: Use of projections to fetch only required data
- ✅ **Validation & Security**: Prevent exposure of sensitive fields

By following the DTO pattern, the application becomes more **maintainable**, **secure**, and **efficient**.

---

> Happy coding! 🚀
idation: Ensure that incoming data adheres to the required format.

By following the DTO pattern, we make our application more maintainable, secure, and efficient.