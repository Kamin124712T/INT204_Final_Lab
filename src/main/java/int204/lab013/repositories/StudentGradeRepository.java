package int204.lab013.repositories;

import int204.lab013.model.StudentGrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentGradeRepository extends JpaRepository<StudentGrade,Integer> {
}
