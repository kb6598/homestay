package com.homestay.korea.DTO;

public class JoinPlaceTourImage {
	
	private String contentid;
	private String createdtime;
	private String modifiedtime;
	private String theme;
	private String location;
	private long count;
	private int imageno;
	private String imageurl;
	
	
	public String getContentid() {
		return contentid;
	}
	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	public String getCreatedtime() {
		return createdtime;
	}
	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}
	public String getModifiedtime() {
		return modifiedtime;
	}
	public void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public int getImageno() {
		return imageno;
	}
	public void setImageno(int imageno) {
		this.imageno = imageno;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	@Override
	public String toString() {
		return "JoinPlaceTourImage [contentid=" + contentid + ", createdtime=" + createdtime + ", modifiedtime="
				+ modifiedtime + ", theme=" + theme + ", location=" + location + ", count=" + count + ", imageno="
				+ imageno + ", imageurl=" + imageurl + "]";
	}
	

}
