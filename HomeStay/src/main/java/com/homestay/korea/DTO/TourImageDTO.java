package com.homestay.korea.DTO;

public class TourImageDTO {
	int imageNo;
	String imageUrl;
	String contentId2;
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
		return contentId2;
	}
	public void setContentId2(String contentId2) {
		this.contentId2 = contentId2;
	}
	@Override
	public String toString() {
		return "TourImageDTO [imageNo=" + imageNo + ", imageUrl=" + imageUrl + ", contentId2=" + contentId2 + "]";
	}

	
	
}
