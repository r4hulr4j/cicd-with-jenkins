package com.cts.springboot.controller;

import com.cts.springboot.model.Student;
import com.cts.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/student")
public class StudentApi {

    @Autowired
    private StudentService service;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CompletableFuture<Student> saveStudent(@RequestBody Student student){
        return service.createStudent(student);

    }


    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public CompletableFuture<List<Student>> getAllStudents(){
        return service.getAllStudents();

    }


}
