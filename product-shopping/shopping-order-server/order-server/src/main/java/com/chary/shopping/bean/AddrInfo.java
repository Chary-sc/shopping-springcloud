package com.chary.shopping.bean;

public class AddrInfo {
	
	public int ano;			//地址编号
	public int uno; 		//用户编号
	public String name;		//收件人姓名
	public String email;	//收件人邮箱
	public String province;	//省份
	public String city; 	//城市
	public String area;		//地区
	public String addr;   	//详细地址
	public int flag;		//默认为0，1为默认收货地址
	public int status;		//地址状态


	public AddrInfo(int ano, int uno, String name, String email, String province, String city, String area, String addr,
			 int flag, int status) {
		super();
		this.ano = ano;
		this.uno = uno;
		this.name = name;
		this.email = email;
		this.province = province;
		this.city = city;
		this.area = area;
		this.addr = addr;
		this.flag = flag;
		this.status = status;
	}

	public AddrInfo(int uno, String name, String email, String province, String city, String area, String addr,
			 int flag, int status) {
		super();
		this.uno = uno;
		this.name = name;
		this.email = email;
		this.province = province;
		this.city = city;
		this.area = area;
		this.addr = addr;
		this.flag = flag;
		this.status = status;
	}

	public AddrInfo() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result + ano;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + flag;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		result = prime * result + status;
		result = prime * result + uno;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddrInfo other = (AddrInfo) obj;
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
			return false;
		if (ano != other.ano)
			return false;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (flag != other.flag)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (status != other.status)
			return false;
		if (uno != other.uno)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AddrInfo [ano=" + ano + ", uno=" + uno + ", name=" + name + ", email=" + email + ", province="
				+ province + ", city=" + city + ", area=" + area + ", addr=" + addr + ", flag="
				+ flag + ", status=" + status + "]";
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getUno() {
		return uno;
	}

	public void setUno(int uno) {
		this.uno = uno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
