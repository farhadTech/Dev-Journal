package com.example.pagination.controller;

import com.example.pagination.dto.PageRequestDTO;
import com.example.pagination.model.Student;
import com.example.pagination.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public Page<Student> getStudentUsingPagination(@RequestBody PageRequestDTO pageRequestDTO) {
        Pageable pageable = new PageRequestDTO().getPageable(pageRequestDTO);
        Page<Student> studentPage = studentRepository.findAll(pageable);
        return studentPage;
    }

    @PostMapping("/queryMethod/{city}")
    public Page<Student> getAllStudentUsingPaginationQueryMethod(@RequestBody PageRequestDTO pageRequestDTO, @PathVariable String city) {
        Pageable pageable = new PageRequestDTO().getPageable(pageRequestDTO);
        Page<Student> studentPage = studentRepository.findAllByCity(city, pageable);
        return studentPage;
    }

    @PostMapping("/native/{city}")
    public Page<Student> getAllStudentUsingPaginationNative(@RequestBody PageRequestDTO pageRequestDTO, @PathVariable String city) {
        Pageable pageable = new PageRequestDTO().getPageable(pageRequestDTO);
        Page<Student> studentPage = studentRepository.findAllByCity(city, pageable);
        return studentPage;
    }

    public Page<Student> getAllStudentUsingPaginationList(@RequestBody PageRequestDTO pageRequestDTO) {
        List<Student> studentList = studentRepository.findAll();

        // 1. PageListHolder
        PagedListHolder<Student> pagedListHolder = new PagedListHolder<>(studentList);
        pagedListHolder.setPage(pageRequestDTO.getPageNo());
        pagedListHolder.setPageSize(pageRequestDTO.getPageSize());

        // 2. PropertyComparator
        List<Student> pageSlice = pagedListHolder.getPageList();
        boolean ascending = pageRequestDTO.getSort().isAscending();
        PropertyComparator.sort(pageSlice, new MutableSortDefinition(pageRequestDTO.getSortByColumn(), true, ascending));

        // 3. PageImpl
        Page<Student> students = new PageImpl<>(
                pageSlice, new PageRequestDTO().getPageable(pageRequestDTO), studentList.size());
        return students;
    }
}