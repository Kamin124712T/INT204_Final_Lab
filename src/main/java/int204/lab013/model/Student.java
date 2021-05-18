package int204.lab013.model;




import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    private Integer studentId;
    private String name;
    @OneToMany(mappedBy = "student")
    private List<StudentGrade> grades;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentGrade> getGrades() {
        return grades;
    }

    public void setGrades(List<StudentGrade> grades) {
        this.grades = grades;
    }
}
