package com.example.jpql.repository;

import com.example.jpql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u")
    List<User> findAllUsers();

    @Query("SELECT u FROM User u WHERE u.firstName = :firstName")
    User findUserByFirstName(@Param("name") String firstName);

    @Query("SELECT u FROM User u WHERE u.lastName = :lastName")
    User findUserByLastName(@Param("name") String lastName);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findUserByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.age > :age")
    List<User> findUsersOderThan(@Param("age") int age);

    @Query("SELECT u FROM User u ORDER BY u.age DESC")
    List<User> findAllUsersSortedByAgeDesc();

    @Query("SELECT AVG(u.age) FROM User u")
    double findAverageAge();

    @Query("SELECT MAX(u.age) FROM User u")
    int findMaxAge();

    @Query("SELECT MIN(u.age) FROM User u")
    int findMinAge();

    @Query("SELECT COUNT(u) FROM User u")
    long countTotalUsers();

    // using like for partial search
    @Query("SELECT u FROM User u WHERE u.firstName LIKE %:name%")
    List<User> searchUserByName(@Param("name") String name);

    /* Joins in JPQL
    @Query("SELECT u FROM User u JOIN u.address a WHERE a.city = :city"
    List<User> findUsersByCity(@Param("city") String city);
     */
}


