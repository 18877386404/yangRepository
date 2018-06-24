package com.lanqiao.service;

import com.lanqiao.vo.UserInfo;

public interface IUserService {

	/**
	 * @param user
	 * @return
	 */
	public UserInfo selectForLogin(UserInfo user);
}
