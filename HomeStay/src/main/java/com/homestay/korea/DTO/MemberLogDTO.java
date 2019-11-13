package com.homestay.korea.DTO;

import java.sql.Timestamp;

public class MemberLogDTO {

	private int log_no;
	private String id;
	private String cotentId;
	private Timestamp log_time;
	
	public int getLog_no() {
		return log_no;
	}
	public void setLog_no(int log_no) {
		this.log_no = log_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContentId() {
		return cotentId;
	}
	public void setContentId(String cotentId) {
		this.cotentId = cotentId;
	}
	public Timestamp getLog_time() {
		return log_time;
	}
	public void setLog_time(Timestamp log_time) {
		this.log_time = log_time;
	}
}
