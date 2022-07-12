package com.chary.shopping.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chary.shopping.bean.GoodsInfo;
import com.chary.shopping.bean.GoodsType;
import com.chary.shopping.services.IGoodsInfoService;
import com.chary.shopping.services.IGoodsTypeService;
import com.chary.shopping.util.ResultEnum;
import com.chary.shopping.util.ResultVO;

@RestController
@RequestMapping("/productfeign")
public class ProductFeignController {

	@Autowired
	private IGoodsTypeService goodsTypeService;
	
	@Autowired
	private IGoodsInfoService goodsInfoService;
	
	@PostMapping("/findTypeAll")
	public ResultVO findTypeAll(HttpSession session) {
		
	
		List<GoodsType> allsGoodsType = goodsTypeService.finds();
			if(allsGoodsType.size()>0) {
				return new ResultVO(ResultEnum.SUCCES,allsGoodsType);
			}
			return new ResultVO(ResultEnum.DATA_NULL);
	}
	
	@PostMapping("/addGoodsType")
	public ResultVO addGoodsType(String tname) {
		int result  = goodsTypeService.addGoodsType(tname);
			if(result>0) {
				return new ResultVO(ResultEnum.SUCCES);
			}
			return new ResultVO(ResultEnum.ERROR);
	}

	@PostMapping("/delGoodsType")
	public ResultVO delGoodsType(int tno) {
		
		int result  = goodsTypeService.delGoodsType(tno);
			if(result>0) {
				return new ResultVO(ResultEnum.SUCCES);
			}
			return new ResultVO(ResultEnum.ERROR);
	}
	
	
	@PostMapping("/upGoodsType")
	public ResultVO upGoodsType(int tno, String tname) {
		
		GoodsType goodsType = new GoodsType();
		goodsType.setTname(tname);
		goodsType.setTno(tno);
		
		int result  = goodsTypeService.upGoodsType(goodsType);
			if(result>0) {
				return new ResultVO(ResultEnum.SUCCES);
			}
			return new ResultVO(ResultEnum.ERROR);
	}
	
	@PostMapping("/addGoodsInfo")
	public ResultVO addGoodsInfo(@RequestBody GoodsInfo goodsInfo) {
		
		int result = goodsInfoService.add(goodsInfo);
		if(result > 0) {
			return new ResultVO(ResultEnum.SUCCES);
		}
		return new ResultVO(ResultEnum.ERROR);
	}
	
	@PostMapping("/findGoodsInfoAll")
	public ResultVO findGoodsInfoAll() {
		
		List<Map<String, Object>> goodsInfo = goodsInfoService.findAll();
		if(goodsInfo.size() >= 0) {
			return new ResultVO(ResultEnum.SUCCES,goodsInfo);
		}
		return new ResultVO(ResultEnum.ERROR);
	}
	
	@PostMapping("/delGoodsInfo")
	public ResultVO delGoodsInfo(int gno) {
		
		if(goodsInfoService.delGoodsInfo(gno) > 0) {
			return new ResultVO(ResultEnum.SUCCES);
		}
		return new ResultVO(ResultEnum.ERROR);
	}
	
	@PostMapping("/updateGoodsInfo")
	public ResultVO updateGoodsInfo(@RequestBody GoodsInfo goodsInfo) {
		
		if(goodsInfoService.updateGoodsInfo(goodsInfo) > 0) {
			return new ResultVO(ResultEnum.SUCCES);
		}
		return new ResultVO(ResultEnum.ERROR);
	}

	
}
