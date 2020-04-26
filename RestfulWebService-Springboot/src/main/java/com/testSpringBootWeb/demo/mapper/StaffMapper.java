package com.testSpringBootWeb.demo.mapper;

import com.testSpringBootWeb.demo.domain.Staff;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StaffMapper {
    // @Result 修饰返回的结果集，关联实体类属性和数据库字段一一对应，
    // 如果实体类属性和数据库属性名保持一致，就不需要这个属性来修饰。
    @Select("select * from staff")
    @Results
//    @Results({
//            @Result(property = "name", column = "name")
//    })
    List<Staff> getAll();

    @Select("select * from staff where id=#{id}")
    Staff getById(Long id);

    @Select("select max(id) from staff")
    int getMaxId();

    @Insert({"insert into staff(id, name, age, salary) values(#{id}, #{name}, #{age}, #{salary})"})
    int insert(Staff staff);

    @Update({"update staff set name=#{name} where id=#{id}"})
    void update(Staff staff);

    @Delete("delete from staff where id=#{id}")
    void delete(Long id);
}
