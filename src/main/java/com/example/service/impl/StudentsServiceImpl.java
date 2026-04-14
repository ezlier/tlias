package com.example.service.impl;

import com.example.mapper.StudentsMapper;
import com.example.pojo.PageResult;
import com.example.pojo.Student;
import com.example.pojo.StudentQueryParam;
import com.example.service.StudentsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    private StudentsMapper studentsMapper;

    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        List<Student> rows = studentsMapper.listStudents(studentQueryParam);
        Page<Student> page = (Page<Student>) rows;
        return new PageResult<Student>(page.getTotal(), page.getResult());
    }

    @Override
    public Student getInfo(Integer id) {
        return studentsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentsMapper.insert(student);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentsMapper.updateByPrimaryKey(student);
    }

    @Override
    public void delete(Integer id) {
        studentsMapper.deleteByPrimaryKey(id);
    }
}
