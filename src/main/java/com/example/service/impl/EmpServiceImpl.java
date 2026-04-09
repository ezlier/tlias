package com.example.service.impl;

import com.example.mapper.EmpExprmapper;
import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.EmpExpr;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageResult;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper ;

    @Autowired
    private EmpExprmapper empExprmapper;

//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate startDate, LocalDate endDate) {
//        Long total = empMapper.countEmp();
//        List<Emp> rows = empMapper.listEmp((page - 1) * pageSize, pageSize);
//        return new PageResult<Emp>(total, rows);
//
//
//        PageHelper.startPage(page, pageSize);
//        List<Emp> rows = empMapper.listEmp(name, gender, startDate, endDate);
//        Page<Emp> pageInfo = (Page<Emp>) rows;
//        return new PageResult<Emp>(pageInfo.getTotal(), pageInfo.getResult());
//    }

    @Override
    public PageResult<Emp> page(EmpQueryParam param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        List<Emp> rows = empMapper.listEmp(param);
        Page<Emp> pageInfo = (Page<Emp>) rows;
        return new PageResult<Emp>(pageInfo.getTotal(), pageInfo.getResult());
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDate.now());
        emp.setUpdateTime(LocalDate.now());
        empMapper.insertEmp(emp);

        List<EmpExpr> empExprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(empExprList)) {
            empExprList.forEach(empExpr -> empExpr.setEmpId(emp.getId()));
            empExprmapper.insertBatch(empExprList);
        }
    }
}
