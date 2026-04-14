package com.example.service;

import com.example.pojo.Clazz;
import com.example.pojo.ClazzQueryParam;
import com.example.pojo.PageResult;

import java.util.List;

public interface ClassService {
    PageResult<Clazz> page(ClazzQueryParam param);

    void save(Clazz clazz);

    void update(Clazz clazz);

    void delete(List<Integer> ids);

    Clazz getInfo(Integer id);
}
