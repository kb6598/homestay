package com.homestay.korea.DTO;

public class TourImageDTO {
	int imageNo;
	String imageUrl;
	String contentId;
	public int getImageNo() {
		return imageNo;
	}
	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getContentId2() {
		return contentId;
	}
	public void setContentId2(String contentId) {
		this.contentId = contentId;
	}
	@Override
	public String toString() {
		return "TourImageDTO [imageNo=" + imageNo + ", imageUrl=" + imageUrl + ", contentId2=" + contentId2 + "]";
	}

	
	
}
