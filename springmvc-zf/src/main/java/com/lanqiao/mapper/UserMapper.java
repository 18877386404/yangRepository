package com.lanqiao.mapper;

import org.springframework.stereotype.Repository;

import com.lanqiao.vo.UserInfo;

@Repository
public interface UserMapper {

	public UserInfo login(UserInfo user);
}
