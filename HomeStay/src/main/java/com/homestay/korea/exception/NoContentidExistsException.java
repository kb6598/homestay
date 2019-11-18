package com.homestay.korea.exception;

public class NoContentidExistsException extends RuntimeException {
	
	private String contentId;
	
	public NoContentidExistsException(String whichContentid) {
		super();
		this.contentId = whichContentid;
		showSolution(contentId);
	}
	
	private void showSolution(String contentId) {
		System.out.println("=============================NoContentidExistsException=============================");
		System.out.println("place 혹은 place_detailData 혹은 tour_image테이블에 contentid("+contentId+")가 존재하지 않습니다.");
		System.out.println("====================================================================================");
	}
	
	
}
