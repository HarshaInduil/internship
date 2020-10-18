package com.learnspring.studentmanage.studentmanage.service.impl;

import com.learnspring.studentmanage.studentmanage.model.Student;
import com.learnspring.studentmanage.studentmanage.repository.StudentRepository;
import com.learnspring.studentmanage.studentmanage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent())
            return student.get();
        throw new RuntimeException("This Student not found for id:" + id);
    }

    @Override
    public void deleteStudentById(Long id) {
        this.studentRepository.deleteById(id);
    }
}
