package com.chary.shopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chary.shopping.bean.UserInfo;
import com.chary.shopping.util.ResultEnum;
import com.chary.shopping.util.ResultVO;
import com.chary.shopping.util.StringUtil;

@RestController
@RequestMapping("/product")
public class ProductController {

	@GetMapping("/check")
	public ResultVO check(HttpSession session) {
		
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if(StringUtil.checkNull(userInfo)) {
			return new ResultVO(ResultEnum.DATA_NULL);
		}
		return new ResultVO(ResultEnum.SUCCES, userInfo);
		
	}
	
	
}
