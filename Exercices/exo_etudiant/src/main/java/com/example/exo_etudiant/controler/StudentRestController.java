package com.example.exo_etudiant.controler;

import com.example.exo_etudiant.model.Student;
import com.example.exo_etudiant.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/academy")
public class StudentRestController {

    private final StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents() {return studentService.getStudents();}

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable UUID id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/student/{id}")
    public Boolean deleteStudent(@PathVariable UUID id){
        return studentService.deleteStudent(id);
    }
    @PostMapping("/add")
    public Student createStudent(@RequestBody Student student){
        studentService.addStudent(student.getFirstName(), student.getLastName(), student.getAge(), student.getEmail());
        return student;
    }
    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable UUID id, @RequestBody Student studentUpdated){
        studentService.updateStudent(id, studentUpdated.getFirstName(), studentUpdated.getLastName(), studentUpdated.getAge(), studentUpdated.getEmail());
        return studentUpdated;
    }
}
