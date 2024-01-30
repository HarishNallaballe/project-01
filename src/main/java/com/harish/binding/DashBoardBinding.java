package com.harish.binding;

public class DashBoardBinding {
	
	private Integer enquiries;
	private Integer enrolled;
	private Integer lost;
	public DashBoardBinding(Integer enquiries, Integer enrolled, Integer lost) {
		super();
		this.enquiries = enquiries;
		this.enrolled = enrolled;
		this.lost = lost;
	}
	public DashBoardBinding() {
		super();
	}
	@Override
	public String toString() {
		return "DashBoardBinding [enquiries=" + enquiries + ", enrolled=" + enrolled + ", lost=" + lost + "]";
	}
	public Integer getEnquiries() {
		return enquiries;
	}
	public void setEnquiries(Integer enquiries) {
		this.enquiries = enquiries;
	}
	public Integer getEnrolled() {
		return enrolled;
	}
	public void setEnrolled(Integer enrolled) {
		this.enrolled = enrolled;
	}
	public Integer getLost() {
		return lost;
	}
	public void setLost(Integer lost) {
		this.lost = lost;
	}
	
	
	

}
