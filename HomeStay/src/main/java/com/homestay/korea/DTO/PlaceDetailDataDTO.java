package com.homestay.korea.DTO;
//when filed's value is null that means filed's value was not set
public class PlaceDetailDataDTO {
	int cotent_no;
	String content_category;
	String content;
	String contentid;
	public int getCotent_no() {
		return cotent_no;
	}
	public void setCotent_no(int cotent_no) {
		this.cotent_no = cotent_no;
	}
	public String getContent_category() {
		return content_category;
	}
	public void setContent_category(String content_category) {
		this.content_category = content_category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContentid() {
		return contentid;
	}
	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	@Override
	public String toString() {
		return "PlaceDetailDataDTO [cotent_no=" + cotent_no + ", content_category=" + content_category + ", content="
				+ content + ", contentid=" + contentid + "]";
	}





}
