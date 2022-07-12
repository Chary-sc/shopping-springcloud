package com.chary.shopping.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chary.shopping.bean.AddrInfo;
import com.chary.shopping.bean.OrderInfo;
import com.chary.shopping.bean.OrderItemInfo;
import com.chary.shopping.mapper.IOrderInfoMapper;
import com.chary.shopping.service.IOrderInfoService;


@Service
public class OrderInfoServiceImpl implements IOrderInfoService{

	@Autowired
	private IOrderInfoMapper orderInfoMapper;
	
	@Override
	public int addOrder(OrderInfo orderInfo) {		
		return orderInfoMapper.addOrder(orderInfo);
	}

	@Override
	public int addOrderItem(OrderItemInfo orderItemInfo) {
		return orderInfoMapper.addOrderItem(orderItemInfo);
	}

	@Override
	public int delCartByOrder(int uno) {
		return orderInfoMapper.delCartByOrder(uno);
	}

	@Override
	public List<OrderInfo> findOrderAll(int uno) {
		return orderInfoMapper.findOrderAll(uno);
	}

	@Override
	public List<Map<String, Object>> findOrderItemByOno(String ono) {
		return orderInfoMapper.findOrderItemByOno(ono);
	}

	@Override
	public int delOredr(String ono) {
		if(this.delOredrItem(ono) > 0) {
			return orderInfoMapper.delOredr(ono);
		}
		
		return -1;
	}

	@Override
	public int delOredrItem(String ono) {
		return orderInfoMapper.delOredrItem(ono);
	}

	@Override
	public int addAddrInfo(AddrInfo addrInfo) {
		return orderInfoMapper.addAddrInfo(addrInfo);
	}

	@Override
	public int delAddrInfoByAno(int ano) {
		return orderInfoMapper.delAddrInfoByAno(ano);
	}
	
	@Override
	public int cancelDefaultAddr(int uno) {
		return orderInfoMapper.cancelDefaultAddr(uno);
	}

	@Override
	public int setDefaultAddr(int ano) {
		return orderInfoMapper.setDefaultAddr(ano);
	}

	@Override
	public List<AddrInfo> findAddrInfoByUno(int uno) {
		return orderInfoMapper.findAddrInfoByUno(uno);
	}

	@Override
	public List<Map<String,Object>> findOrderAllByManager() {
		return orderInfoMapper.findOrderAllByManager();
	}

	@Override
	public int upOrderStatus(OrderInfo orderInfo) {
		return orderInfoMapper.upOrderStatus(orderInfo);
	}

	@Override
	public int batchUpOrderStatus(String ono) {
		return orderInfoMapper.batchUpOrderStatus(ono);
	}

}
