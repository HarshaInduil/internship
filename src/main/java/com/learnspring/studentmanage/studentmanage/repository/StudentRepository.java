package com.learnspring.studentmanage.studentmanage.repository;

import com.learnspring.studentmanage.studentmanage.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
