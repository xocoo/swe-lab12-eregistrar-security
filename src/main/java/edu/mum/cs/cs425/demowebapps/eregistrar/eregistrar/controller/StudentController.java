package edu.mum.cs.cs425.demowebapps.eregistrar.eregistrar.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.demowebapps.eregistrar.eregistrar.model.Student;
import edu.mum.cs.cs425.demowebapps.eregistrar.eregistrar.service.StudentService;

@Controller
@RequestMapping(value = { "/eregistrar/student" })
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = { "/list" })
    public ModelAndView listStudents() {
        var students = studentService.getAllStudents();

        var modelAndView = new ModelAndView();
        modelAndView.addObject("students", students);
        modelAndView.setViewName("secured/student/list");
        return modelAndView;
    }

    @GetMapping(value = { "/new" })
    public String displayNewStudentForm(Model model) {
        var newStudent = new Student();
        model.addAttribute("student", newStudent);
        return "secured/student/new";
    }

    @PostMapping(value = { "/new" })
    public String addNewStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,
            Model model) {
        System.out.println(student);
        if (bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/student/new";
        }
        studentService.addNewStudent(student);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = { "edit/{studentId}" })
    public String displayEditStudentForm(@PathVariable Long studentId, Model model) {
        var student = studentService.getStudentById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "secured/student/edit";
        }
        return "redirect:/eregistrar/student/list";
    }

    @PostMapping(value = { "/update" })
    public String updateStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("erros", bindingResult.getAllErrors());
            return "secured/student/edit";
        }
        studentService.updatetStudent(student);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = "/delete/{studentId}")
    public String deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = "/search")
    public ModelAndView findStudent(Model model, @Param("keyword") String keyword) {
        System.out.println(keyword);
        List<Student> students = studentService.getByKeyword(keyword);
        students.forEach(System.out::println);

        var modelAndView = new ModelAndView();
        modelAndView.addObject("students", students);
        modelAndView.setViewName("secured/student/list");
        return modelAndView;
    }
}
