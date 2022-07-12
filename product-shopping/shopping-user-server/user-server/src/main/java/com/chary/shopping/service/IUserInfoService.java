package com.chary.shopping.service;

import java.util.List;

import com.chary.shopping.bean.UserInfo;

public interface IUserInfoService {

public UserInfo login(UserInfo userInfo);
	
	public int reg(UserInfo userInfo);
	
	public UserInfo findEmail(String email);
	
	public List<UserInfo> findUserInfo();
	
	public int regByManager(UserInfo userInfo);
	
	public int delUserByUno(int uno);
	
	public int upUserStatusByUno(UserInfo userInfo);
	
	public int upUserEmailByUno(UserInfo userInfo);
}
