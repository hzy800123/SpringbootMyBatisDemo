package com.MyBatisDemo.mapper;

import com.MyBatisDemo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Results(value={
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "passWord", column = "pass_word"),
            @Result(property = "age", column = "age"),
            @Result(property = "regTime", column = "reg_time")
    })
    @Select("select id, user_name, pass_word, age, reg_time from user where id = #{id}")
    User selectUser(int id);

//    @Results({
//            @Result(id = true, property = "id", column = "id"),
//            @Result(property = "userName", column = "user_name"),
//            @Result(property = "passWord", column = "pass_word"),
//            @Result(property = "age", column = "age"),
//            @Result(property = "regTime", column = "reg_time")
//    })
    @ResultMap("mybatis.mappers.UserMapper.UserResult")
    @Select("select * from user")
    List<User> retrieveAllUser();

    @Delete("delete from user where id = #{id}")
    void deleteUser(int id);
}
