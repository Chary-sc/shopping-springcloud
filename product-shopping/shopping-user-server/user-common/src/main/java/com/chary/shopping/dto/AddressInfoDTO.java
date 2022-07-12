package com.chary.shopping.dto;

/**
 * 对外地址数据库
 * @ClassName: AddressInfoDTO
 * @Description:TODO
 * @author Chary
 * @date:  2021年10月22日 下午12:06:13	
 * @param:
 */
public class AddressInfoDTO {
		
	private Integer ano;		//地址编号		
	private Integer mno;		//用户编号
	private String name;		//寄||收件人称呼
	private String tel;			//电话
	private String province;	//省份
	private String city;		//城市
	private String area;		//地区
	private String addr;		//详细地址
	private Integer flag;		//地址状态 (是否为默认收获地址)
	private Integer status;		//地址信息状态（表示用户新填、删除）

	
	@Override
	public String toString() {
		return "AddressInfoDto [ano=" + ano + ", mno=" + mno + ", name=" + name + ", tel=" + tel + ", province="
				+ province + ", city=" + city + ", area=" + area + ", addr=" + addr + ", flag=" + flag + ", status="
				+ status + "]";
	}


	public Integer getAno() {
		return ano;
	}


	public void setAno(Integer ano) {
		this.ano = ano;
	}


	public Integer getMno() {
		return mno;
	}


	public void setMno(Integer mno) {
		this.mno = mno;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((flag == null) ? 0 : flag.hashCode());
		result = prime * result + ((mno == null) ? 0 : mno.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
		AddressInfoDTO other = (AddressInfoDTO) obj;
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
			return false;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
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
		if (flag == null) {
			if (other.flag != null)
				return false;
		} else if (!flag.equals(other.flag))
			return false;
		if (mno == null) {
			if (other.mno != null)
				return false;
		} else if (!mno.equals(other.mno))
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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}


	public AddressInfoDTO(Integer ano, Integer mno, String name, String tel, String province, String city, String area,
			String addr, Integer flag, Integer status) {
		super();
		this.ano = ano;
		this.mno = mno;
		this.name = name;
		this.tel = tel;
		this.province = province;
		this.city = city;
		this.area = area;
		this.addr = addr;
		this.flag = flag;
		this.status = status;
	}


	public AddressInfoDTO() {
		super();
	}
	
	
	
}
