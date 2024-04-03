package com.test;

public class Emp {
	
	private String name;
	private Integer Days;
	private Integer payableDays;
	private Integer TotalAttendance;
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(String name, Integer days, Integer payableDays, Integer totalAttendance) {
		super();
		this.name = name;
		Days = days;
		this.payableDays = payableDays;
		TotalAttendance = totalAttendance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDays() {
		return Days;
	}
	public void setDays(Integer days) {
		Days = days;
	}
	public Integer getPayableDays() {
		return payableDays;
	}
	public void setPayableDays(Integer payableDays) {
		this.payableDays = payableDays;
	}
	public Integer getTotalAttendance() {
		return TotalAttendance;
	}
	public void setTotalAttendance(Integer totalAttendance) {
		TotalAttendance = totalAttendance;
	}
	@Override
	public String toString() {
		return "Emp [name=" + name + ", Days=" + Days + ", payableDays=" + payableDays + ", TotalAttendance="
				+ TotalAttendance + "]";
	}
	
	
	
	
	
}
