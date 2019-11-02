package com.homestay.korea.DTO;
//when filed's value is null that means filed's value was not set
public class PlaceDTO {
	private String contentid;
	private String createdtime;
	private String modifiedtime;
	private String theme;
	private long count;
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
	public long getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "PlaceDTO [contentid=" + contentid + ", createdtime=" + createdtime + ", modifiedtime=" + modifiedtime
				+ ", theme=" + theme + ", count=" + count + "]";
	}


}
