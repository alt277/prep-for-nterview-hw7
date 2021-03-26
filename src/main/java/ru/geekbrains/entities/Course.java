package ru.geekbrains.entities;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Course")  //@Table javax.persistence не HIBERNATE
//@NamedQueries( {
//        @NamedQuery(name = "Product.findMaxPrice",query ="SELECT max(p.price) from Course p") ,
//@NamedQuery(name = "Product.findPoductByMaxPrice",query ="select p from Course p where p.price= ( select MAX (p.price) from Course p)" )
//        })
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @ManyToMany
    @JoinTable(
            name = "ties",
            joinColumns=@JoinColumn(name = "courseId"),
            inverseJoinColumns = @JoinColumn(name = "studentId")
    )

    private List<Student> students;

    public Course(){}

    public Course(Integer id, String title, List<Student> students) {
        this.id = id;
        this.title = title;
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", students=" + students +
                '}'+   '\n';
    }
}
