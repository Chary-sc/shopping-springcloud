package com.chary.shopping.bean;

import java.io.Serializable;

public class UserInfo implements Serializable{
	
	private static final long serialVersionUID = -7138100358777570080L;

	private Integer uno;
	private String email;		
	private String pwd;			
	private Integer status;
	
	@Override
	public String toString() {
		return "UserInfo [uno=" + uno + ", pwd=" + pwd + ", email=" + email + ", status="
				+ status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		UserInfo other = (UserInfo) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (uno == null) {
			if (other.uno != null)
				return false;
		} else if (!uno.equals(other.uno))
			return false;
		return true;
	}

	public UserInfo(Integer uno, String pwd, String email, Integer status) {
		super();
		this.uno = uno;
		this.pwd = pwd;
		this.email = email;
		this.status = status;
	}

	public UserInfo() {
		super();
	}

	public Integer getUno() {
		return uno;
	}

	public void setUno(Integer uno) {
		this.uno = uno;
	}

	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}		
	
	
	
	
	
}
