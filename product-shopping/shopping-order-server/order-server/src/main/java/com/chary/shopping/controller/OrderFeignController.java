package com.chary.shopping.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chary.shopping.bean.OrderInfo;
import com.chary.shopping.service.IOrderInfoService;
import com.chary.shopping.util.ResultEnum;
import com.chary.shopping.util.ResultVO;

@RestController
@RequestMapping("/orderfeign")
public class OrderFeignController {

	@Autowired
	private IOrderInfoService orderInfoService;
	
	@PostMapping("/findOrderAll")
	public ResultVO findOrderAll() {
		
		List<Map<String,Object>> orderInfo = orderInfoService.findOrderAllByManager();
		List<Map<String,Object>> orderItemInfo = new ArrayList<Map<String, Object>>(); 
		for(int i = 0; i < orderInfo.size(); i ++) {
			List<Map<String,Object>> list = orderInfoService.findOrderItemByOno(orderInfo.get(i).get("ono")+ "");
			orderItemInfo.addAll(list);
		}
		if(orderItemInfo.size() >= 0) {
			return new ResultVO(ResultEnum.SUCCES,orderInfo,orderItemInfo);
		}
		
		return new ResultVO(ResultEnum.ERROR);
	}
	
	@PostMapping("/delOrderByOno")
	public ResultVO delOrderByOno(String ono) {
		
		if(orderInfoService.delOredr(ono) > 0 ) {
			return new ResultVO(ResultEnum.SUCCES);
		}
		
		return new ResultVO(ResultEnum.ERROR);
	}
	
	
	@PostMapping("/upOrderStatus")
	public ResultVO upOrderStatus(String ono,int status) {
		
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setOno(ono);
		orderInfo.setStatus(status);

		if(orderInfoService.upOrderStatus(orderInfo) > 0 ) {
			return new ResultVO(ResultEnum.SUCCES);
		}
		
		return new ResultVO(ResultEnum.ERROR);
	}
	
	@PostMapping("/batchUpOrderStatus")
	public ResultVO batchUpOrderStatus(String ono) {		
		if(orderInfoService.batchUpOrderStatus(ono) > 0 ) { 
			  return new ResultVO(ResultEnum.SUCCES); 
		}	  
		 return new ResultVO(ResultEnum.ERROR);
		 
	}
	
}
