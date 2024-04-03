package com.test;

public class EmpDto {
	
	public String EnpName;
	public String pan;
	public String aadharNumber;
	public int uan;
	public String currentMonth;
	public String dateofJoining;
	public long bankAccountNo;
	public String bankName;
	public String ifsc;

	
	public int payableDay;
	
	public int wokingday;
	public int basic;
	public int hra;
	public int bonus;
	public int athorAllowncanes;
	public int cca;
	public int leaveAllowances;
	public int conveyanceAllowance;
	public int fixedIncentive;
	public int Incentive;
	public int grossTaxableSalary;
	public int employerEPFContribution;
	public int employerESIContribution;
	public int retiralBenefits;
	public int totalMonthly;
	public int arrearPayableofEarlierMonth;
	public int totalStatutoryDeductions;
	public int totalOtherDeductions;
	public int totalPayable;
	
	public int arrearPaid;
	public int medicalAllownces;
	public int loan ;
	public int advance;
	public int examfee;
	public int tds;
	public int other;

	
	public EmpDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EmpDto(String enpName, String pan, String aadharNumber, int uan, String currentMonth, String dateofJoining,
			long bankAccountNo, String bankName, String ifsc, int payableDay, int wokingday, int basic, int hra,
			int bonus, int athorAllowncanes, int cca, int leaveAllowances, int conveyanceAllowance, int fixedIncentive,
			int incentive, int grossTaxableSalary, int employerEPFContribution, int employerESIContribution,
			int retiralBenefits, int totalMonthly, int arrearPayableofEarlierMonth, int totalStatutoryDeductions,
			int totalOtherDeductions, int totalPayable, int arrearPaid, int medicalAllownces, int loan, int advance,
			int examfee, int tds, int other) {
		super();
		EnpName = enpName;
		this.pan = pan;
		this.aadharNumber = aadharNumber;
		this.uan = uan;
		this.currentMonth = currentMonth;
		this.dateofJoining = dateofJoining;
		this.bankAccountNo = bankAccountNo;
		this.bankName = bankName;
		this.ifsc = ifsc;
		this.payableDay = payableDay;
		this.wokingday = wokingday;
		this.basic = basic;
		this.hra = hra;
		this.bonus = bonus;
		this.athorAllowncanes = athorAllowncanes;
		this.cca = cca;
		this.leaveAllowances = leaveAllowances;
		this.conveyanceAllowance = conveyanceAllowance;
		this.fixedIncentive = fixedIncentive;
		Incentive = incentive;
		this.grossTaxableSalary = grossTaxableSalary;
		this.employerEPFContribution = employerEPFContribution;
		this.employerESIContribution = employerESIContribution;
		this.retiralBenefits = retiralBenefits;
		this.totalMonthly = totalMonthly;
		this.arrearPayableofEarlierMonth = arrearPayableofEarlierMonth;
		this.totalStatutoryDeductions = totalStatutoryDeductions;
		this.totalOtherDeductions = totalOtherDeductions;
		this.totalPayable = totalPayable;
		this.arrearPaid = arrearPaid;
		this.medicalAllownces = medicalAllownces;
		this.loan = loan;
		this.advance = advance;
		this.examfee = examfee;
		this.tds = tds;
		this.other = other;
	}


	public String getEnpName() {
		return EnpName;
	}


	public void setEnpName(String enpName) {
		EnpName = enpName;
	}


	public String getPan() {
		return pan;
	}


	public void setPan(String pan) {
		this.pan = pan;
	}


	public String getAadharNumber() {
		return aadharNumber;
	}


	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}


	public int getUan() {
		return uan;
	}


	public void setUan(int uan) {
		this.uan = uan;
	}


	public String getCurrentMonth() {
		return currentMonth;
	}


	public void setCurrentMonth(String currentMonth) {
		this.currentMonth = currentMonth;
	}


	public String getDateofJoining() {
		return dateofJoining;
	}


	public void setDateofJoining(String dateofJoining) {
		this.dateofJoining = dateofJoining;
	}


	public long getBankAccountNo() {
		return bankAccountNo;
	}


	public void setBankAccountNo(long bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public String getIfsc() {
		return ifsc;
	}


	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}


	public int getPayableDay() {
		return payableDay;
	}


	public void setPayableDay(int payableDay) {
		this.payableDay = payableDay;
	}


	public int getWokingday() {
		return wokingday;
	}


	public void setWokingday(int wokingday) {
		this.wokingday = wokingday;
	}


	public int getBasic() {
		return basic;
	}


	public void setBasic(int basic) {
		this.basic = basic;
	}


	public int getHra() {
		return hra;
	}


	public void setHra(int hra) {
		this.hra = hra;
	}


	public int getBonus() {
		return bonus;
	}


	public void setBonus(int bonus) {
		this.bonus = bonus;
	}


	public int getAthorAllowncanes() {
		return athorAllowncanes;
	}


	public void setAthorAllowncanes(int athorAllowncanes) {
		this.athorAllowncanes = athorAllowncanes;
	}


	public int getCca() {
		return cca;
	}


	public void setCca(int cca) {
		this.cca = cca;
	}


	public int getLeaveAllowances() {
		return leaveAllowances;
	}


	public void setLeaveAllowances(int leaveAllowances) {
		this.leaveAllowances = leaveAllowances;
	}


	public int getConveyanceAllowance() {
		return conveyanceAllowance;
	}


	public void setConveyanceAllowance(int conveyanceAllowance) {
		this.conveyanceAllowance = conveyanceAllowance;
	}


	public int getFixedIncentive() {
		return fixedIncentive;
	}


	public void setFixedIncentive(int fixedIncentive) {
		this.fixedIncentive = fixedIncentive;
	}


	public int getIncentive() {
		return Incentive;
	}


	public void setIncentive(int incentive) {
		Incentive = incentive;
	}


	public int getGrossTaxableSalary() {
		return grossTaxableSalary;
	}


	public void setGrossTaxableSalary(int grossTaxableSalary) {
		this.grossTaxableSalary = grossTaxableSalary;
	}


	public int getEmployerEPFContribution() {
		return employerEPFContribution;
	}


	public void setEmployerEPFContribution(int employerEPFContribution) {
		this.employerEPFContribution = employerEPFContribution;
	}


	public int getEmployerESIContribution() {
		return employerESIContribution;
	}


	public void setEmployerESIContribution(int employerESIContribution) {
		this.employerESIContribution = employerESIContribution;
	}


	public int getRetiralBenefits() {
		return retiralBenefits;
	}


	public void setRetiralBenefits(int retiralBenefits) {
		this.retiralBenefits = retiralBenefits;
	}


	public int getTotalMonthly() {
		return totalMonthly;
	}


	public void setTotalMonthly(int totalMonthly) {
		this.totalMonthly = totalMonthly;
	}


	public int getArrearPayableofEarlierMonth() {
		return arrearPayableofEarlierMonth;
	}


	public void setArrearPayableofEarlierMonth(int arrearPayableofEarlierMonth) {
		this.arrearPayableofEarlierMonth = arrearPayableofEarlierMonth;
	}


	public int getTotalStatutoryDeductions() {
		return totalStatutoryDeductions;
	}


	public void setTotalStatutoryDeductions(int totalStatutoryDeductions) {
		this.totalStatutoryDeductions = totalStatutoryDeductions;
	}


	public int getTotalOtherDeductions() {
		return totalOtherDeductions;
	}


	public void setTotalOtherDeductions(int totalOtherDeductions) {
		this.totalOtherDeductions = totalOtherDeductions;
	}


	public int getTotalPayable() {
		return totalPayable;
	}


	public void setTotalPayable(int totalPayable) {
		this.totalPayable = totalPayable;
	}


	public int getArrearPaid() {
		return arrearPaid;
	}


	public void setArrearPaid(int arrearPaid) {
		this.arrearPaid = arrearPaid;
	}


	public int getMedicalAllownces() {
		return medicalAllownces;
	}


	public void setMedicalAllownces(int medicalAllownces) {
		this.medicalAllownces = medicalAllownces;
	}


	public int getLoan() {
		return loan;
	}


	public void setLoan(int loan) {
		this.loan = loan;
	}


	public int getAdvance() {
		return advance;
	}


	public void setAdvance(int advance) {
		this.advance = advance;
	}


	public int getExamfee() {
		return examfee;
	}


	public void setExamfee(int examfee) {
		this.examfee = examfee;
	}


	public int getTds() {
		return tds;
	}


	public void setTds(int tds) {
		this.tds = tds;
	}


	public int getOther() {
		return other;
	}


	public void setOther(int other) {
		this.other = other;
	}


	@Override
	public String toString() {
		return "EmpDto [EnpName=" + EnpName + ", pan=" + pan + ", aadharNumber=" + aadharNumber + ", uan=" + uan
				+ ", currentMonth=" + currentMonth + ", dateofJoining=" + dateofJoining + ", bankAccountNo="
				+ bankAccountNo + ", bankName=" + bankName + ", ifsc=" + ifsc + ", payableDay=" + payableDay
				+ ", wokingday=" + wokingday + ", basic=" + basic + ", hra=" + hra + ", bonus=" + bonus
				+ ", athorAllowncanes=" + athorAllowncanes + ", cca=" + cca + ", leaveAllowances=" + leaveAllowances
				+ ", conveyanceAllowance=" + conveyanceAllowance + ", fixedIncentive=" + fixedIncentive + ", Incentive="
				+ Incentive + ", grossTaxableSalary=" + grossTaxableSalary + ", employerEPFContribution="
				+ employerEPFContribution + ", employerESIContribution=" + employerESIContribution
				+ ", retiralBenefits=" + retiralBenefits + ", totalMonthly=" + totalMonthly
				+ ", arrearPayableofEarlierMonth=" + arrearPayableofEarlierMonth + ", totalStatutoryDeductions="
				+ totalStatutoryDeductions + ", totalOtherDeductions=" + totalOtherDeductions + ", totalPayable="
				+ totalPayable + ", arrearPaid=" + arrearPaid + ", medicalAllownces=" + medicalAllownces + ", loan="
				+ loan + ", advance=" + advance + ", examfee=" + examfee + ", tds=" + tds + ", other=" + other + "]";
	}
	
	
	
	
	
	
	
	
	

}
