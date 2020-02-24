package com.MyBatisDemo.demo;

import com.MyBatisDemo.entityGenerator.User;
import com.MyBatisDemo.entityGenerator.UserCondition;
import com.MyBatisDemo.mapperGenerator.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Properties;

public class MyBatisGeneratorXMLConfigurationDemo {
    public static void main(String[] args) throws IOException {
        ResourceLoader loader  = new DefaultResourceLoader();
        Resource resource = loader.getResource("Mybatis/mybatis-config.xml");
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");

        Reader reader = encodedResource.getReader();
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(reader, "dev", new Properties());
        SqlSession session = factory.openSession();

        System.out.println("------------------");
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserCondition condition = new UserCondition();
        condition.createCriteria().andIdEqualTo(1);
        List<User> users = mapper.selectByExample(condition);
        System.out.println(users.get(0).toString());

        System.out.println("------------------");
        UserCondition condition2 = new UserCondition();
        condition2.createCriteria().andIdEqualTo(2);
        mapper.deleteByExample(condition2);
        session.commit();

        System.out.println("------------------");
        UserCondition condition3 = new UserCondition();
        condition3.createCriteria().andIdIsNotNull();
        List<User> usersList = mapper.selectByExample(condition3);
        usersList.forEach(System.out::println);

        System.out.println("------------------");
        session.close();
    }
}
