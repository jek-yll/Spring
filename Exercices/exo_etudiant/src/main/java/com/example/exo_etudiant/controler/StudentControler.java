package com.example.exo_etudiant.controler;

import com.example.exo_etudiant.model.Student;
import com.example.exo_etudiant.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class StudentControler {

    private final StudentService studentService;
    @Value("${academy.name}")
    private String academyName;
    @Value("${academy.contact}")
    private String academyContact;

    public StudentControler(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("name", academyName);
        model.addAttribute("contact", academyContact);
        return "home";
    }

    @GetMapping("/add")
    public String addStudent(@RequestParam(value = "id", required = false)UUID id, Model model){
        if (id == null){
        model.addAttribute("student", new Student());
        } else {
            model.addAttribute("student", studentService.getStudentById(id));
        }
        return "student/add";
    }

    @PostMapping("/add")
    public String registerStudent(@ModelAttribute("student")Student student){
        if (studentService.addStudent(student.getFirstName(), student.getLastName(), student.getAge(), student.getEmail())){
        return "redirect:/students";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/students")
    public String showStudents(Model model){
        List<Student> students = studentService.getStudents();
        model.addAttribute("students", students);
        return "student/studentList";
    }

    @GetMapping("/search")
    public String searchStudent(@RequestParam(value = "search", required = false)String lastName, Model model){
        model.addAttribute("student", new Student());
        List<Student> students = studentService.searchStudent(lastName);

        if (!students.isEmpty()){
            model.addAttribute("students", students);
            return "student/studentList";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/student/{studentId}")
    public String showStudent(@PathVariable("studentId")UUID id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student/studentDetails";
    }

    @GetMapping("/student/delete/{id}")
    private String deleteStudent(@PathVariable UUID id){
        studentService.deleteStudent(id);
        return "student/studentList";
    }
}
