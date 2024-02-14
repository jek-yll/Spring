package com.example.exo_etudiant.controler;

import com.example.exo_etudiant.model.Student;
import com.example.exo_etudiant.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class StudentControler {

    private final StudentService studentService;

    public StudentControler(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/add")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
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

    @GetMapping("/student/{studentId}")
    public String showStudent(@PathVariable("studentId")UUID id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student/studentDetails";
    }

    @GetMapping("/search")
    public String searchStudent(@RequestParam(value = "lastname", required = false)String lastName, Model model){
        model.addAttribute("student", new Student());
        List<Student> students = studentService.searchStudent(lastName);

        if (!students.isEmpty()){
            model.addAttribute("students", students);
            return "student/studentList";
        } else {
            return "redirect:/";
        }
    }
}
