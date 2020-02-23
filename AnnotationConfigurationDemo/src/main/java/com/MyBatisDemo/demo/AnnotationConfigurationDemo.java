package com.MyBatisDemo.demo;

import com.MyBatisDemo.entity.User;
import com.MyBatisDemo.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class AnnotationConfigurationDemo {
    public static void main(String[] args) throws IOException {
        ResourceLoader loader  = new DefaultResourceLoader();
        Resource resource = loader.getResource("Mybatis/mybatis-config.xml");
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");

        Reader reader = encodedResource.getReader();
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(reader, "dev", new Properties());
        SqlSession session = factory.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUser(1);

        System.out.println(user);

        session.close();
    }
}
