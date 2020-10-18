package com.learnspring.studentmanage.studentmanage.service;

import com.learnspring.studentmanage.studentmanage.model.Class;

import java.util.List;

public interface ClassService {
    List<Class> getAllClasses();

    Class findClassById(Long classId);

    void saveClass(Class clas);

    void deleteClass(Long classId);
}
