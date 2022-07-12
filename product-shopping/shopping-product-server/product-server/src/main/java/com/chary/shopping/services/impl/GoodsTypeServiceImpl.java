package com.chary.shopping.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chary.shopping.bean.GoodsType;
import com.chary.shopping.mapper.IGoodsTypeMapper;
import com.chary.shopping.services.IGoodsTypeService;

@Service
public class GoodsTypeServiceImpl implements IGoodsTypeService{

	@Autowired
	public IGoodsTypeMapper typeMapper;
	
	@Override
	public List<GoodsType> finds() {
		return typeMapper.finds();
	}

	@Override
	public int addGoodsType(String tname) {
		return typeMapper.addGoodsType(tname);
	}

	@Override
	public int delGoodsType(int tno) {
		return typeMapper.delGoodsType(tno);
	}

	@Override
	public int upGoodsType(GoodsType goodsType) {
		return typeMapper.upGoodsType(goodsType);
	}

}
