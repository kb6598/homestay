package com.homestay.korea.DTO;
//when filed's value is null that means filed's value was not set
public class ThemePreferDTO {
	String id;
	int tour_attr;
	int cult_facil;
	int event;
	int shopping;
	int leports;
	int dining;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}	
	public int getTour_attr() {
		return tour_attr;
	}
	public void setTour_attr(int tour_attr) {
		this.tour_attr = tour_attr;
	}
	public int getCult_facil() {
		return cult_facil;
	}
	public void setCult_facil(int cult_facil) {
		this.cult_facil = cult_facil;
	}
	public int getEvent() {
		return event;
	}
	public void setEvent(int event) {
		this.event = event;
	}
	public int getShopping() {
		return shopping;
	}
	public void setShopping(int shopping) {
		this.shopping = shopping;
	}
	public int getLeports() {
		return leports;
	}
	public void setLeports(int leports) {
		this.leports = leports;
	}
	public int getDining() {
		return dining;
	}
	public void setDining(int dining) {
		this.dining = dining;
	}
	@Override
	public String toString() {
		return "Theme_preferDTO [id=" + id + ", tour_attr=" + tour_attr + ", cult_facil=" + cult_facil + ", event="
				+ event + ", shopping=" + shopping + ", leports=" + leports + ", dining=" + dining + "]";
	}


}
