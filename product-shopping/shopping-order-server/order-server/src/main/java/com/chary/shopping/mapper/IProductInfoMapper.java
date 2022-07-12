package com.chary.shopping.mapper;

import java.util.List;
import java.util.Map;

import com.chary.shopping.bean.LoveInfo;

public interface IProductInfoMapper {

	public List<Map<String,Object>> findCartInfo(int uno);
	
	public List<LoveInfo> findLoveByUno(int uno);
	
}
