package com.data;

public class EmpTotal {
	
	private Integer basic;
	
	private Integer hra;

	public EmpTotal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpTotal(Integer basic, Integer hra) {
		super();
		this.basic = basic;
		this.hra = hra;
	}

	public Integer getBasic() {
		return basic;
	}

	public void setBasic(Integer basic) {
		this.basic = basic;
	}

	public Integer getHra() {
		return hra;
	}

	public void setHra(Integer hra) {
		this.hra = hra;
	}

	@Override
	public String toString() {
		return "EmpTotal [basic=" + basic + ", hra=" + hra + "]";
	}
	
	
	
	
	
	
	
	

}
