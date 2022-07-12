package com.chary.shopping.services;

import java.util.List;

import java.util.Map;

import com.chary.shopping.bean.CartInfo;

public interface ICartInfoService {
	
public int addCart(CartInfo ci);
	
	public int subCart(CartInfo ci);
	
	public int addCartFirst(CartInfo ci);
	
	public int deleteCart();
	
	public List<CartInfo> findCartByUno(int uno);
	
	public List<Map<String,Object>> findCartInfo(int uno);
	
	public CartInfo findCart(CartInfo ci);
	
	public int deleteCartByGno(CartInfo ci);
}
