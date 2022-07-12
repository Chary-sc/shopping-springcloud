package com.chary.shopping.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chary.shopping.bean.CartInfo;
import com.chary.shopping.mapper.ICartInfoMapper;
import com.chary.shopping.services.ICartInfoService;
import com.chary.shopping.util.StringUtil;

@Service
public class CartInfoServiceImpl implements ICartInfoService {

	@Autowired
	public ICartInfoMapper cartInfoMapper; 
	
	@Override
	public int addCart(CartInfo ci) {
		CartInfo cartInfo = this.findCart(ci);
		if(StringUtil.checkNull(cartInfo)) {
			return this.addCartFirst(ci);
		}
		 int result = cartInfoMapper.addCart(ci);
		 this.deleteCart();
		 return	result;
	}

	@Override
	public int subCart(CartInfo ci) {
		return cartInfoMapper.subCart(ci);
	}

	@Override
	public List<CartInfo> findCartByUno(int uno) {
		return cartInfoMapper.findCartByUno(uno);
	}

	@Override
	public int deleteCart() {
		return cartInfoMapper.deleteCart();
	}


	@Override
	public int addCartFirst(CartInfo ci) {
		return cartInfoMapper.addCartFirst(ci);
	}
	
	@Override
	public CartInfo findCart(CartInfo ci) {
		return cartInfoMapper.findCart(ci);
	}

	@Override
	public List<Map<String, Object>> findCartInfo(int mno) {
		return cartInfoMapper.findCartInfo(mno);
	}

	@Override
	public int deleteCartByGno(CartInfo ci) {
		return cartInfoMapper.deleteCartByGno(ci);
	}


}
