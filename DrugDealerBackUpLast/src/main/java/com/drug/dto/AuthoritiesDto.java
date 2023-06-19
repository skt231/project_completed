package com.drug.dto;

public class AuthoritiesDto {
	
	private String id;
	private String authority;
	
	public AuthoritiesDto() {}
	
	public AuthoritiesDto(String id, String authority) {
		super();
		this.id = id;
		this.authority = authority;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	

}
