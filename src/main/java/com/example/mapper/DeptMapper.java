package com.example.mapper;

import com.example.pojo.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from dept order by update_time desc ")
    List<Dept> fingAll();

    @Select("delete from dept where id=#{id}")
    void deleteById(Integer id);

    @Insert("insert into dept(name,update_time,create_time) values(#{name},#{updateTime},#{createTime})")
    void insert(Dept dept);

    @Select("select * from dept where id=#{id}")
    Dept getById(Integer id);

    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id} ")
    void update(Dept dept);
}
