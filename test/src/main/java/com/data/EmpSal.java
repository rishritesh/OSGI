package com.data;

public class EmpSal {
	
	
	private String name;
	private Integer totalCTC;
	private Integer monthDays;
	private Integer leave;
	private Integer payableDays;
	private Integer finalAmount;
	public EmpSal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpSal(String name, Integer totalCTC, Integer monthDays, Integer leave, Integer payableDays,
			Integer finalAmount) {
		super();
		
		this.name = name;
		this.totalCTC = totalCTC;
		this.monthDays = monthDays;
		this.leave = leave;
		this.payableDays = payableDays;
		this.finalAmount = finalAmount;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTotalCTC() {
		return totalCTC;
	}
	public void setTotalCTC(Integer totalCTC) {
		this.totalCTC = totalCTC;
	}
	public Integer getMonthDays() {
		return monthDays;
	}
	public void setMonthDays(Integer monthDays) {
		this.monthDays = monthDays;
	}
	public Integer getLeave() {
		return leave;
	}
	public void setLeave(Integer leave) {
		this.leave = leave;
	}
	public Integer getPayableDays() {
		return payableDays;
	}
	public void setPayableDays(Integer payableDays) {
		this.payableDays = payableDays;
	}
	public Integer getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(Integer finalAmount) {
		this.finalAmount = finalAmount;
	}
	@Override
	public String toString() {
		return "EmpSal [ name=" + name + ", totalCTC=" + totalCTC + ", monthDays=" + monthDays
				+ ", leave=" + leave + ", payableDays=" + payableDays + ", finalAmount=" + finalAmount + "]";
	}
	
	
	

}
