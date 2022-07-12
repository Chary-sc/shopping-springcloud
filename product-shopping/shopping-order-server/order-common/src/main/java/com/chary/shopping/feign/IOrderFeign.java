package com.chary.shopping.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chary.shopping.util.ResultEnum;
import com.chary.shopping.util.ResultVO;


@FeignClient(name="order-server", fallback = IOrderFeign.OrderFeign.class)
public interface IOrderFeign {
    
	/**
	 * 获取所有的商品类型
	 * @return
	 */
	@PostMapping("/orderfeign/findOrderAll")		
	public ResultVO findOrderAll();	
	
	@PostMapping("/orderfeign/delOrderByOno")		
	public ResultVO delOrderByOno(@RequestParam("ono") String ono);	
	
	@PostMapping("/orderfeign/upOrderStatus")		
	public ResultVO upOrderStatus(@RequestParam("ono") String ono, @RequestParam("status") int status);
	
	@PostMapping("/orderfeign/batchUpOrderStatus")		
	public ResultVO batchUpOrderStatus(@RequestParam("ono") String ono);
	
	@Component //注意，这个地方的注解不能少，不然当时要服务降级或熔断是会找不到对应的实体类
	public static class OrderFeign implements IOrderFeign{

		@Override
		public ResultVO findOrderAll() {
			return new ResultVO(ResultEnum.ERROR);
		}

		@Override
		public ResultVO delOrderByOno(String ono) {
			return new ResultVO(ResultEnum.ERROR);
		}

		@Override
		public ResultVO upOrderStatus(String ono, int status) {
			return new ResultVO(ResultEnum.ERROR);
		}

		@Override
		public ResultVO batchUpOrderStatus(String ono) {
			return new ResultVO(ResultEnum.ERROR);
		}

		
		
	}
}