package com.cts.springboot.service;

import com.cts.springboot.model.Student;
import com.cts.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class StudentServiceImpl implements StudentService{


    @Autowired
    private StudentRepository  studentRepository;


    @Async
    public CompletableFuture<Student> createStudent(Student student) {
        Student student1 = studentRepository.save(student);
        return CompletableFuture.completedFuture(student1);
    }

    @Async
    public CompletableFuture<List<Student>> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return CompletableFuture.completedFuture(students);
    }

}
