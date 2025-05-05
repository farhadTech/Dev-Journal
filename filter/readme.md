## 1. What is a Filter in Spring Boot?
A **filter** is part of the Servlet API. It sits between the client and our Spring application and can intercept every request and response.

* **Common Use Cases:**
* Logging request/response
* Authenticaton/authorization (before Spring Security existed).
* Request validataion/modification.
* CORS configuration.

* **Creating a Custom Filter**
```java
@Component
public class MyCustomFilter implements Filter {
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) request;
    System.out.print("Request URL: " + req.getRequestURL());

    // Procees with the next filter in the chain
    chai.doFilter(request, response);
  }
}
```
We can also register it manually using `@Bean` and set order/URL patterns with `FilterRegistrationBean`.

## 2. Filter vs Interceptor vs Aspect
| Feature                     | Filter                 | Interceptor             | Aspect (AOP)                 |
| --------------------------- | ---------------------- | ----------------------- | ---------------------------- |
| Layer                       | Servlet layer          | Spring MVC layer        | Bean method layer            |
| Use Case                    | General pre/post logic | Authentication, logging | Business logic cross-cutting |
| Can access request/response | ✅ Yes                  | ✅ Yes                   | ❌ Not directly               |

## 3. Filters in Spring Security
Spring security uses a **filter chain** to secure applications. It adds many filters automatically (like `UsernamePasswordAuthenticationFilte`, `BasicAuthenticationFilter`, etc.).
We can customize or add our own filter inside this chain.

* **Exmaple: Adding a Custom Security Filter**
```java
@Component
public class JWtAuthenticationFilter extends oncePerRequestFilter {
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpSerletResponse response,
  FilterChain filterChain) throw ServletException IOException {
    String token = request.getHeader("Authorization");
    // We can validate token and set authentication here

    filterChain.doFilter(request, response);
  }
}
```

* **Register it in Security Config:**
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Autowired
  private JWtAuthenticationFilter jwtFilter;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
      .csrf().disable()
      .authorizeHttpRequests(auth -> auth
      .requestMatchers("/api/public/**").permitAll()
      .anyRequest().authenticated()
      )
      .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
      .build();
  }
}
```
| Filter Type            | Use                                   |
| ---------------------- | ------------------------------------- |
| Servlet Filter         | Request logging, CORS, general logic  |
| Spring Security Filter | JWT auth, OAuth2, login security      |
| Interceptor            | Spring-specific request preprocessing |
| AOP                    | Business logic cross-cutting concerns |
