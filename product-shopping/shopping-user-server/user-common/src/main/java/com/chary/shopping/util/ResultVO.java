package com.chary.shopping.util;

public class ResultVO {

	private Integer code;
	private String msg;
	private Object data;
	private Object extendData;
	
	public ResultVO() {
	}

	public ResultVO(ResultEnum re) {
		this.code = re.getCode();
		this.msg = re.getMsg();
	}

	public ResultVO(ResultEnum re, Object data) {
		this.code = re.getCode();
		this.msg = re.getMsg();
		this.data = data;
	}
	
	public ResultVO(ResultEnum re, Object data, Object extendData) {
		this.code = re.getCode();
		this.msg = re.getMsg();
		this.data = data;
		this.extendData = extendData;
	}
	
	public ResultVO(Integer code, Object data) {
		this.code = code;
		this.data = data;
	}

	public ResultVO(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public ResultVO(Integer code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public ResultVO(Integer code, String msg, Object data, Object extendData) {
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.extendData = extendData;
	}


	@Override
	public String toString() {
		return "ResultVO [code=" + code + ", msg=" + msg + ", data=" + data + ", extendData=" + extendData + "]";
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


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}

	public Object getExtendData() {
		return extendData;
	}

	public void setExtendData(Object extendData) {
		this.extendData = extendData;
	}
	
}
