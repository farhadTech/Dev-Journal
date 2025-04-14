package com.example.MappedSuperclass.controller;

import com.example.MappedSuperclass.model.Staff;
import com.example.MappedSuperclass.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private final StaffService staffService;

    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaffs();
    }

    @GetMapping("/{id}")
    public Optional<Staff> getStaffById(@PathVariable Long id) {
        return staffService.getStaffById(id);
    }

    @PostMapping
    public Staff saveStaff(@RequestBody Staff staff) {
        return staffService.saveStaff(staff);
    }

    @DeleteMapping("/{id}")
    public void deleteStaffById(@PathVariable Long id) {
        staffService.deleteStaffById(id);
    }
}
