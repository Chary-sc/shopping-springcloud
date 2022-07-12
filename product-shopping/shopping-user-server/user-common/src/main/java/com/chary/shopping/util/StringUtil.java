package com.chary.shopping.util;

import java.util.Map;

public class StringUtil {

	public static boolean checkNull(String ... strs) {
		if(strs == null || strs.length <= 0) {
			return true;
		}
		
		for(String str : strs) {
			if(str == null || "".equals(str) || "null".equals(str)) {
				return true;
			}
		}
		
		return false;
		
	}
	
	
	public static boolean checkNull(Object ... objs) {
		if(objs == null || objs.length <= 0) {
			return true;
		}
		
		for(Object obj : objs) {
			if(obj == null || "".contentEquals(String.valueOf(obj)) ) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public static Map<String,Object> parsePage(Map<String,Object> map){
		
		int page =Integer.parseInt( String.valueOf(map.get("page")));
		int rows = Integer.parseInt(String.valueOf(map.get("rows")));
		
		map.put("page", (page - 1) * rows);
		map.put("rows", rows);
		
		return map;
	}
	
}
