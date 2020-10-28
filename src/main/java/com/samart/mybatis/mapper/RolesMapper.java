package com.samart.mybatis.mapper;

import com.samart.mybatis.entity.Roles;
import org.apache.ibatis.annotations.Param;

// 角色
public interface RolesMapper {
    // 根据角色对象 id 查询角色
    Roles selectById( @Param("roleId") int roleId);

    // 根据用户 id 查询角色
    Roles selectByUserId(@Param("userId") int userId);

}
