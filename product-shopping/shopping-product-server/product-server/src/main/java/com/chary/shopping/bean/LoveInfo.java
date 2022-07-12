package com.chary.shopping.bean;

public class LoveInfo {

	private Integer lno;
	private Integer uno;
	private Integer gno;
	private Integer num;
	private Double price;

	@Override
	public String toString() {
		return "CartInfo [lno=" + lno + ", uno=" + uno + ", gno=" + gno + ", num=" + num + ", price=" + price + "]";
	}

	public LoveInfo(Integer lno, Integer uno, Integer gno, Integer num, Double price) {
		super();
		this.lno = lno;
		this.uno = uno;
		this.gno = gno;
		this.num = num;
		this.price = price;
	}

	public LoveInfo() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lno == null) ? 0 : lno.hashCode());
		result = prime * result + ((gno == null) ? 0 : gno.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		LoveInfo other = (LoveInfo) obj;
		if (lno == null) {
			if (other.lno != null)
				return false;
		} else if (!lno.equals(other.lno))
			return false;
		if (gno == null) {
			if (other.gno != null)
				return false;
		} else if (!gno.equals(other.gno))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (uno == null) {
			if (other.uno != null)
				return false;
		} else if (!uno.equals(other.uno))
			return false;
		return true;
	}

	public Integer getLno() {
		return lno;
	}

	public void setLno(Integer lno) {
		this.lno = lno;
	}

	public Integer getUno() {
		return uno;
	}

	public void setUno(Integer uno) {
		this.uno = uno;
	}

	public Integer getGno() {
		return gno;
	}

	public void setGno(Integer gno) {
		this.gno = gno;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
}
