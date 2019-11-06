package com.homestay.korea.DTO;
//when filed's value is null that means filed's value was not set
public class ThemePreferDTO {
	String id;
	Integer tour_attr;
	Integer cult_facil;
	Integer event;
	Integer shopping;
	Integer leports;
	Integer dining;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getTour_attr() {
		return tour_attr;
	}
	public void setTour_attr(Integer tour_attr) {
		this.tour_attr = tour_attr;
	}
	public Integer getCult_facil() {
		return cult_facil;
	}
	public void setCult_facil(Integer cult_facil) {
		this.cult_facil = cult_facil;
	}
	public Integer getEvent() {
		return event;
	}
	public void setEvent(Integer event) {
		this.event = event;
	}
	public Integer getShopping() {
		return shopping;
	}
	public void setShopping(Integer shopping) {
		this.shopping = shopping;
	}
	public Integer getLeports() {
		return leports;
	}
	public void setLeports(Integer leports) {
		this.leports = leports;
	}
	public Integer getDining() {	
		
		return dining;
	}

	public void setDining(Integer dining) {
		this.dining = dining;
	}
	@Override
	public String toString() {
		return "Theme_preferDTO [id=" + id + ", tour_attr=" + tour_attr + ", cult_facil=" + cult_facil + ", event="
				+ event + ", shopping=" + shopping + ", leports=" + leports + ", dining=" + dining + "]";
	}


}
