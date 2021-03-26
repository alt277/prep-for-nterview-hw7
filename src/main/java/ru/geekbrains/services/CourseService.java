package ru.geekbrains.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.entities.Course;
import ru.geekbrains.entities.Student;
import ru.geekbrains.repositories.CourseRepository;
import ru.geekbrains.repositories.StudentRepository;

import java.util.List;
@Service
public class CourseService {
    private CourseRepository courseRepository ;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAll(){
        return courseRepository.findAll();
    }


    public   List<Course> findByTitle( String title){
        return courseRepository.findByTitleLike(title);
    }

    public Course update(Course course) {
        courseRepository.save(course);
        return courseRepository.getOne(course.getId());
    }

    public void save(Course course) {
        courseRepository.save(course);
    }
    public void deleteById(Integer id) {
        courseRepository.deleteById(id);
    }
}
