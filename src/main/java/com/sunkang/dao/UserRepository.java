package com.sunkang.dao;

import com.sunkang.entity.Role;
import com.sunkang.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by changxiang on 2017-03-16.
 * 用户的数据访问类
 */
@Mapper
@Repository
public interface UserRepository {
    /**
     * 通过用户名获取用户
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 根据用户名查询权限
     * @param username
     * @return
     */
    List<Role> findRoleByUsername(String username);

}
