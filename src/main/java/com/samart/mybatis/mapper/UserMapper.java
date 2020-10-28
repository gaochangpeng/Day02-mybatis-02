package com.samart.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    // 根据用户Id删除权限（修改状态码）
    int deleteUser(@Param("userId") int userId);
}
