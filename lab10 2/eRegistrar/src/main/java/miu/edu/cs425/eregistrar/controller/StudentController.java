package miu.edu.cs425.eregistrar.controller;


import jakarta.validation.Valid;
import miu.edu.cs425.eregistrar.model.Student;
import miu.edu.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = {"/","home"})
public class StudentController {

    @Autowired
    public StudentService studentService;

    @GetMapping(value = {"/","home"})
    public String homePage(){
        return "public/home/index";
    }

    @GetMapping(value = {"/home/student"})
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("student",students);
        return "public/secured/student/list";
    }
    @PostMapping(value = { "/student/new" })
    public String addNewStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,
                                Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/new";
        }
        student = studentService.save(student);
        return "redirect:/student/list";
    }

    @GetMapping(value = { "/student/edit/{studentId}" })
    public String editStudent(@PathVariable Long studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "student/edit";
        }
        return "student/list";
    }
    @PostMapping(value = { "/student/edit" })
    public String updateStudent(@ModelAttribute("student") Student student, BindingResult bindingResult,
                                Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/edit";
        }
        student = studentService.save(student);
        return "redirect:/student/list";
    }
    @GetMapping(value = { "/student/delete/{studentId}" })
    public String deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
        return "redirect:/student/list";
    }

    @GetMapping(value = "/student/search")
    public ModelAndView searchStudent(@RequestParam Student student) {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.searchStudents(student);
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", student);
        modelAndView.setViewName("student/list");
        return modelAndView;
    }

}


