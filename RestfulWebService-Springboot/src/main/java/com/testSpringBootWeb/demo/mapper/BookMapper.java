package com.testSpringBootWeb.demo.mapper;

import com.testSpringBootWeb.demo.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {
    // @Result 修饰返回的结果集，关联实体类属性和数据库字段一一对应，
    // 如果实体类属性和数据库属性名保持一致，就不需要这个属性来修饰。
    @Select("select * from books")
    @Results
    List<Book> getAllBook();

    @Select("select * from books where id=#{id}")
    Book getById(int id);

    @Select("select max(id) from books")
    int getMaxId();

    @Insert({"insert into books(title, rating) values(#{title}, #{rating})"})
    int insert(String title, double rating);

    @Update({"update books set title=#{title}, rating=#{rating} where id=#{id}"})
    int update(int id, String title, double rating);

    @Delete("delete from books where id=#{id}")
    int delete(int id);
}
