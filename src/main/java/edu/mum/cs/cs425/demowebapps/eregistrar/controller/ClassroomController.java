package edu.mum.cs.cs425.demowebapps.eregistrar.controller;

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

import edu.mum.cs.cs425.demowebapps.eregistrar.model.Student;
import edu.mum.cs.cs425.demowebapps.eregistrar.service.ClassroomService;
import edu.mum.cs.cs425.demowebapps.eregistrar.service.StudentService;

@Controller
@RequestMapping(value = { "/eregistrar/classroom" })
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @GetMapping(value = { "/list" })
    public ModelAndView listClassrooms() {
        var classroom = classroomService.getAllClassroom();

        var modelAndView = new ModelAndView();
        modelAndView.addObject("classroom", classroom);
        modelAndView.setViewName("secured/classroom");
        return modelAndView;
    }
}
