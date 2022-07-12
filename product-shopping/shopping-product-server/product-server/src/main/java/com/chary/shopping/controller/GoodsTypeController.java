package com.chary.shopping.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chary.shopping.bean.GoodsType;
import com.chary.shopping.services.IGoodsTypeService;
import com.chary.shopping.util.ResultEnum;
import com.chary.shopping.util.ResultVO;
import com.chary.shopping.util.SessionConstantKey;

@RestController
@RequestMapping("/goodsType")
public class GoodsTypeController {

	@Autowired
	private IGoodsTypeService goodsTypeService;
	
	@PostMapping("/findTypeAll")
	public ResultVO findTypeAll(HttpSession session) {
		
		List<Map<String, Object>> allGoodsType = SessionConstantKey.goodsType;
		if(allGoodsType.size() > 0) {
			return new ResultVO(ResultEnum.SUCCES,allGoodsType);
		}else {
			List<GoodsType> allsGoodsType = goodsTypeService.finds();
			if(allsGoodsType.size()>0) {
				return new ResultVO(ResultEnum.SUCCES,allsGoodsType);
			}
			return new ResultVO(ResultEnum.DATA_NULL);
		}
		
	}
	
	
	
}
