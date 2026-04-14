package com.example.controller;

import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.pojo.Student;
import com.example.pojo.StudentQueryParam;
import com.example.service.StudentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping
    public Result list(StudentQueryParam studentQueryParam){
        PageResult<Student> pageResult = studentsService.page(studentQueryParam);
        return Result.success(pageResult);
    }

    @GetMapping("/{id}")
    public Result find(@PathVariable Integer id){
        Student student = studentsService.getInfo(id);
        return Result.success(student);
    }

    @PostMapping
    public Result save(@RequestBody Student student){
        studentsService.save(student);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Student student){
        studentsService.update(student);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        studentsService.delete(id);
        return Result.success();
    }
}
