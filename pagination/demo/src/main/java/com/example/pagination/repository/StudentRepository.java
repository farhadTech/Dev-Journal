package com.example.pagination.repository;

import com.example.pagination.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "select * from Student where city = :city",
        countQuery = "select count(*) from Student where city = :city",
            nativeQuery = true
    )
    Page<Student> findAllByCity(@Param("city") String city, Pageable pageable);

}
