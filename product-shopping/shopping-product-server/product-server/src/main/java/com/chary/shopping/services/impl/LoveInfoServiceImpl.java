package com.chary.shopping.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chary.shopping.bean.LoveInfo;
import com.chary.shopping.mapper.ILoveInfoMapper;
import com.chary.shopping.services.ILoveInfoService;
import com.chary.shopping.util.StringUtil;

@Service
public class LoveInfoServiceImpl implements ILoveInfoService {

	@Autowired
	public ILoveInfoMapper loveInfoMapper; 

	@Override
	public List<LoveInfo> findLoveByUno(int uno) {
		return loveInfoMapper.findLoveByUno(uno);
	}

	@Override
	public LoveInfo findLove(LoveInfo li) {
		return loveInfoMapper.findLove(li);
	}

	@Override
	public List<Map<String, Object>> findLoveInfo(int uno) {
		return loveInfoMapper.findLoveInfo(uno);
	}

	@Override
	public int addLoveFirst(LoveInfo li) {
		LoveInfo loveInfo = this.findLove(li);
		if(StringUtil.checkNull(loveInfo)) {
			return loveInfoMapper.addLoveFirst(li);
		}
		return this.deleteLoveByGno(li);
	}

	@Override
	public int deleteLoveByGno(LoveInfo li) {
		return loveInfoMapper.deleteLoveByGno(li);
	}


}
