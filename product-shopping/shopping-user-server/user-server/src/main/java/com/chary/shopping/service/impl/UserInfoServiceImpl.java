package com.chary.shopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chary.shopping.bean.UserInfo;
import com.chary.shopping.mapper.UserInfoMapper;
import com.chary.shopping.service.IUserInfoService;
import com.chary.shopping.util.StringUtil;

@Service
public class UserInfoServiceImpl implements IUserInfoService{

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Override
	public UserInfo login(UserInfo userInfo) {
		if(StringUtil.checkNull(userInfo.getEmail(),userInfo.getPwd())) {
			return null;
		}
		return userInfoMapper.login(userInfo);
	}

	@Override
	public int reg(UserInfo userInfo) {
		if(StringUtil.checkNull(userInfo.getEmail(),userInfo.getPwd())) {
			return 0;
		}
		return userInfoMapper.reg(userInfo);
	}

	@Override
	public UserInfo findEmail(String email) {
		return userInfoMapper.findEmail(email);
	}

	@Override
	public List<UserInfo> findUserInfo() {
		return userInfoMapper.findUserInfo();
	}

	@Override
	public int regByManager(UserInfo userInfo) {
		return userInfoMapper.regByManager(userInfo);
	}

	@Override
	public int delUserByUno(int uno) {
		return userInfoMapper.delUserByUno(uno);
	}

	@Override
	public int upUserStatusByUno(UserInfo userInfo) {
		return userInfoMapper.upUserStatusByUno(userInfo);
	}

	@Override
	public int upUserEmailByUno(UserInfo userInfo) {
		return userInfoMapper.upUserEmailByUno(userInfo);
	}

}
