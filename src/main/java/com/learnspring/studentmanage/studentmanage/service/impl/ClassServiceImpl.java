package com.learnspring.studentmanage.studentmanage.service.impl;

import com.learnspring.studentmanage.studentmanage.model.Class;
import com.learnspring.studentmanage.studentmanage.repository.ClassRepository;
import com.learnspring.studentmanage.studentmanage.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;

    @Autowired
    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public List<Class> getAllClasses() {
        return this.classRepository.findAll();
    }

    @Override
    public Class findClassById(Long classId) {
        Optional<Class> clas = classRepository.findById(classId);
        if (clas.isPresent())
            return clas.get();
        throw new RuntimeException("This class is not found");
    }

    @Override
    public void saveClass(Class clas) {
        this.classRepository.save(clas);
    }

    @Override
    public void deleteClass(Long classId) {
        this.classRepository.deleteById(classId);
    }
}
