package com.homestay.korea.DTO;

public class CountryDTO {
	int id;
	String cname;
	String dial_code;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getDial_code() {
		return dial_code;
	}
	public void setDial_code(String dial_code) {
		this.dial_code = dial_code;
	}
	@Override
	public String toString() {	
		return "id:" + id + ", cname:" + cname + ", dial_code:" + dial_code;
	}
}
