package com.chary.shopping.bean;


public class GoodsType  {

	private Integer tno;
	private String tname;
	private Integer status;
	
	@Override
	public String toString() {
		return "GoodsType [tno=" + tno + ", tname=" + tname + ", status=" + status + "]";
	}

	public GoodsType(Integer tno, String tname, Integer status) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.status = status;
	}

	public GoodsType() {
		super();
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tname == null) ? 0 : tname.hashCode());
		result = prime * result + ((tno == null) ? 0 : tno.hashCode());
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
		GoodsType other = (GoodsType) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tname == null) {
			if (other.tname != null)
				return false;
		} else if (!tname.equals(other.tname))
			return false;
		if (tno == null) {
			if (other.tno != null)
				return false;
		} else if (!tno.equals(other.tno))
			return false;
		return true;
	}

	public Integer getTno() {
		return tno;
	}

	public void setTno(Integer tno) {
		this.tno = tno;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
