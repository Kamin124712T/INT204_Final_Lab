package int204.lab013.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class StudentGrade {
    @Id
    private Integer gradeId;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    private Double grade;

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
