package com.example.controller;


import com.example.pojo.Clazz;
import com.example.pojo.ClazzQueryParam;
import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/classes")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping
    public Result list(ClazzQueryParam param) {
        PageResult<Clazz> clazzList = classService.page(param);
        return Result.success(clazzList);
    }

    @GetMapping("/{id}")
    public Result getId(@PathVariable Integer id) {
        Clazz clazz = classService.getInfo(id);
        return Result.success(clazz);
    }

    @PostMapping
    public Result save(@RequestBody Clazz clazz) {
        classService.save(clazz);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        classService.update(clazz);
        return Result.success();
    }

    @DeleteMapping("{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        classService.delete(ids);
        return Result.success();
    }
}
