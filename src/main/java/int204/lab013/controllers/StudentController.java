package int204.lab013.controllers;

import int204.lab013.model.Student;
import int204.lab013.model.StudentGrade;
import int204.lab013.repositories.StudentGradeRepository;
import int204.lab013.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/62130500013/api")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentGradeRepository studentGradeRepository;

    @GetMapping("/student")
    public Page<Student> getStudents_013(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "studentId") String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy) );
        Page<Student> pageResult = studentRepository.findAll(pageable);
        return pageResult;
    }

    @PostMapping("/student")
    public Student addStudent_013(@RequestBody Student student) throws Exception {
        if(studentRepository.findById(student.getStudentId()).orElse(null)!=null){
            throw new Exception("StudentId_ALREADY_EXIST");
        }
        return studentRepository.save(student);
    }

    @DeleteMapping("/student/{studentId}")
    public void deleteStudent_013(@PathVariable Integer studentId) throws Exception {
        Student student = studentRepository.findById(studentId).orElse(null);
        if(student == null){
            throw new Exception("StudentId_DOES_NOT_EXIST");
        }
        studentRepository.delete(student);
    }

    @GetMapping("/grade/{studentId}/{subjectCode}")
    public Student getStudentGrade_013(@PathVariable Integer studentId,@PathVariable String subjectCode) throws Exception {
        Student student = studentRepository.findById(studentId).orElse(null);
        if(student == null){
            throw new Exception("StudentId_DOES_NOT_EXIST");
        }
        List<StudentGrade> gradeSet = student.getGrades();
        for (int i = 0;i<gradeSet.size();i++) {
            if(gradeSet.get(i).getSubject().getSubjectCode().toLowerCase().equals(subjectCode.toLowerCase())){
                Student st = new Student();
                st.setStudentId(student.getStudentId());
                st.setName(student.getName());
                List<StudentGrade> gradeList = new LinkedList<StudentGrade>();
                gradeList.add(gradeSet.get(i));
                st.setGrades(gradeList);
                return st;
            }
        }
        throw new Exception("SubjectCode_DOES_NOT_EXIST");
    }

    @DeleteMapping("/grade/{studentId}/{subjectCode}")
    public void deleteStudentGrade_013(@PathVariable Integer studentId,@PathVariable String subjectCode) throws Exception {
        Student student = studentRepository.findById(studentId).orElse(null);
        if(student == null){
            throw new Exception("StudentId_DOES_NOT_EXIST");
        }
        List<StudentGrade> gradeSet = student.getGrades();
        for (int i = 0;i<gradeSet.size();i++) {
            if(gradeSet.get(i).getSubject().getSubjectCode().toLowerCase().equals(subjectCode.toLowerCase())){
                studentGradeRepository.deleteById(gradeSet.get(i).getGradeId());
                return;
            }
        }
        throw new Exception("SubjectCode_DOES_NOT_EXIST");
    }

    @PostMapping("/grade/{studentId}")
    public StudentGrade addtSudentGrade_013(@RequestBody StudentGrade studentGrade,@PathVariable Integer studentId) throws Exception {
        Student student = studentRepository.findById(studentId).orElse(null);
        if(student == null){
            throw new Exception("StudentId_DOES_NOT_EXIST");
        }
        List<StudentGrade> gradeSet = student.getGrades();
        for (int i = 0;i<gradeSet.size();i++) {
            if(gradeSet.get(i).getSubject().getSubjectId() == studentGrade.getSubject().getSubjectId()){
                throw new Exception("SudentGrade_ALREADY_EXIST");
            }
        }
        studentGrade.setStudent(student);
        studentGradeRepository.save(studentGrade);
        return studentGrade;
    }
}
