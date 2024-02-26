package com.example.exo_etudiant.controler;

import com.example.exo_etudiant.model.Student;
import com.example.exo_etudiant.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    public ResponseEntity<String> createStudent(@Valid @RequestBody Student student, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            StringBuilder errors = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> errors.append(objectError.toString()).append(" // "));
            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        } else {
        studentService.addStudent(student.getFirstName(), student.getLastName(), student.getAge(), student.getEmail());
        return new ResponseEntity<>("Etudiant crée avec l'id :" + student.getId(), HttpStatus.CREATED);
        }
    }
    @PutMapping("/student/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable UUID id, @Valid @RequestBody Student studentUpdated, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            StringBuilder errors = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> errors.append(objectError.toString()).append(" // "));
            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        } else {
            studentService.updateStudent(id, studentUpdated.getFirstName(), studentUpdated.getLastName(), studentUpdated.getAge(), studentUpdated.getEmail());
            return new ResponseEntity<>("Modif de l'etudiant ok", HttpStatus.ACCEPTED);
        }
    }
}
