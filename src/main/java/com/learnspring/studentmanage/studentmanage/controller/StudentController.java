package com.learnspring.studentmanage.studentmanage.controller;

import com.learnspring.studentmanage.studentmanage.model.Class;
import com.learnspring.studentmanage.studentmanage.model.Student;
import com.learnspring.studentmanage.studentmanage.service.ClassService;
import com.learnspring.studentmanage.studentmanage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/Student/")
public class StudentController {

    private final StudentService studentService;
    private final ClassService classService;

    @Autowired
    public StudentController(StudentService studentService, ClassService classService) {
        this.studentService = studentService;
        this.classService = classService;
    }

    @GetMapping("/view")
    public String viewStudentManagementHomePage(Model model) {
        model.addAttribute("listStudent", studentService.getAllStudents());
        return "Student/viewStudent";
    }

    @PostMapping("/save")
    public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "Student/addStudent";
        } else {
            studentService.saveStudent(student);
            return "redirect:/Student/view";
        }
    }

    @GetMapping("/save")
    public String viewStudentAddForm(Model model, Model modelOne) {
        Student student = new Student();
        List<Class> classList = classService.getAllClasses();
        model.addAttribute("student", student);
        modelOne.addAttribute("listOfClasses", classList);
        return "Student/addStudent";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") Long id, Student student) {
        student.setId(id);
        studentService.saveStudent(student);
        return "redirect:/Student/view";
    }

    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        this.studentService.deleteStudentById(id);
        return "redirect:/Student/view";
    }

    @GetMapping("/updateForm/{id}")
    public String viewStudentUpdateForm(@PathVariable(value = "id") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        List<Class> classList = classService.getAllClasses();
        model.addAttribute("student", student);
        model.addAttribute("listOfClasses", classList);
        return "Student/updateStudent";
    }


}
