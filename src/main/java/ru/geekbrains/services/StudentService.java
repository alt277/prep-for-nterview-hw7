package ru.geekbrains.services;

import org.springframework.stereotype.Service;
;
import ru.geekbrains.entities.Student;
import ru.geekbrains.repositories.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository ;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }
    public List<Student> findByNameAndFamily_name (String first_name,String family_name){
      return  studentRepository.findByNameAndFamily_name(first_name,family_name);}

   public   List<Student> findByName( String firstName){
        return studentRepository.findByName(firstName);
   }

    public Student update(Student student) {
        studentRepository.save(student);
        return studentRepository.getOne(student.getId());
    }

    public void save(Student student) {
        studentRepository.save(student);
    }
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    public Student findMinAge(){
        return studentRepository.findMinAge();
    }
    public Student findMaxAge(){
        return studentRepository.findMaxAge();
    }
    public   List<Student>  findMinMaxAge(){
       return studentRepository.findMinMaxAge();
    }
}
