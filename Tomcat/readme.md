# What is Embedded Server (like Tomcat) in Spring Boot?
In a typical **Java web application** (like those built using **Spring Framework**), the app is usually depoloyed to an external server (like Apache Tomcat, WildFly, etc.). But with Spring Boot, things are easier and more modern.

**Spring Boot comes with an embedded server like Tomcat, Jetty, or Undertow, which means the server is built inside our application.**

## 🤷‍♂️ So What does Embedded Server really mean?
It means:
* We don't need to install and configure Tomcat separately.
* We application runs with the server included -- like a self-contained unit.
* We just run our app using `java -jar our-app.jar`, and it starts a web server automatically.

