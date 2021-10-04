package com.example.springdatajpadcb.repository;

import com.example.springdatajpadcb.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("surinder@gmail.com")
                .firstName("Surinder")
                .lastName("Singh")
                .guardianName("Nikhil")
                .guardianEmail("Nikhil@gmail.com")
                .guardianMobile("43524165431")
                .build();
        studentRepository.save(student);
    }
}