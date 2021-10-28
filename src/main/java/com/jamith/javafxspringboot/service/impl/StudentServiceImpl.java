package com.jamith.javafxspringboot.service.impl;

import com.jamith.javafxspringboot.entiry.Student;
import com.jamith.javafxspringboot.repository.StudentRepo;
import com.jamith.javafxspringboot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepo studentRepo;

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public List<Student> getAll() {
        return null;
    }

    @Override
    public Student delete(Student student) {
        return null;
    }

    @Override
    public Student update(Student student) {
        return null;
    }
}
