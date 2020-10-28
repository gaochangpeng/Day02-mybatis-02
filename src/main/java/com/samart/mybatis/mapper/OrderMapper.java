package com.samart.mybatis.mapper;

import com.samart.mybatis.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    // 根据商品订单ID查询商品（一对一）
    Order selectOrderByNo(@Param("orderNo") int no);

    // 根据用户id对应多个商品（一对多）
    List<Order> selectOrderByUserId(@Param("userId") int userId);
}
