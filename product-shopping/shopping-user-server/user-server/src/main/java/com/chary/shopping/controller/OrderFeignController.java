package com.chary.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chary.shopping.feign.IOrderFeign;
import com.chary.shopping.util.ResultVO;

@RestController
@RequestMapping("/orderfeign")
public class OrderFeignController {
	
	//对应获取值的对应接口
	@Autowired
	private IOrderFeign orderFeign;
			
	@PostMapping("/findOrderAll")
	public ResultVO findOrderAll() {
		return orderFeign.findOrderAll();
	}
	
	@PostMapping("/delOrderByOno")
	public ResultVO delOrderByOno(String ono) {
		return orderFeign.delOrderByOno(ono);
	}
	
	@PostMapping("/upOrderStatus")
	public ResultVO upOrderStatus(String ono,int status) {
		return orderFeign.upOrderStatus(ono,status);
	}
	
	@PostMapping("/batchUpOrderStatus")
	public ResultVO batchUpOrderStatus(String ono) {
		return orderFeign.batchUpOrderStatus(ono);
	}

}
