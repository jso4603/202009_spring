package com.myboard.dto;

import java.util.Date;

public class MemberDTO {
	private String userid;
	private String passwd;
	private String email;
	private String name;
	private String zipcode;
	private String addr1;
	private String addr2;
	private String filename;
	private int joinflag; // 0: 일반, 1: 네이버, 2: 구글, 3: 카카오 
	private Date regdate;
	
	public MemberDTO() {
		super();
	}

	public MemberDTO(String userid, String passwd, String email, String name, String zipcode, String addr1,
			String addr2, String filename, int joinflag, Date regdate) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.email = email;
		this.name = name;
		this.zipcode = zipcode;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.filename = filename;
		this.joinflag = joinflag;
		this.regdate = regdate;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getJoinflag() {
		return joinflag;
	}

	public void setJoinflag(int joinflag) {
		this.joinflag = joinflag;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", passwd=" + passwd + ", email=" + email + ", name=" + name
				+ ", zipcode=" + zipcode + ", addr1=" + addr1 + ", addr2=" + addr2 + ", filename=" + filename
				+ ", joinflag=" + joinflag + ", regdate=" + regdate + "]";
	}
	
	
}
