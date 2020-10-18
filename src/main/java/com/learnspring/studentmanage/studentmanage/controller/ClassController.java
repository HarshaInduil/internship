package com.learnspring.studentmanage.studentmanage.controller;

import com.learnspring.studentmanage.studentmanage.model.Class;
import com.learnspring.studentmanage.studentmanage.service.ClassService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/Class/")
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping("/view")
    public String viewClassPage(Model model) {
        model.addAttribute("listClasses", classService.getAllClasses());
        return "Class/viewClasses";
    }

    @PostMapping("/save")
    public String saveClass(@Valid @ModelAttribute("clas") Class clas, BindingResult bindingResult, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            redirAttrs.addFlashAttribute("error", "The error occurred.");
            return "Class/addClass";
        } else {
            this.classService.saveClass(clas);
            redirAttrs.addFlashAttribute("success", "Successful");
            return "redirect:/Class/view";
        }
    }

    @PostMapping("/update/{id}")
    public String updateClass(@PathVariable("id") Long id, Class clas) {
        classService.saveClass(clas);
        return "redirect:/Class/view";
    }

    @GetMapping("/addForm")
    public String viewClassAddForm(Model model) {
        Class clas = new Class();
        model.addAttribute("class", clas);
        return "Class/addClass";
    }

    @GetMapping("/updateForm/{id}")
    public String viewClassUpdateForm(@PathVariable(value = "id") Long id, Model model) {
        Class clas = classService.findClassById(id);
        model.addAttribute("class", clas);
        return "Class/updateClass";
    }
}
