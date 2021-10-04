package com.example.springdatajpadcb.repository;

import com.example.springdatajpadcb.entity.Guardian;
import com.example.springdatajpadcb.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("surinder@gmail.com")
                .firstName("Surinder")
                .lastName("Singh")
                // .guardianName("Nikhil")
                //.guardianEmail("Nikhil@gmail.com")
                //.guardianMobile("43524165431")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .name("Surinder")
                .email("surinder03@gmail.com")
                .mobile("44654456")
                .build();
        Student student = Student.builder()
                .firstName("Rachna")
                .emailId("rachna@gmail.com")
                .lastName("Singh")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList =
                studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstName(){

        List<Student> students = studentRepository.findByFirstName("Rachna");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(students);
    }
    @Test
    public void printStudentByFirstNameContaining(){

        List<Student> students = studentRepository.findByFirstNameContaining("Ra");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){

        List<Student> students = studentRepository.findByGuardianName("surinder");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(students);
    }

    @Test
    public void printStudentBasedOnFirstNameOrLastName(){

        List<Student> students = studentRepository.findByLastNameOrFirstName("Singh","Surinder");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(students);
    }
}