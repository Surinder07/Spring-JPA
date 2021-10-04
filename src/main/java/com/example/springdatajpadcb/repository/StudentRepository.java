package com.example.springdatajpadcb.repository;

import com.example.springdatajpadcb.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuardianName(String guardianName);


    public List<Student> findByLastNameOrFirstName(String firstName, String lastName);




}
