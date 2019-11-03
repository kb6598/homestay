package com.homestay.korea.DTO;
//when filed's value is null that means filed's value was not set
public class ThemePreferDTO {
	String id;
	Double tour_attr;
	Double cult_facil;
	Double event;
	Double shopping;
	Double leports;
	Double dining;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getTour_attr() {
		return tour_attr;
	}
	public void setTour_attr(Double tour_attr) {
		this.tour_attr = tour_attr;
	}
	public Double getCult_facil() {
		return cult_facil;
	}
	public void setCult_facil(Double cult_facil) {
		this.cult_facil = cult_facil;
	}
	public Double getEvent() {
		return event;
	}
	public void setEvent(Double event) {
		this.event = event;
	}
	public Double getShopping() {
		return shopping;
	}
	public void setShopping(Double shopping) {
		this.shopping = shopping;
	}
	public Double getLeports() {
		return leports;
	}
	public void setLeports(Double leports) {
		this.leports = leports;
	}
	public Double getDining() {	
		
		return dining;
	}

	public void setDining(Double dining) {
		this.dining = dining;
	}
	@Override
	public String toString() {
		return "Theme_preferDTO [id=" + id + ", tour_attr=" + tour_attr + ", cult_facil=" + cult_facil + ", event="
				+ event + ", shopping=" + shopping + ", leports=" + leports + ", dining=" + dining + "]";
	}


}
