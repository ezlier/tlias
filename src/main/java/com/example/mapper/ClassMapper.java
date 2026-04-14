package com.example.mapper;


import com.example.pojo.Clazz;
import com.example.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassMapper {

    List<Clazz> list(ClazzQueryParam param);

    @Insert("insert into clazz(name, room, begin_date, end_date, master_id, subject, create_time, update_time) values(#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId}, #{subject}, #{createTime}, #{updateTime})")
    void insert(Clazz clazz);

    void update(Clazz clazz);

    void delete(List<Integer> ids);

    @Select("SELECT c.*, e.name AS masterName " +
            "FROM clazz c " +
            "LEFT JOIN emp e ON c.master_id = e.id " +
            "WHERE c.id = #{id}")
    Clazz getInfo(Integer id);
}

