package org.spring.dto;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class MemberDTO {
	private String userid;
	private String passwd;
	private String email;
	public MemberDTO() {
		super();
	}
	public MemberDTO(String userid, String passwd, String email) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.email = email;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", passwd=" + passwd + ", email=" + email + "]";
	}
	
	
}
