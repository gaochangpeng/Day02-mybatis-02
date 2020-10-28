package com.samart.mybatis.service.Impl;

import com.samart.mybatis.entity.Privilege;
import com.samart.mybatis.entity.Roles;
import com.samart.mybatis.mapper.RolesMapper;
import com.samart.mybatis.mapper.UserMapper;
import com.samart.mybatis.service.UserService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class UserServiceImpl implements UserService {
    UserMapper userMapper;
    RolesMapper rolesMapper;

    public UserServiceImpl(SqlSession sqlSession) {
        userMapper = sqlSession.getMapper(UserMapper.class);
        rolesMapper = sqlSession.getMapper(RolesMapper.class);
    }

    @Override
    public int removeUser(int uid) {
        // 通过用户的 ID 查询当前用户的权限（查询用户和权限）
        Roles roles = rolesMapper.selectByUserId(2);
        // 判断是否有权限
        if(hasPrivileges(roles.getPrivileges())){
            // 删除指定的用户
            int i = userMapper.deleteUser(uid);
        }else {
            System.out.println("暂无权限！");
        }
        return 0;
    }

    private boolean hasPrivileges(List<Privilege> privileges) {
        return false;
    }

//    private boolean hasPrivileges(List<Privilege> privileges) {
//        AtomicBoolean flag = new AtomicBoolean(false);
//        privileges.forEach(item -> {
//            if(item.getName().equals("del")){
//                flag.set(true);
//            }
//        });
//        return flag.get();
//    }
}
