package ru.geekbrains.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.entities.Course;


import ru.geekbrains.repositories.CourseRepository;
import ru.geekbrains.services.CourseService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final static Logger logger = LoggerFactory.getLogger(CourseController.class);


    private CourseRepository courseRepository;
    private CourseService courseService;

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String all(Model model,
                      @RequestParam(value = "title", required = false) String title,

                      @RequestParam("page") Optional<Integer> page,
                      @RequestParam("size") Optional<Integer> size       ) {

        logger.info("Filtering by name: {}", title);
        List<Course> courseList;

        if ((title== null || title.isEmpty())) {
            courseList = courseService.findAll();
        }
        else{
            courseList = courseService.findByTitle(title);

        }
        model.addAttribute("courses", courseList);
        return "courses";
    }




}
