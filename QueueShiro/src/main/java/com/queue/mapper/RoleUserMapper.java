package com.queue.mapper;

import com.queue.entity.RoleUser;

import java.util.List;

public interface RoleUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_user
     *
     * @mbg.generated
     */
    int insert(RoleUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_user
     *
     * @mbg.generated
     */
    int insertSelective(RoleUser record);

    List<RoleUser> searchUserByPage();

    RoleUser getUserByEntity(RoleUser user);
}