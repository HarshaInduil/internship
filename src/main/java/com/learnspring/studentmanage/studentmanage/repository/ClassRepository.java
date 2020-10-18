package com.learnspring.studentmanage.studentmanage.repository;

import com.learnspring.studentmanage.studentmanage.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
}
