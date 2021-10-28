package com.jamith.javafxspringboot.service;

import com.jamith.javafxspringboot.entiry.Student;

import java.util.List;

public interface StudentService {

    Student save(Student student);

    List<Student> getAll();

    Student delete(Student student);

    Student update(Student student);
}
