package com.chary.shopping.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * session 外键值
 * @ClassName: SessionConstantKey
 * @Description:TODO
 * @author Chary
 * @date:  2021年10月22日 下午12:07:43	
 * @param:
 */
public class SessionConstantKey {
	
	public static String basePath; 	//服务器路径
	public static String uploadPath;	//上传文件的路径
	public static Integer MEMBERMNO;
	public static String CURRENTONO;
	public static String VCODE = "";
	public static String REMARK = "";
	public static final String CURRENTMEMBER = "currentMember";	//当前登录的用户
	public static final String CURRENTLOGINADMIN = "currentAdmin";
	
	public static List<Map<String,Object>> goodsInfo = new ArrayList<Map<String,Object>>();	//全部商品
	public static List<Map<String,Object>> goodsType = new ArrayList<Map<String,Object>>(); //全部类型
	public static List<Map<String,Object>> newGoodsInfo = new ArrayList<Map<String,Object>>(); //今日上新
	public static List<Map<String,Object>> discountGoodsInfo = new ArrayList<Map<String,Object>>(); //今日五折
	
	
	//待改善
	public static Double MONEY;
	public static String ANO;
	
}
