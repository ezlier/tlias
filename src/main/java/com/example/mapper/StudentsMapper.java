package com.example.mapper;

import com.example.pojo.Student;
import com.example.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentsMapper {
    List<Student> listStudents(StudentQueryParam studentQueryParam);

    @Select("select s.*, c.name as className " +
            "from student  s " +
            "left join clazz c on s.clazz_id = c.id " +
            "where s.id = #{id}")
    Student selectByPrimaryKey(Integer id);

    @Insert("insert into student (name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, violation_count, violation_score, create_time, update_time) " +
            "values (#{name}, #{no}, #{gender}, #{phone}, #{idCard}, #{isCollege}, #{address}, #{degree}, #{graduationDate}, #{clazzId}, #{violationCount}, #{violationScore}, #{createTime}, #{updateTime})")
    void insert(Student student);

    void updateByPrimaryKey(Student student);

    @Delete("delete from student where id = #{id}")
    void deleteByPrimaryKey(Integer id);
}
