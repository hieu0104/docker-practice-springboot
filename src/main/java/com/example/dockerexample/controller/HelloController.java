package com.example.dockerexample.controller;

import com.example.dockerexample.models.Student;
import com.example.dockerexample.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")
/*
create table student(
id int primary key auto_increment,
        name varchar(200),
        birth_Year int
);
*/
public class HelloController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, how are you!";
    }

    @PostMapping("/insertStudent")
    public String insertStudent(@RequestParam String name,
                                @RequestParam Integer birthYear) {
        try {
            Student st = new Student(name, birthYear);


            studentRepository.save(st);
            return "Insert Student successfully";


        } catch (
                Exception e) {
            return "Insert Student failed" + e.toString();

        }

    }
//get all student
    //http://localhost:8085/students/showAll
    @GetMapping("/showAll")
    public Iterable<Student> showAllStudents() {
        return studentRepository.findAll();


    }



}