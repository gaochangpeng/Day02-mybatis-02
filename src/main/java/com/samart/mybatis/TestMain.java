package com.samart.mybatis;

import com.samart.mybatis.entity.Order;
import com.samart.mybatis.entity.Roles;
import com.samart.mybatis.mapper.OrderMapper;
import com.samart.mybatis.mapper.RolesMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class TestMain {
    public static void main(String[] args) {

        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(
                TestMain.class.getClassLoader().getResourceAsStream("mybatis-config.xml")
        );
        SqlSession sqlSession = ssf.openSession(true);

        // 一对一 查询
        /*OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Order order = mapper.selectOrderByNo(123);
        System.out.println(order);*/

        // 一对多 查询
        /*OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orders = mapper.selectOrderByUserId(2);
        System.out.println(orders);*/

        RolesMapper mapper = sqlSession.getMapper(RolesMapper.class);
        Roles roles = mapper.selectByUserId(2);
        System.out.println(roles);
    }
}
