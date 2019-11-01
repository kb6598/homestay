package com.homestay.korea.DTO;

//made by seunghyun
public class MemberDTO {
	
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String age;
	private String phone;
	private String companion;
	private String regional;
	private long nation;
	
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCompanion() {
		return companion;
	}
	public void setCompanion(String companion) {
		this.companion = companion;
	}
	public String getRegional() {
		return regional;
	}
	public void setRegional(String regional) {
		this.regional = regional;
	}
	public long getNation() {
		return nation;
	}
	public void setNation(long nation) {
		this.nation = nation;
	}
	
	@Override
	public String toString() {
		return "id:" + id + ", pw:" + pw + ", name:" + name + ", gender:" + gender + ", age:" + age + ", phone:" + 
					phone + ", companion:" + companion + ", regional:" + regional + ", nation:" + nation;
	}
	
}



















