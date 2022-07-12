package com.chary.shopping.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chary.shopping.bean.CartInfo;
import com.chary.shopping.bean.UserInfo;
import com.chary.shopping.services.ICartInfoService;
import com.chary.shopping.util.ResultEnum;
import com.chary.shopping.util.ResultVO;
import com.chary.shopping.util.StringUtil;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private ICartInfoService cartInfoService;
	
	/**
	 * 得到当前用户的购物车信息
	 * @param session
	 * @return
	 */
	@PostMapping("/findCartAll")
	public ResultVO findCartAll(HttpSession session) {
		
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if(!StringUtil.checkNull(userInfo)) {
			List<CartInfo> cartInfo = cartInfoService.findCartByUno(userInfo.getUno());
			if(cartInfo.size() > 0) {
				return new ResultVO(ResultEnum.SUCCES,cartInfo);
			}
		}
		return new ResultVO(ResultEnum.DATA_NULL);
	}
	
	@PostMapping("/findCartInfo")
	public ResultVO findCartInfo(HttpSession session) {
		
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if(!StringUtil.checkNull(userInfo)) {
			List<Map<String,Object>> cartInfo = cartInfoService.findCartInfo(userInfo.getUno());
			if(cartInfo.size() > 0) {
				return new ResultVO(ResultEnum.SUCCES,cartInfo);
			}else if(cartInfo.size() == 0) {
				return new ResultVO(ResultEnum.DATA_NULL);
			}
		}
		
		return new ResultVO(ResultEnum.ERROR);
	}
	
	
	/**
	 * 添加到购物车
	 * @param gno
	 * @param price
	 * @param num
	 * @param session
	 * @return
	 */
	@PostMapping("/addCart")
	public ResultVO addCart(int gno, double price, int num ,HttpSession session) {
			
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if(StringUtil.checkNull(userInfo)) {
			return new ResultVO(ResultEnum.DATA_NULL);
		}else {
			
			CartInfo cartInfo = new CartInfo();
			cartInfo.setGno(gno);
			cartInfo.setNum(num);
			cartInfo.setPrice(price);
			cartInfo.setUno(userInfo.getUno());
			
			int result = cartInfoService.addCart(cartInfo);
			
			if(result > 0) {
				return new ResultVO(ResultEnum.SUCCES);
			}
			
		}
		
		return new ResultVO(ResultEnum.ERROR);
	}
	
	
	@PostMapping("/deleteCartByGno")
	public ResultVO deleteCartByGno(int gno,HttpSession session) {
			
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if(StringUtil.checkNull(userInfo)) {
			return new ResultVO(ResultEnum.DATA_NULL);
		}else {
			
			CartInfo cartInfo = new CartInfo();
			cartInfo.setGno(gno);
			cartInfo.setUno(userInfo.getUno());
			
			int result = cartInfoService.deleteCartByGno(cartInfo);
			
			if(result > 0) {
				return new ResultVO(ResultEnum.SUCCES);
			}
			
		}
		
		return new ResultVO(ResultEnum.ERROR);
	}
	
}
