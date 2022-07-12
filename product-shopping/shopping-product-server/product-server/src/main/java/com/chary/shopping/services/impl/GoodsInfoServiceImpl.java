package com.chary.shopping.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chary.shopping.bean.GoodsInfo;
import com.chary.shopping.mapper.IGoodsInfoMapper;
import com.chary.shopping.services.IGoodsInfoService;
import com.chary.shopping.util.StringUtil;

@Service
public class GoodsInfoServiceImpl implements IGoodsInfoService{

	@Autowired
	public IGoodsInfoMapper goodsInfoMapper;
	
	@Override
	public int add(GoodsInfo gf) {
		if(StringUtil.checkNull(gf.getGname(), gf.getPrice())) {
			return -1;
		}
		
		return goodsInfoMapper.add(gf);
	}

	@Override
	public List<Map<String,Object>> findAll() {
		return goodsInfoMapper.findAll();
	}
	
	@Override
	public GoodsInfo findByGno(int gno) {
		return goodsInfoMapper.findByGno(gno);
	}

	@Override
	public List<GoodsInfo> searchGood(Map<String, String> map) {
		return goodsInfoMapper.searchGood(map);
	}

	@Override
	public int delGoodsInfo(int gno) {
		return goodsInfoMapper.delGoodsInfo(gno);
	}

	@Override
	public int updateGoodsInfo(GoodsInfo goodsInfo) {
		return goodsInfoMapper.updateGoodsInfo(goodsInfo);
	}

}
