package com.chary.shopping.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.config.AlipayConfig;
import com.chary.shopping.bean.AddrInfo;
import com.chary.shopping.bean.OrderInfo;
import com.chary.shopping.bean.OrderItemInfo;
import com.chary.shopping.bean.UserInfo;
import com.chary.shopping.service.IOrderInfoService;
import com.chary.shopping.service.IProductInfoService;
import com.chary.shopping.util.ResultEnum;
import com.chary.shopping.util.ResultVO;
import com.chary.shopping.util.SessionConstantKey;

@RestController
@RequestMapping("/order")
public class OrderInfoController {

	@Autowired
	private IOrderInfoService orderInfoService;
	
	@Autowired
	private IProductInfoService productInfoService;
	
	
	/**
	 * 支付订单
	 * @param money 支付金额	
	 * @param ano   收货地址
	 * @param resp	
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/payOrder")
	public String orderPay(Double money,String ano,String remark,HttpServletResponse resp,HttpSession session) throws IOException {
		

		try {

			AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

			AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
			alipayRequest.setReturnUrl(AlipayConfig.return_url);
			alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

			SessionConstantKey.CURRENTONO = System.currentTimeMillis()/1000 + "";
			SessionConstantKey.ANO = ano;
			SessionConstantKey.MONEY = money;
			SessionConstantKey.REMARK = remark;
			
			session.setAttribute("SessionConstantKey.CURRENTONO", SessionConstantKey.CURRENTONO);
			session.setAttribute("SessionConstantKey.ANO", SessionConstantKey.ANO);
			session.setAttribute("SessionConstantKey.MONEY", SessionConstantKey.MONEY);
			

			String out_trade_no = SessionConstantKey.CURRENTONO;

			String total_amount = money + "";

			String subject = "Chary-Shopping";

			String body = "Fresh And Convenient";
			
			alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
					+ "\"total_amount\":\""+ total_amount +"\"," 
					+ "\"subject\":\""+ subject +"\"," 
					+ "\"body\":\""+ body +"\"," 
					+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
			
			
			String result = alipayClient.pageExecute(alipayRequest).getBody();
			
			resp.setContentType("text/html;charset=utf-8");
		    resp.getWriter().print(result);
		    			
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		return null; 
		
	}
	
	/**
	 * 校验支付
	 * @param ono 订单编号
	 * @return
	 */
	@PostMapping("/checkPay")
	public ResultVO checkPay(String ono) {

		if(SessionConstantKey.CURRENTONO.equals(ono)) {
			return new ResultVO(ResultEnum.SUCCES);
		}
		
		return new ResultVO(ResultEnum.CHECK_ERROR);
		
	}
	
	
	/**
	 * 订单信息添加
	 * @return
	 */
	@PostMapping("/addOrderItem")
	public ResultVO addOrderItem(HttpSession session) {

		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");	
		OrderInfo orderInfo = new OrderInfo();
		OrderItemInfo orderItemInfo = new OrderItemInfo();
		List<Map<String,Object>> cartInfo =  productInfoService.findCartInfo(userInfo.getUno());
		
		orderInfo.setAno(SessionConstantKey.ANO);
		orderInfo.setOno(SessionConstantKey.CURRENTONO);
		orderInfo.setTotal(SessionConstantKey.MONEY);
		orderInfo.setUno(userInfo.getUno());
		orderInfo.setRemark(SessionConstantKey.REMARK);
		
		orderInfoService.addOrder(orderInfo);
		for(int i = 0; i< cartInfo.size(); i ++) {
			orderItemInfo.setGno(Integer.parseInt(cartInfo.get(i).get("gno") + ""));
			orderItemInfo.setNums(Integer.parseInt(cartInfo.get(i).get("num") + ""));
			orderItemInfo.setOno(SessionConstantKey.CURRENTONO);
			orderItemInfo.setPrice(Double.parseDouble(cartInfo.get(i).get("price") + ""));
			orderInfoService.addOrderItem(orderItemInfo);
		}

		orderInfoService.delCartByOrder(userInfo.getUno());
		
		return new ResultVO(ResultEnum.SUCCES);
		
	}
	
	/**
	 * 查询订单信息
	 * @param session
	 * @return
	 */
	@PostMapping("/findOrderAll")
	public ResultVO findOrderAll(HttpSession session) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		List<OrderInfo> orderInfo = orderInfoService.findOrderAll(userInfo.getUno());
		List<Map<String,Object>> orderItemInfo = new ArrayList<Map<String, Object>>(); 
		
		for(int i = 0; i < orderInfo.size(); i ++) {
			List<Map<String,Object>> list = orderInfoService.findOrderItemByOno(orderInfo.get(i).getOno());
			orderItemInfo.addAll(list);
		}
		if(orderItemInfo.size() > 0) {
			return new ResultVO(ResultEnum.SUCCES,orderInfo,orderItemInfo);
		}else if(orderItemInfo.size() == 0) {
			return new ResultVO(ResultEnum.DATA_NULL);
		}
		return new ResultVO(ResultEnum.ERROR);
	}
	
	/**
	 * 删除订单
	 * @param ono
	 * @return
	 */
	@PostMapping("/deleteOrderByOno")
	public ResultVO findOrderAll(String ono) {

		if(orderInfoService.delOredr(ono) > 0 ) {
			return new ResultVO(ResultEnum.SUCCES);
		}
		
		return new ResultVO(ResultEnum.ERROR);

	}
	
	/**
	 * 新增地址
	 * @param name
	 * @param province
	 * @param city
	 * @param area
	 * @param addr
	 * @param remark
	 * @param session
	 * @return
	 */
	@PostMapping("/addAddrInfo")
	public ResultVO addAddrInfo(String name,String province,String city,String area,String addr, HttpSession session) {
		
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		AddrInfo addrInfo = new AddrInfo(userInfo.getUno(), name, userInfo.getEmail(), province, city, area, addr,  0, 1);
		int result = orderInfoService.addAddrInfo(addrInfo);
		
		if(result > 0) {
			return new ResultVO(ResultEnum.SUCCES);
		}
	
		return new ResultVO(ResultEnum.ERROR);

	}
	
	/**
	 * 删除地址
	 * @param ano
	 * @return
	 */
	@PostMapping("/delAddrInfoByAno")
	public ResultVO delAddrInfoByAno(int ano) {
		
		int result = orderInfoService.delAddrInfoByAno(ano);
		
		if(result > 0) {
			return new ResultVO(ResultEnum.SUCCES);
		}
	
		return new ResultVO(ResultEnum.ERROR);

	}
	
	/**
	 * 设置默认地址
	 * @param ano
	 * @return
	 */
	@PostMapping("/setDefaultAddr")
	public ResultVO setDefaultAddr(int ano, HttpSession session) {
		
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		
		orderInfoService.cancelDefaultAddr(userInfo.getUno());
		int result = orderInfoService.setDefaultAddr(ano);
		
		if(result > 0) {
			return new ResultVO(ResultEnum.SUCCES);
		}
	
		return new ResultVO(ResultEnum.ERROR);

	}
	
	/**
	 * 查询用户地址
	 * @param session
	 * @return
	 */
	@PostMapping("/findAddrInfoByUno")
	public ResultVO findAddrInfoByUno(HttpSession session) {
		
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		List<AddrInfo> addrInfo = orderInfoService.findAddrInfoByUno(userInfo.getUno());
		
		if(addrInfo.size() > 0) {
			return new ResultVO(ResultEnum.SUCCES,addrInfo);
		}else if(addrInfo.size() == 0) {
			return new ResultVO(ResultEnum.SUCCES,addrInfo);
		}
	
		return new ResultVO(ResultEnum.ERROR);

	}
	
}