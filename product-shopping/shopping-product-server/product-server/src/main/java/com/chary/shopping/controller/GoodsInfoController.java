package com.chary.shopping.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chary.shopping.bean.GoodsInfo;
import com.chary.shopping.services.IGoodsInfoService;
import com.chary.shopping.util.ResultEnum;
import com.chary.shopping.util.ResultVO;
import com.chary.shopping.util.SessionConstantKey;
import com.chary.shopping.util.StringUtil;

@RestController
@RequestMapping("/goodsInfo")
public class GoodsInfoController {
	
	@Autowired
	private IGoodsInfoService goodsInfoService;
	
	/**
	 * 查找全部商品
	 * @return
	 */
	@PostMapping("/findGoodsAll")
	public ResultVO findGoodsAll() {
		
		if(SessionConstantKey.goodsInfo.size() > 0) {
			return new ResultVO(ResultEnum.SUCCES,SessionConstantKey.goodsInfo);
		}else {
			SessionConstantKey.goodsInfo = goodsInfoService.findAll();
			if(SessionConstantKey.goodsInfo.size()>0) {
				return new ResultVO(ResultEnum.SUCCES,SessionConstantKey.goodsInfo);
			}else if(SessionConstantKey.goodsInfo.size() == 0) {
				return new ResultVO(ResultEnum.DATA_NULL);
			}
			return new ResultVO(ResultEnum.ERROR);
		}

	}
	
	
	/**
	 * 今日上新产品	
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/findNewGoods")
	public ResultVO findNewGoods() {
		
		if(SessionConstantKey.newGoodsInfo.size()>0) {
			return new ResultVO(ResultEnum.SUCCES,SessionConstantKey.newGoodsInfo);
		}
		
		ResultVO resultData = findGoodsAll();
		SessionConstantKey.newGoodsInfo = (List<Map<String, Object>>) resultData.getData();	
		
		if(SessionConstantKey.newGoodsInfo.size() > 0) {
			SessionConstantKey.newGoodsInfo = randomGoods(8,SessionConstantKey.newGoodsInfo);
			return new ResultVO(ResultEnum.SUCCES,SessionConstantKey.newGoodsInfo);
		}else {
			return new ResultVO(ResultEnum.DATA_NULL);
		}

	}
	
	/**
	 * 今日五折
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/findDiscountGoods")
	public ResultVO findDiscountGoods() {
		
		
		if(SessionConstantKey.discountGoodsInfo.size()>0) {
			return new ResultVO(ResultEnum.SUCCES,SessionConstantKey.discountGoodsInfo);
		}
		
		ResultVO resultData = findGoodsAll();
		SessionConstantKey.discountGoodsInfo = (List<Map<String, Object>>) resultData.getData();	
		
		if(SessionConstantKey.discountGoodsInfo.size() > 0) {
			SessionConstantKey.discountGoodsInfo = randomGoods(6,SessionConstantKey.discountGoodsInfo);
			//成功得到五折产品后取消在通用商品的位置避免冲突
			for(int i = 0; i < SessionConstantKey.goodsInfo.size(); i ++) {
				for(int j = 0; j < SessionConstantKey.discountGoodsInfo.size(); j ++) {
					if((SessionConstantKey.goodsInfo.get(i)).equals(SessionConstantKey.discountGoodsInfo.get(j))){
						SessionConstantKey.goodsInfo.remove(i);
						i--;
						break;
					}
				}
			}
			return new ResultVO(ResultEnum.SUCCES,SessionConstantKey.discountGoodsInfo);
		}else {
			return new ResultVO(ResultEnum.DATA_NULL);
		}

	}
	
	/**
	  *  相关产品 暂时随机
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/findRelatedGoods")
	public ResultVO findRelatedGoods() {

		ResultVO resultData = findGoodsAll();
		List<Map<String, Object>> relatedGoodsInfo = (List<Map<String, Object>>) resultData.getData();	
		
		if(relatedGoodsInfo.size() > 0) {
			relatedGoodsInfo = randomGoods(4,relatedGoodsInfo);
			return new ResultVO(ResultEnum.SUCCES,relatedGoodsInfo);
		}else {
			return new ResultVO(ResultEnum.DATA_NULL);
		}

	}
	
	
	/**
	 * 商品编号查询
	 * @param gno
	 * @return
	 */
	@PostMapping("/findGoodInfoByGno")
	public ResultVO findGoodInfoByGno(int gno) {
		
		GoodsInfo goodsInfo = goodsInfoService.findByGno(gno);
		if(StringUtil.checkNull(goodsInfo)) {
			return new ResultVO(ResultEnum.DATA_NULL);
		}
		
		return new ResultVO(ResultEnum.SUCCES,goodsInfo);
	}
	
	@PostMapping("/searchGood")
	public ResultVO searchGood(int tno, String content) {
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("tno", tno >0 ? tno +"" : "");
		map.put("gname", content);
		List<GoodsInfo> goodsInfo = goodsInfoService.searchGood(map);
		if(StringUtil.checkNull(goodsInfo)) {
			return new ResultVO(ResultEnum.DATA_NULL);
		}
		
		return new ResultVO(ResultEnum.SUCCES,goodsInfo);
		
	}
	
	//随机生成指定数量得商品
	public List<Map<String,Object>> randomGoods(int n,List<Map<String,Object>> goodsInfo){
		
		List<Map<String,Object>> goods = new ArrayList<Map<String,Object>>();
		List<Integer> arr = new ArrayList<Integer>();
		
		while(true) {
			int temp = (int) (Math.random() * goodsInfo.size());
			if(!arr.contains(temp)) {
				arr.add(temp);
				goods.add(goodsInfo.get(temp));
			}
			if(arr.size() == n) {
				break;
			}
		}
		return goods;
	}
	
	
}
