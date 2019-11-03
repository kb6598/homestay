package com.homestay.korea.DTO;

public class TourImageDTO {
	int imageno;
	String imageurl;
	String contentid;
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
	public String getContentid() {
		return contentid;
	}
	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	@Override
	public String toString() {
		return "TourImageDTO [imageno=" + imageno + ", imageurl=" + imageurl + ", contentid=" + contentid + "]";
	}

	
	
}
