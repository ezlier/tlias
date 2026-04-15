package com.example.mapper;

import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {
//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
//    public Long countEmp();
//
//    @Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc limit #{start}, #{size}")
//    public List<Emp> listEmp(Integer start, Integer size);

    //@Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc")
//    public List<Emp> listEmp(String name, Integer gender, LocalDate startDate, LocalDate endDate);
    public List<Emp> listEmp(EmpQueryParam  param);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, password, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) values" +
            "(#{username}, #{password}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insertEmp(Emp emp);

    void delete(List<Integer> ids);

    Emp getInfo(Integer id);

    void updateById(Emp emp);

    List<Map<String, Object>> countEmpJobData();

    List<Map<String, Object>> countEmpGenderData();

    @Select("select id, username, name from emp where username = #{username} and password = #{password}")
    Emp selectByUsernameAndPassword(Emp emp);
}
