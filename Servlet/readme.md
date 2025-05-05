## What is Servlet?
A **Servlet** is a Java class that runs on **Servlet container** (like tomcat) and responds to HTTP request -- typically from web browsers or REST clients.

Think of it as the "middleman" between a client and our server-side business logic.

## Core Concepts of Servlet API
* `HttpServletRequest`: Represents the client's request. Includes headers, parameters, body, etc.
* `HttpServletResponse`: Represents the response to send back to the client.
* `Filter`: Intercepts requests before they reach a servlet (e.g., for loggin, security).
* `ServletContext`: Global data shared across the app (e.g., config).
* `HttpSession`: Manages user-specific session data across multiple requests.

## Lifecycle of a Servlet
1. Initialization -- Called once (like a constructor).
2. Service -- Called for every request.
3. Destry -- Called when the servlet is taken down.

## Example Servlet (without Spring)
```java
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
  protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
    response.getWriter().write("Hello, Servlet API!");
  }
}
```

## How Spring Boot Uses the Servlet API
Spring Boot runs on top of the Servlet API and uses it **behind the scenes:**
* Controllers in Spring use `HttpServletRequest` and `httpServletResponse`.
* Filters (like `OncePerRequestFilter`) are built on Servlet Filters.
* The entiire DispatcherServlet mechanism in Spring MVC is a Servlet.

