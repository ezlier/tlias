package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.LoginInfo;
import com.example.pojo.Result;
import com.example.service.EmpService;
import com.example.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;


    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        LoginInfo Info = empService.login(emp);
        if (Info != null) {
            return Result.success(Info);
        }
        return Result.error("登录失败");
    }
}
