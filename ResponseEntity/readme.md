# What is ResponseEntity in Spring Boot?
> ResponseEntity<T> is a powerful feature in Spring Boot that represents an HTTP response, including status code, headers, and body. It provides more control over the response compared to returning just an object or ResponseBody.

### Why use ResponseEntity
* Allows setting custom HTTP status code.
* Enables Adding custom headers to responses.
* Provides flexibility in handling error responses.
* Useful for RESTful APIs by making responses more descriptive.

### Basic Syntax of ResponseEntity
ResponseEntity<T> response = new ResponseEntity<>(body, header, status)

T: The type of response body
body: The actual data to return
headers: Additional metadata in key-value pairs.
status: HTTP response status. (e.g., 200 ok, 404 not found.)

### 1. Returning a Simple Response.
```
@GetMapping("/hello")
public ResponseEntity<String> hello() {
  return new ResponseEntity<> ("Hello, World!", HttpStatus.ok);
}
```

### 2. Using ResponseEntity with JSON Response.
When using REST APIs, it's common to return JSON data.
```
@RestController
@RequestMapping("/api/users")
public class UserController {
  @GetMapping("/{id}")
  public ResponseEntity<User> getUser(@PathVariable Long id) {
    User user = new User(id, "John Smith", "johnsmith@example.com");
    return ResponseEntity.ok(user);
  }
}
```

### 3. Adding Custom Headers
You can customize HTTP headers using ResponseEntity
```
@GetMapping("/custom-header")
public ResponseEntity<String> customHeader() {
  HttpHeaders headers = new HtttpHeaders();
  headers.add("Custom-Header", "customValue");
  return new ResponseEntity<>("Custom Header Example", headers, HttpStatus.ok);
}
```
### 4. Handling Not Found(404) Error with ResponseEntity
```
@GetMapping("/{id}")
public ResponseEntity<User> getUserById(@PathVariable Long id) {
  Optional<User> user = userService.findById(id);

  if(user.isPresent()) {
    return ResponseEntity.ok(user.get());
  } else {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
}
```

### 5. Using ResponseEntity.badRequest() for validation errors.
```
@PostMapping("/create")
public ResponseEntity<String> createUser(@RequestBody User user) {
  if(user.getName() == null || user.getEmail() == null) {
    return ResponseEntity.badRequest().body("Invalid data provided.!");
  } else {
    return ResponseEntity.ok("User created successfully.");
  }
}
```

### 6. Using ResponseEntity with Exception Handling
```
@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler (UserNotFoundException.class)
  public ResponseEnity<String> HandleUser NotFoundException(UserNotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
  }
}
```

### 7. ResponseEntity with ResponseEntity.ok() and ResponseEntity.status()
```
// for successful response (200 ok)
return ResponseEntity.ok("success")

// for creating resource (201 created)
return ResponseEntity.status(HttpStatus.CREATED).body("Resource Created.");
```