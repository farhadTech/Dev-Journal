# What is @EntityGraph?
In JPA, relationships like @OneToMany, @ManyToOne, etc., are lazy-loaded by default. This means when you fetch an entity, its related entities are not loaded immediately--They're fetched later, one by one, which can be inefficient.

**@EntityGraph tells JPA which associations to fetch eagerly in a single query, instead of lazily loading them later.

## The N+1 Problem (Quick Reminder)
Say you have a **User** entity and each **User has a list of **Post**s.

```java
@Entity
public class User {
  @Id
  private Long id;

  @OneToMany(mappedBy = "user")
  private List<Post> posts;
}
```
If we fetch 10 users, and each time their posts are fetched separately, that's 1 query for users + 10 queries for posts = N+1 queries.

## Solution: Use @EntityGraph
```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  @EntityGraph(attributePaths = {"posts"})
  List<User> findAll();
}
```
### What this does:
* it tells JPA: "When you fetch Users, also fetch the posts right away using a "JOIN."
* JPA will now generate a single SQL query that joins User and Post.

### Syntax
```java
@EntityGraph(
  value = "User.posts", // optional if using named graphs
  attributePaths = {"posts", "profile", "settings"}
)
```
We can also define named graphs inside your entity.
```java
@Entity
@NamedEntityGraph(
  name = "User.detail",
  attributeNodes = {
    @NamedAttributeNode("posts")
    @NamedAttributeNode("profile")
  }
)

public class User {
  // fields
}
```
and then use it in the repository
```java
@EntityGraph(value = "User.detail")
List<User> findAll();
```
## When to Use
* to control fetch behavior without changing entity annotations
* to prevent the N+1 problem.
* to customize which relations are loaded per query.

### Quick Example
```java
@Entity
public class Post {
  @Id
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private User user;
}

@Entity
public class User {
  @Id
  private Long id;

  @OneToMany(mappedBy = "user")
  private List<Post> posts;
}

public interface PostRepository extends JpaRepository<Post, Long> {
  @EntityGraph(attributePaths = {"user"})
  List<Post> findAll();
}
```
Now when we call postRepository.findAll(), each post's user is also fetched in the same query.

## With and Without @EntityGraph and SQL queries
### Example Entities
```java
@Entity
public class User {
  @Id
  private Long id,
  private String name;

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  private List<Post> posts;
}

@Entity
public class Post {
  @Id
  private Long id;
  private String title;

  @ManyToOne(fetch = FetchType.LAZY)
  private User user;
}
```

## Without @EntityGraph
### Repository:
```java
List<User> findAll();
```
### Code:
```java
List<User> users = userRepository.findAll();
for(User user : users) {
  System.out.print(user.getPosts().size());
}
```
### SQL Output:
```sql
--Query 1: Fetch all users
select u.id, u.name from user u;

--Query 2: For each user, fetch their posts seprately (N times)
select p.id, p.title, p.user_id from post p where p.user_id = ?;
select p.id, p.title, p.user_id from post p where p.user_id = ?;
```
This is the N+1 problem: 1 query for users + N queries for posts.

## With @EntityGraph
### Repository
```java
@EntityGraph(attributePaths = {"posts"})
List<User> findAll();
```
### Code:
```java
List<User> users = userRepository.findAll();
for(User user : users) {
  System.out.print(user.getPosts().size());
}
```
### SQL Output:
```sql
-- Single query with join
select u.id, u.name, p.id, p.title, p.user_id
from user u
left outer join post p on u.id = p.user_id;
```
Now all users and their posts are fetched in one query with a LEFT JOIN.
```