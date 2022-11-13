package com.cybersoft.StudentController.controller;

import com.cybersoft.StudentController.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("")
public class StudentController {

    private List<Student> studentList = new ArrayList<>();

    // RequestParam method
    @GetMapping("/request-param")
    public List<Student> addStudent1 (
            @RequestParam(value = "name") String name,
            @RequestParam(value = "age") int age) {
       ;studentList.add(new Student(name,age));
        return studentList;
    }

    // PathVariable method
    @GetMapping("/path-variable/{name}/{age}")
    public List<Student> addStudent2(
            @PathVariable("name") String name,
            @PathVariable("age") int age) {
        studentList.add(new Student(name, age));
        return studentList;
    }

    // RequestBody method
    @PostMapping("/request-body")
    public  List<Student> addStudent3(@RequestBody Student student){
        Student addedStudent = new Student(student.getName(), student.getAge());
        studentList.add(addedStudent);
        return studentList;
    }
}
