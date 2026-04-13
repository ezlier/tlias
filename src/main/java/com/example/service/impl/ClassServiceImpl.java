package com.example.service.impl;

import com.example.mapper.ClassMapper;
import com.example.pojo.Clazz;
import com.example.pojo.ClazzQueryParam;
import com.example.pojo.PageResult;
import com.example.service.ClassService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassMapper classMapper;


    @Override
    public PageResult<Clazz> page(ClazzQueryParam param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        List<Clazz> rows = classMapper.list(param);
        Page<Clazz> page = (Page<Clazz>) rows;
        return new PageResult<Clazz>(page.getTotal(), page.getResult());
    }

    @Override
    public void save(Clazz clazz) {
        try {
            clazz.setCreateTime(LocalDateTime.now());
            clazz.setUpdateTime(LocalDateTime.now());
            classMapper.insert(clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        classMapper.update(clazz);
    }

    @Override
    public void delete(List<Integer> ids) {
        classMapper.delete(ids);
    }
}
