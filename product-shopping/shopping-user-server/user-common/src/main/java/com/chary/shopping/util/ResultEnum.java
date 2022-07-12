package com.chary.shopping.util;

/**
 * 返回参数定义
 * @ClassName: ResultEnum
 * @Description:TODO
 * @author Chary
 * @date:  2021年10月22日 下午12:11:38	
 * @param:
 */
public enum ResultEnum {

	SUCCES(200,"成功"),
	
	ERROR(500,"错误"),
	CODE_ERROR(501,"验证码错误"),
	CHECK_ERROR(502,"格式错误"),
	
	DATA_NULL(600,"数据为空"),
	DATA_EXIT(601,"数据存在"),
	
	LOGIN_ERROR(700,"账号或密码错误"),
	LOGIN_CHECK(701,"未登录");
	
	private Integer code;	//返回编码
	private String msg;		//返回信息
	
	
	
	
	@Override
	public String toString() {
		return "ResultEnum [code=" + code + ", msg=" + msg + "]";
	}

	private ResultEnum() {
	}
	
	private ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
