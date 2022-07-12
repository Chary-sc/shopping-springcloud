package com.chary.shopping.service;

import java.util.List;
import java.util.Map;

import com.chary.shopping.bean.LoveInfo;

public interface IProductInfoService {

	public List<Map<String,Object>> findCartInfo(int uno);
	
	public List<LoveInfo> findLoveByUno(int uno);
	
}
