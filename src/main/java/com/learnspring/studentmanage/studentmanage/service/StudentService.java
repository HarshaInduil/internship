package com.learnspring.studentmanage.studentmanage.service;

import com.learnspring.studentmanage.studentmanage.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    void saveStudent(Student student);

    Student getStudentById(Long id);

    void deleteStudentById(Long id);
}
