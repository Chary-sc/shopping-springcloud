package com.chary.shopping.service;

import java.util.List;
import java.util.Map;

import com.chary.shopping.bean.AddrInfo;
import com.chary.shopping.bean.OrderInfo;
import com.chary.shopping.bean.OrderItemInfo;

public interface IOrderInfoService {
	
public int addOrder(OrderInfo orderInfo);
	
	public int addOrderItem(OrderItemInfo orderItemInfo);
	
	public int delCartByOrder(int uno);
	
	public List<OrderInfo> findOrderAll(int uno);
	
	public List<Map<String,Object>> findOrderItemByOno(String ono);
	
	public int delOredr(String ono);
	
	public int delOredrItem(String ono);
	
	public int addAddrInfo(AddrInfo addrInfo);
	
	public int delAddrInfoByAno(int ano);
	
	public int cancelDefaultAddr(int uno);
	
	public int setDefaultAddr(int ano);
	
	public List<AddrInfo> findAddrInfoByUno(int uno);
	
	public List<Map<String,Object>> findOrderAllByManager();
	
	public int upOrderStatus(OrderInfo orderInfo);
	
	public int batchUpOrderStatus(String ono);
}
