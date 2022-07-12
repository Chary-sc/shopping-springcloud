package com.chary.shopping.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chary.shopping.bean.LoveInfo;
import com.chary.shopping.bean.UserInfo;
import com.chary.shopping.service.IProductInfoService;
import com.chary.shopping.util.ResultEnum;
import com.chary.shopping.util.ResultVO;
import com.chary.shopping.util.StringUtil;

@RestController
@RequestMapping("/product")
public class OrderOfProductController {

	@Autowired
	private IProductInfoService productInfoService;
	
	@PostMapping("/findCartInfo")
	public ResultVO findCartInfo(HttpSession session) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if(!StringUtil.checkNull(userInfo)) {
			List<Map<String,Object>> cartInfo = productInfoService.findCartInfo(userInfo.getUno());
			if(cartInfo.size() > 0) {
				return new ResultVO(ResultEnum.SUCCES,cartInfo);
			}
		}
		
		return new ResultVO(ResultEnum.ERROR);
	}
	
	@PostMapping("/findLoveByUno")
	public ResultVO findLoveByUno(HttpSession session) {
		
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if(!StringUtil.checkNull(userInfo)) {
			List<LoveInfo> loveInfo = productInfoService.findLoveByUno(userInfo.getUno());
			if(loveInfo.size() > 0) {
				return new ResultVO(ResultEnum.SUCCES,loveInfo);
			}
		}
		
		return new ResultVO(ResultEnum.DATA_NULL);
	}
	
}