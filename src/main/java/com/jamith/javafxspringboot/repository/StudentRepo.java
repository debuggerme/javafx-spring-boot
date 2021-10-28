package com.jamith.javafxspringboot.repository;

import com.jamith.javafxspringboot.entiry.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {
}
