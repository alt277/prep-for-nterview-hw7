package ru.geekbrains.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.geekbrains.entities.Course;
import ru.geekbrains.entities.Student;


import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>  {

   @Query("select c from Student c where c.firstName = :firstName  ")
   List<Student> findByName(@Param("firstName") String firstName);

   @Query("select c from Student c where c.firstName = 'Alex'  ")
   List<Student> findByName2();

   @Query("select c from Student c where (c.firstName = :firstName ) or" +
           "(c.familyName = :familyName )")
   List<Student> findByNameAndFamily_name(@Param("firstName") String firstName, @Param("familyName") String familyName ) ;

   @Query("select p from Course p where  p.title=:title or p.title is null")
   List<Course> findByQueryTitle(@Param("title") String title);


   @Query("select s from Student s where s.age= ( select MIN (s.age) from Student s) ")
   Student findMinAge();

   @Query("select s from Student s where s.age= ( select Max (s.age) from Student s) ")
   Student findMaxAge();

   @Query("select s from Student s where s.age = ( select MAX (s.age) from Student s) or s.age = ( select MIN (s.age) from Student s)")
   List<Student> findMinMaxAge();


}

