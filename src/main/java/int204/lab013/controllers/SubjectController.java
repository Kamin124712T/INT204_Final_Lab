package int204.lab013.controllers;

import int204.lab013.model.Subject;
import int204.lab013.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/62130500013/api/subject")
public class SubjectController {
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("")
    public List<Subject> getSubjects_013(){
        return subjectRepository.findAll();
    }
}
