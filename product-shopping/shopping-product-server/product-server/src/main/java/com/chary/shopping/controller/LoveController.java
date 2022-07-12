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
import com.chary.shopping.services.ILoveInfoService;
import com.chary.shopping.util.ResultEnum;
import com.chary.shopping.util.ResultVO;
import com.chary.shopping.util.StringUtil;

@RestController
@RequestMapping("/love")
public class LoveController {
	
	@Autowired
	private ILoveInfoService loveInfoService;
	
	/**
	 * 得到当前用户的购物车信息
	 * @param session
	 * @return
	 */
	@PostMapping("/findLoveByUno")
	public ResultVO findLoveByUno(HttpSession session) {
		
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if(!StringUtil.checkNull(userInfo)) {
			List<LoveInfo> loveInfo = loveInfoService.findLoveByUno(userInfo.getUno());
			if(loveInfo.size() > 0) {
				return new ResultVO(ResultEnum.SUCCES,loveInfo);
			}
		}
		
		return new ResultVO(ResultEnum.DATA_NULL);
	}
	
	@PostMapping("/findLoveInfo")
	public ResultVO findLoveInfo(HttpSession session) {
		
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if(!StringUtil.checkNull(userInfo)) {
			List<Map<String,Object>> loveInfo = loveInfoService.findLoveInfo(userInfo.getUno());
			if(loveInfo.size() > 0) {
				return new ResultVO(ResultEnum.SUCCES,loveInfo);
			}else if(loveInfo.size() == 0) {
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
	@PostMapping("/addLoveFirst")
	public ResultVO addLoveFirst(int gno, double price, int num ,HttpSession session) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if(StringUtil.checkNull(userInfo)) {
			return new ResultVO(ResultEnum.DATA_NULL);
		}else {
			
			LoveInfo loveInfo = new LoveInfo();
			loveInfo.setGno(gno);
			loveInfo.setNum(num);
			loveInfo.setPrice(price);
			loveInfo.setUno(userInfo.getUno());
			
			int result = loveInfoService.addLoveFirst(loveInfo);
			if(result > 0) {
				return new ResultVO(ResultEnum.SUCCES);
			}
			
		}
		
		return new ResultVO(ResultEnum.ERROR);
	}
	
	
	@PostMapping("/deleteLoveByGno")
	public ResultVO deleteLoveByGno(int gno,HttpSession session) {
			
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if(StringUtil.checkNull(userInfo)) {
			return new ResultVO(ResultEnum.DATA_NULL);
		}else {
			
			LoveInfo loveInfo = new LoveInfo();
			loveInfo.setGno(gno);
			loveInfo.setUno(userInfo.getUno());
			
			int result = loveInfoService.deleteLoveByGno(loveInfo);
			
			if(result > 0) {
				return new ResultVO(ResultEnum.SUCCES);
			}
			
		}
		
		return new ResultVO(ResultEnum.ERROR);
	}
	
}
