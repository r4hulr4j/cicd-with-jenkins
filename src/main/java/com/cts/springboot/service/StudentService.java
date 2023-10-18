package com.cts.springboot.service;

import com.cts.springboot.model.Student;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface StudentService {

    // create basic crud operation for Student
    // create, read, update, delete

    // create
    public CompletableFuture<Student> createStudent(Student student);

   // fetch all Student
    public CompletableFuture<List<Student>> getAllStudents();




}
