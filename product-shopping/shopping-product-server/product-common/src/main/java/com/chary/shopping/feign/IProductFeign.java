package com.chary.shopping.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.chary.shopping.feign.bean.GoodsInfo;
import com.chary.shopping.util.ResultEnum;
import com.chary.shopping.util.ResultVO;


@FeignClient(name="product-server", fallback = IProductFeign.ProductFeign.class)
public interface IProductFeign {
    
	/**
	 * 获取所有的商品类型
	 * @return
	 */
	@PostMapping("/productfeign/findTypeAll")		
	public ResultVO findTypeAll();	
	
	@PostMapping("/productfeign/addGoodsType")		
	public ResultVO addGoodsType(@RequestParam("tname") String tname);

	@PostMapping("/productfeign/delGoodsType")		
	public ResultVO delGoodsType(@RequestParam("tno") int tno);
	
	@PostMapping("/productfeign/upGoodsType")		
	public ResultVO upGoodsType(@RequestParam("tno") int tno, @RequestParam("tname") String tname);
	
	@PostMapping("/productfeign/findGoodsInfoAll")		
	public ResultVO findGoodsInfoAll();	
	
	@PostMapping("/productfeign/addGoodsInfo")		
	public ResultVO addGooodsInfo(@RequestBody GoodsInfo goodsInfo);	
	
	@PostMapping("/productfeign/delGoodsInfo")		
	public ResultVO delGoodsInfo(@RequestParam("gno") int gno);
	
	@PostMapping("/productfeign/updateGoodsInfo")		
	public ResultVO updateGoodsInfo(@RequestBody GoodsInfo goodsInfo);
	
	
	@Component //注意，这个地方的注解不能少，不然当时要服务降级或熔断是会找不到对应的实体类
	public static class ProductFeign implements IProductFeign{

		@Override
		public ResultVO findTypeAll() {
			return new ResultVO(ResultEnum.ERROR);
		}

		@Override
		public ResultVO addGoodsType(String tname) {
			return new ResultVO(ResultEnum.ERROR);
		}

		@Override
		public ResultVO delGoodsType(int tno) {
			return new ResultVO(ResultEnum.ERROR);
		}

		@Override
		public ResultVO upGoodsType(int tno, String tname) {
			return new ResultVO(ResultEnum.ERROR);
		}

		@Override
		public ResultVO findGoodsInfoAll() {
			return new ResultVO(ResultEnum.ERROR);
		}

		@Override
		public ResultVO addGooodsInfo(GoodsInfo goodsinfo) {
			return new ResultVO(ResultEnum.ERROR);
		}

		@Override
		public ResultVO delGoodsInfo(int gno) {
			return new ResultVO(ResultEnum.ERROR);
		}

		@Override
		public ResultVO updateGoodsInfo(GoodsInfo goodsinfo) {
			return new ResultVO(ResultEnum.ERROR);
		}
		
	}
}