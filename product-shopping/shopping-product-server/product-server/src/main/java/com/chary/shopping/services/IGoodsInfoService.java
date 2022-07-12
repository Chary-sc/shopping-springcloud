package com.chary.shopping.services;

import java.util.List;
import java.util.Map;

import com.chary.shopping.bean.GoodsInfo;

public interface IGoodsInfoService {

	public int add(GoodsInfo gf);

	public List<Map<String,Object>> findAll();

	public GoodsInfo findByGno(int gno);
	
	public List<GoodsInfo> searchGood(Map<String,String> map);
	
	public int delGoodsInfo(int gno);
	
	public int updateGoodsInfo(GoodsInfo goodsInfo);
}

