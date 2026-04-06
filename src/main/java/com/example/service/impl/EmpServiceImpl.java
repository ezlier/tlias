package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.PageResult;
import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper ;

    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        Long total = empMapper.countEmp();
        List<Emp> rows = empMapper.listEmp((page - 1) * pageSize, pageSize);
        return new PageResult<Emp>(total, rows);
    }
}
