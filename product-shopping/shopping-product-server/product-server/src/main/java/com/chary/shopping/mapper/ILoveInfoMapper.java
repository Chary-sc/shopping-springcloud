package com.chary.shopping.mapper;

import java.util.List;
import java.util.Map;

import com.chary.shopping.bean.LoveInfo;

public interface ILoveInfoMapper {
	
	public List<LoveInfo> findLoveByUno(int uno);
	
	public LoveInfo findLove(LoveInfo li);

	public List<Map<String,Object>> findLoveInfo(int uno);

	public int addLoveFirst(LoveInfo li);
	
	public int deleteLoveByGno(LoveInfo li);
	
}

