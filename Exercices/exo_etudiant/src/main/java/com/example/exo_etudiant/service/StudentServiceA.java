package com.example.exo_etudiant.service;

import com.example.exo_etudiant.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentServiceA implements StudentService{

    private final Map<UUID, Student> students;

    public StudentServiceA() {
        this.students = new HashMap<>();

        Student studentA = Student.builder()
                .id(UUID.randomUUID())
                .firstName("John")
                .lastName("Doe")
                .age(25)
                .email("j.doe@mail.test")
                .build();
        Student studentB = Student.builder()
                .id(UUID.randomUUID())
                .firstName("Jane")
                .lastName("Smith")
                .age(22)
                .email("j.smith@mail.test")
                .build();

        students.put(studentA.getId(), studentA);
        students.put(studentB.getId(), studentB);
    }

    @Override
    public Boolean addStudent(String firstName, String lastName, Integer age, String email) {
        if (firstName != null && lastName != null && age != null && email != null){
            Student student = Student.builder()
                    .id(UUID.randomUUID())
                    .firstName(firstName)
                    .lastName(lastName)
                    .age(age)
                    .email(email)
                    .build();
            students.put(student.getId(), student);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Student getStudentById(UUID id) {
        return students.get(id);
    }

    @Override
    public List<Student> getStudents() {
        return students.values().stream().toList();
    }

    @Override
    public List<Student> getStudentsByName(String lastName) {
        return students.values().stream()
                .filter(s -> s.getLastName().equals(lastName))
                .toList();
    }

    @Override
    public List<Student> searchStudent(String name) {
        return students.values().stream()
                .filter(s -> s.getLastName().toLowerCase().startsWith(name.toLowerCase()) || s.getFirstName().toLowerCase().startsWith(name.toLowerCase()))
                .toList();
//        return students.values().stream()
//                .filter(s -> s.getLastName().toLowerCase().contains(name.toLowerCase()) || s.getFirstName().toLowerCase().contains(name.toLowerCase()))
//                .toList();
    }

    @Override
    public Boolean deleteStudent(UUID id) {
        if (getStudentById(id) != null){
        students.remove(id);
        return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean updateStudent(UUID id, String firstName, String lastName, Integer age, String email) {
        if(getStudentById(id) != null){
            Student studentUpdate = Student.builder()
                    .id(id)
                    .firstName(firstName)
                    .lastName(lastName)
                    .email(email)
                    .age(age)
                    .build();
            students.replace(id, getStudentById(id), studentUpdate);
            return true;
        } else {
            return false;
        }
    }
}
