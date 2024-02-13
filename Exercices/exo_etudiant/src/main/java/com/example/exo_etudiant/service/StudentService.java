package com.example.exo_etudiant.service;

import com.example.exo_etudiant.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    Boolean addStudent(String firstName, String lastName, Integer age, String email);
    Student getStudentById(UUID id);
    List<Student> getStudents();
    List<Student> getStudentsByName(String lastName);

}
