package com.chary.shopping.mapper;

import java.util.List;

import com.chary.shopping.bean.GoodsType;

public interface IGoodsTypeMapper {

	public List<GoodsType> finds();
	
	public int addGoodsType(String tname);
	
	public int delGoodsType(int tno);
	
	public int upGoodsType(GoodsType goodsType);
	
}
