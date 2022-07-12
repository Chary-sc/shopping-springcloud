package com.chary.shopping.bean;

public class AddressInfo {

	private Integer ano;			
	private Integer uno;		
	private String name;		
	private String tel;			
	private String province;	
	private String city;		
	private String area;		
	private String addr;		
	private Integer flag;		
	private Integer status;
	
	@Override
	public String toString() {
		return "AddressInfo [ano=" + ano + ", uno=" + uno + ", name=" + name + ", tel=" + tel + ", province=" + province
				+ ", city=" + city + ", area=" + area + ", addr=" + addr + ", flag=" + flag + ", status=" + status
				+ "]";
	}

	public AddressInfo(Integer ano, Integer uno, String name, String tel, String province, String city, String area,
			String addr, Integer flag, Integer status) {
		super();
		this.ano = ano;
		this.uno = uno;
		this.name = name;
		this.tel = tel;
		this.province = province;
		this.city = city;
		this.area = area;
		this.addr = addr;
		this.flag = flag;
		this.status = status;
	}

	public AddressInfo() {
		super();
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getUno() {
		return uno;
	}

	public void setUno(Integer uno) {
		this.uno = uno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}	
	
}
