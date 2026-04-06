package com.example.pojo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Emp {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer gender;
    private String phone;
    private Integer job;
    private Integer salary;
    private String image;
    private LocalDate entryDate;
    private Integer deptId;
    private LocalDate createdTime;
    private LocalDate updatedTime;

    private String deptName;
}
