package com.springbootWebDemo.dao;

import com.springbootWebDemo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    public List<User> findUserByUsername(String user_name);

    public List<User> listUser();

    public int insertUser(User user);

    public int delete(int id);

    public int update(User user);
}
