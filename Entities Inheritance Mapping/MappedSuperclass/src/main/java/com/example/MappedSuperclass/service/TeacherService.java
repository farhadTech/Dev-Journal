package com.example.MappedSuperclass.service;

import com.example.MappedSuperclass.model.Student;
import com.example.MappedSuperclass.model.Teacher;
import com.example.MappedSuperclass.repository.StudentRepository;
import com.example.MappedSuperclass.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    public void deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
    }
}
