package com.chary.shopping.bean;

/**
 * 订单表
 * @author Admin
 *
 */
public class OrderInfo {
	
	
	private String ono; 	//订单编号
	private String odate;	//下单日期
	private String ano;		//地址编号
	private double total;	//付款金额
	private Integer uno;	//用户编号
	private String remark;	//订单备注
	private Integer status; //订单状态

	@Override
	public String toString() {
		return "OrderInfo [ono=" + ono + ", odate=" + odate + ", ano=" + ano + ", total=" + total + ", uno=" + uno
				+ ", remark=" + remark + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((odate == null) ? 0 : odate.hashCode());
		result = prime * result + ((ono == null) ? 0 : ono.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((uno == null) ? 0 : uno.hashCode());
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
		OrderInfo other = (OrderInfo) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (odate == null) {
			if (other.odate != null)
				return false;
		} else if (!odate.equals(other.odate))
			return false;
		if (ono == null) {
			if (other.ono != null)
				return false;
		} else if (!ono.equals(other.ono))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		if (uno == null) {
			if (other.uno != null)
				return false;
		} else if (!uno.equals(other.uno))
			return false;
		return true;
	}



	public String getOno() {
		return ono;
	}

	public void setOno(String ono) {
		this.ono = ono;
	}

	public String getOdate() {
		return odate;
	}

	public void setOdate(String odate) {
		this.odate = odate;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Integer getUno() {
		return uno;
	}

	public void setUno(Integer uno) {
		this.uno = uno;
	}	

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public OrderInfo(String ono, String odate, String ano, double total, Integer uno, String remark, int status) {
		super();
		this.ono = ono;
		this.odate = odate;
		this.ano = ano;
		this.total = total;
		this.uno = uno;
		this.remark = remark;
		this.status = status;
	}

	public OrderInfo() {
		super();
	}
	
}
