package com.chary.shopping.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chary.shopping.bean.LoveInfo;
import com.chary.shopping.mapper.IProductInfoMapper;
import com.chary.shopping.service.IProductInfoService;

@Service
public class ProductInfoServiceImpl implements IProductInfoService{

	@Autowired
	IProductInfoMapper productInfoMapper;
	
	@Override
	public List<Map<String, Object>> findCartInfo(int uno) {
		return productInfoMapper.findCartInfo(uno);
	}

	@Override
	public List<LoveInfo> findLoveByUno(int uno) {
		return productInfoMapper.findLoveByUno(uno);
	}

}
