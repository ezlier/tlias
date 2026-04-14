package com.example.service;

import com.example.pojo.PageResult;
import com.example.pojo.Student;
import com.example.pojo.StudentQueryParam;

public interface StudentsService {
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    Student getInfo(Integer id);

    void save(Student student);

    void update(Student student);

    void delete(Integer id);
}
