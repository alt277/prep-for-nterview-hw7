package ru.geekbrains.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.entities.Student;

import ru.geekbrains.repositories.CourseRepository;
import ru.geekbrains.repositories.StudentRepository;
import ru.geekbrains.services.StudentService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;

    private CourseRepository courseRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public String all(Model model,
                              @RequestParam(value = "firstName", required = false) String firstName,
                              @RequestParam(value = "familyName", required = false) String familyName,
                              @RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size       ) {

            logger.info("Filtering by name: {}", firstName);
        List< Student> studentList;

        if ((firstName == null || firstName.isEmpty()) && (familyName == null || familyName.isEmpty())) {
           studentList = studentService.findAll();
        }
        else{
            studentList = studentService.findByNameAndFamily_name(firstName,familyName);

        }
        model.addAttribute("students", studentList);
        return "students";
    }
    @GetMapping("/new_student")
    public String addStudent( Model model ) {
      Student student= new Student();
        model.addAttribute("student",student);
        return "new_student";
    }
    @GetMapping("/{id}")
    public String editStudent(@PathVariable("id") Integer id, Model model) throws Exception {
        Student student = studentRepository.findById(id).orElseThrow(Exception::new);
        model.addAttribute("student", student);
        return "edit_student";
    }
    @PostMapping("/new")
    public String addStudent(Model model,  Student student, BindingResult bindingResult) {
        studentService.save(student);

       return "redirect:/students";
    }
    @PostMapping("/update")
    public String updateStudent(Model model,  Student student, BindingResult bindingResult) {
        studentService.save(student);

        return "redirect:/students";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteStudent(@PathVariable("id") Integer id,Model model) {
        studentService.deleteById(id);

        return "redirect:/students";
    }

    @GetMapping("/max")
    public String maxPrice(Model model) {
        Student max =new Student();
        max = studentService.findMaxAge();
        model.addAttribute("students", max);
        return "ages";
    }
    @GetMapping("/min")
    public String minPrice(Model model) {
        Student min =new Student();
//        min = productRepo.findMinPrice();
        min = studentService.findMinAge();
        model.addAttribute("students", min);
        return "ages";
    }
    @GetMapping("/min-max")
    public String minmaxPrice(Model model) {
        List<Student> studentList;
       studentList= studentService.findMinMaxAge();
        model.addAttribute("students", studentList);
        return "ages";
    }


    }


