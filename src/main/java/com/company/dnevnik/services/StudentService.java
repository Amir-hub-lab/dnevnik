package com.company.dnevnik.services;

import com.company.dnevnik.entities.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    void updateStudent(Long id, Student student);

    void saveStudent(Student student);

    void deleteStudentById(Long id);
}
