package com.samart.mybatis;

import com.samart.mybatis.service.Impl.UserServiceImpl;
import com.samart.mybatis.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestMain2 {
    public static void main(String[] args) {
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(
                TestMain2.class.getClassLoader().getResourceAsStream("mybatis-config.xml")
        );
        SqlSession sqlSession = ssf.openSession(true);

        UserService userService = new UserServiceImpl(sqlSession);
        int i = userService.removeUser(3);

    }
}
