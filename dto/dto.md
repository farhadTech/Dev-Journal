

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
