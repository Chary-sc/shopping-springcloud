package com.chary.shopping.dto;



/**
 * 对外用户信息（可只传输部分数据）
 * @ClassName: MemberInfoDTO
 * @Description:TODO
 * @author Chary
 * @date:  2021年10月22日 下午12:06:39	
 * @param:
 */
public class MemberInfoDTO {
	
	private Integer mno;		//用户编号
	private String nickName;	//用户昵称
	private String pwd;			//用户密码(md5加密)
	private String tel;			//电话号码
	private String email;		//电子邮件
	private Integer status;		//账号状态
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((mno == null) ? 0 : mno.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
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
		MemberInfoDTO other = (MemberInfoDTO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (mno == null) {
			if (other.mno != null)
				return false;
		} else if (!mno.equals(other.mno))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
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
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}


	public Integer getMno() {
		return mno;
	}


	public void setMno(Integer mno) {
		this.mno = mno;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
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


	@Override
	public String toString() {
		return "MemberInfo [mno=" + mno + ", nickName=" + nickName + ", pwd=" + pwd + ", tel=" + tel + ", email="
				+ email + ", status=" + status + "]";
	}


	public MemberInfoDTO(Integer mno, String nickName,  String pwd, String tel, String email,
			Integer status) {
		super();
		this.mno = mno;
		this.nickName = nickName;
		this.pwd = pwd;
		this.tel = tel;
		this.email = email;
		this.status = status;
	}


	public MemberInfoDTO() {
		super();
	}
	
    
}
