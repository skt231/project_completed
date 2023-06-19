package com.drug.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class UsersDto {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	private String phone;
	private Integer useyn;
	private String authority;
	private Date regdate;
	
	
	public UsersDto() {}
	
	public UsersDto(String id, String pw, String name, String email, String address, String phone, Integer useyn,
			String authority, Date regdate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.useyn = useyn;
		this.authority = authority;
		this.regdate = regdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getUseyn() {
		return useyn;
	}

	public void setUseyn(Integer useyn) {
		this.useyn = useyn;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	

}