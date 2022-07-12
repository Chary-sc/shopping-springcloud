package com.chary.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chary.shopping.feign.IProductFeign;
import com.chary.shopping.feign.bean.GoodsInfo;
import com.chary.shopping.util.ResultVO;
import com.chary.shopping.util.UpLoadGoodsFile;

@RestController
@RequestMapping("/productfeign")
public class ProductFeignController {

	//对应获取值的对应接口
	@Autowired
	private IProductFeign productFeign;
		
		//获取商品类型
		@PostMapping("/findTypeAll")
		public ResultVO findTypeAll() {
			return productFeign.findTypeAll();
		}
		
		//添加商品类型
		@PostMapping("/addGoodsType")
		public ResultVO addGoodsType(@RequestParam("tname") String tname) {
			return productFeign.addGoodsType(tname);
		}
		
		//删除商品类型
		@PostMapping("/delGoodsType")
		public ResultVO delGoodsType(@RequestParam("tno") int tno) {
			return productFeign.delGoodsType(tno);
		}
		
		//修改商品类型
		@PostMapping("/upGoodsType")
		public ResultVO upGoodsType(@RequestParam("tno") int tno, @RequestParam("tname") String tname) {
			return productFeign.upGoodsType(tno,tname);
		}
	
		@PostMapping("/findGoodsInfoAll")
		public ResultVO findGoodsInfoAll() {
			return productFeign.findGoodsInfoAll();
		}
		
		@PostMapping("/addGoodsInfo")
		public ResultVO addGoodsInfo(@RequestBody GoodsInfo goodsInfo) {
			
			return productFeign.addGooodsInfo(goodsInfo);
		}
		
		@PostMapping("/delGoodsInfo")
		public ResultVO delGoodsInfo(@RequestParam("gno") int gno) {
			return productFeign.delGoodsInfo(gno);
		}
		
		
		@PostMapping("/updateGoodsInfo")
		public ResultVO updateGoodsInfo(@RequestBody GoodsInfo goodsInfo) {
			return productFeign.updateGoodsInfo(goodsInfo);
		}
		
		@PostMapping("/downloadGoodsFile")
		public String uploadFile(MultipartFile file) throws Exception{
			return UpLoadGoodsFile.upload(file).replaceAll("\\\\", "/");
			
		}
		
}
