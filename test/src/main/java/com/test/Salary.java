package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.poi.hpsf.Array;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.tools.javac.util.List;

public class Salary {
	private static final Logger log = Logger.getLogger(Salary.class.getName());
	
	static Test config=new Test();

	
	
	public static void salary() {
		
		String cal1File=config.getProperty("cal1");
		
		try {
            
            FileInputStream file = new FileInputStream(new File(cal1File));
           


           
            Workbook workbook = new XSSFWorkbook(file);


           
            Sheet sheet = workbook.getSheetAt(0);


          
            Map<Long, EmpDto> employee = new LinkedHashMap<>();
            
           
           
            for(int i = 1; i <= 1; i++) {
            	Row row = sheet.getRow(i);
         

            	

            	String[] arr= {"EmpCode","EmpName","MonthDays"};
            	
            	
            	for(int j=0;j<=2;j++) {
            		Cell head=row.getCell(j);
            		String h=head.getStringCellValue();
            		if(arr[j].equals(h)) {
            			log.info("headers are equals");
            			
            		}
            		else {
            			log.info("headers are not equals");
            			break;
            		}
            	}

            }
            
            
           

            for (int i = 2; i <= sheet.getLastRowNum(); i++) {
            	
                Row row = sheet.getRow(i);
                Cell empCode=row.getCell(0);

                Cell payDays = row.getCell(5); 
                Cell basic = row.getCell(32); 
                Cell hra=row.getCell(33);
                Cell cca=row.getCell(34);
                Cell ca=row.getCell(35);
                Cell bonus=row.getCell(36);
                Cell lta=row.getCell(37);
                Cell fixedIncentive=row.getCell(38);
                Cell otherAllowances=row.getCell(39);
                
                Cell empEpfContribution=row.getCell(43);
              
                Cell empEsiContribution=row.getCell(44);
               
                Cell retiralBenefits=row.getCell(45);
              
                
               
                Cell month=row.getCell(2);
                
                
             
                Cell cmonth=row.getCell(14);
                
               
                Cell pan=row.getCell(15);
                
              
                Cell adhar=row.getCell(16);

                
                
                Cell una=row.getCell(21);
               
                
                Cell dateOfJoining=row.getCell(14);
                
              
                Cell bankAccountNo=row.getCell(23);
                
             
                Cell bankName=row.getCell(22);
              
                
                Cell ifsc=row.getCell(24);
               
              
                Cell mediAllownces=row.getCell(72);
               
                
                Cell loan =row.getCell(73);
                
                
                Cell advance=row.getCell(74);
               
                
                Cell examfee=row.getCell(75);
               
                
                Cell other=row.getCell(76);
               
                
                Cell tds = row.getCell(77);
                
                
               
                Cell name=row.getCell(1);
                
              
                Cell arrearPayableofEarlierMonth=row.getCell(81);
                
                
                Cell arrearPaid=row.getCell(82);
                
                
               
                
                
                int value=(int)empCode.getNumericCellValue();
                
                if (payDays != null && basic != null) {
                	 int id=0;
                	 long empid=0;
                	 int abc=0;
                	 int paysDay = 0;
                	 int basic1=0;
                	 int hra1=0;
                	 int cca1=0;
                	 int ca1 = 0;
                	 int bonus1 = 0;
                	 int lta1 = 0;
                	 int fixedIncentive1 = 0;
                	 int otherAllowances1 = 0;
                	 int totalGrossBeforeTaxable = 0;
                	 int empEpfContribution1 = 0;
                	 int empEsiContribution1 = 0;
                	 int retiralBenefits1 = 0;
                	 int grossTaxableSalary1=0;
                	 int totalMonthly=0;
                	 int totalStatutoryDeductions=0;
                	 int totalPayable=0;
                	 int month1=0;
                	 Date cm;
                	 String pan1=null;
                	 String adhar1=null;
                	 int una1=0;
                	 Date dateJoining;
                	 long bankAccountNo1=0;
                	 String bankName1=null;
                	 String ifsc1 = null;
                	 int mediAllownces1=0;
                	 int loan1=0;
                	 int advance1=0;
                	 int examfee1=0;
                	 int tds1=0;
                	 int other1=0;
                	 int totalOtherDeductions=0;
                	 int arrearPayableofEarlierMonth1=0;
                	 int arrearPaid1=0;
                	 String name1 = null;
                	 String formattedDate1=null;
                	 String formattedDate=null;
                	 
                	 
                	
                	 try {
                		 
                		
                	  cm=cmonth.getDateCellValue();
                		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                		  formattedDate = sdf.format(cm); 

                		 
                		
                		 name1=name.getStringCellValue();
                		 
                		
                		 pan1=pan.getStringCellValue();
                		 
                		 try {
                			 adhar1= adhar.getStringCellValue();
                		 }catch(Exception e){

                			 log.info("is misamtch type"+e.getMessage());
                		 }
                		 
                		

                		 
                		if(una==null) {
                			una1=0;
                		}else {
                		 una1=(int)una.getNumericCellValue();
                		}
                		 
                		
                		 dateJoining=dateOfJoining.getDateCellValue();
                   		 SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                   		  formattedDate1 = sdf.format(dateJoining); 

                		 
                		
                   		bankAccountNo1=(long) bankAccountNo.getNumericCellValue();
                   		
                   		
                   		bankName1=bankName.getStringCellValue();
                   		
                   		
                   		ifsc1=ifsc.getStringCellValue();
                   		
                   		if(mediAllownces==null) {

                   			mediAllownces1=0;
                   		}else {
                   			mediAllownces1=(int)mediAllownces.getNumericCellValue();
                   		}
                   		
                   		loan1=(int)loan.getNumericCellValue();
                   		advance1=(int) advance.getNumericCellValue();
                   		examfee1=(int)examfee.getNumericCellValue();
                   		tds1=(int) tds.getNumericCellValue();
                   		other1=(int) other.getNumericCellValue();
                   		
                   		
                   		arrearPayableofEarlierMonth1=(int)arrearPayableofEarlierMonth.getNumericCellValue();
                   		
                   		arrearPaid1=(int) arrearPaid.getNumericCellValue();
                   		
                  

                   		
                   		
                   		
                	   id=(int)empCode.getNumericCellValue();

                	   
                       paysDay = (int) payDays.getNumericCellValue();
                      
                       basic1=(int) basic.getNumericCellValue();  
                       hra1=(int)hra.getNumericCellValue();
                       cca1=(int)cca.getNumericCellValue();
                       ca1=(int)ca.getNumericCellValue();
                       bonus1=(int)bonus.getNumericCellValue();
                       lta1=(int)lta.getNumericCellValue();
                       fixedIncentive1=(int)fixedIncentive.getNumericCellValue();
                       otherAllowances1=(int)otherAllowances.getNumericCellValue();
                      
                       totalGrossBeforeTaxable=basic1+hra1+cca1+ca1+bonus1+lta1+fixedIncentive1+otherAllowances1;
                       empEpfContribution1=(int)empEpfContribution.getNumericCellValue();
                       empEsiContribution1=(int)empEsiContribution.getNumericCellValue();
                       retiralBenefits1=(int)retiralBenefits.getNumericCellValue();
                        
                       month1=(int)month.getNumericCellValue();
                       totalMonthly=totalGrossBeforeTaxable+empEpfContribution1+empEsiContribution1+retiralBenefits1;
                       totalStatutoryDeductions=empEpfContribution1+empEpfContribution1+empEsiContribution1+empEsiContribution1;
                    
                       totalOtherDeductions=mediAllownces1+loan1+advance1+tds1+examfee1+other1;
                       
                       totalPayable=((totalMonthly/month1)*paysDay)-empEpfContribution1-empEpfContribution1-empEsiContribution1-empEsiContribution1-totalOtherDeductions;
                       
                 	 
                       
                	 }
                	 catch(Exception e) {
                		 
                		 log.info("mismatch"+e.getMessage());
                	 }
                	 if(id==0) {

                		 continue;
                	 }
                	

                	 
					employee.put((long) id , new EmpDto(name1,pan1,adhar1,una1,formattedDate,formattedDate1,bankAccountNo1,bankName1,ifsc1,
                    		paysDay,  month1,basic1,  hra1,  bonus1,  otherAllowances1,  cca1,  lta1,
                    		ca1,  fixedIncentive1,  otherAllowances1,  totalGrossBeforeTaxable,
                    		empEpfContribution1,  empEsiContribution1,  retiralBenefits1, totalMonthly ,
                    		arrearPayableofEarlierMonth1,  totalStatutoryDeductions, totalOtherDeductions ,  totalPayable,arrearPaid1,
                    		mediAllownces1,loan1,advance1,examfee1,tds1,other1
                    		));
                    
                }
            }

           
            for (Map.Entry<Long, EmpDto> entry : employee.entrySet()) {
                Long employeeId = entry.getKey();
                EmpDto payableDays = entry.getValue();
            }
            System.out.println(employee);
            
            
            
            write(employee);
            

            
            workbook.close();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public static void write(Map<Long,EmpDto> employeePayable) {
		 // Create a new workbook
       try (Workbook workbook = new XSSFWorkbook()) {
           Sheet sheet = workbook.createSheet("Data");
           
           
           Row headerRow = sheet.createRow(1);
           headerRow.createCell(0).setCellValue("EmpCode");
           headerRow.createCell(1).setCellValue("EmpName");
           headerRow.createCell(2).setCellValue("PAN No.");
           headerRow.createCell(3).setCellValue("Aadhar No.");
           headerRow.createCell(4).setCellValue("UNA No.");
           headerRow.createCell(5).setCellValue("Current Month");
           headerRow.createCell(6).setCellValue("Date Of Joining");
           headerRow.createCell(7).setCellValue("Bank Account No.");
           headerRow.createCell(8).setCellValue("Bank Name");
           headerRow.createCell(9).setCellValue("IFSC");
         
           headerRow.createCell(10).setCellValue("PayableDays");
           headerRow.createCell(11).setCellValue("Working Day");
           headerRow.createCell(12).setCellValue("Basic");
           headerRow.createCell(13).setCellValue("HRA");
           headerRow.createCell(14).setCellValue("Bonus");
           headerRow.createCell(15).setCellValue("Other Allowance");
           headerRow.createCell(16).setCellValue("Leave Travel Allowance");
           headerRow.createCell(17).setCellValue("Conveyance Allowance");
           headerRow.createCell(18).setCellValue("Fixed Incentive");
           headerRow.createCell(19).setCellValue("Incentive / Variable");
           headerRow.createCell(20).setCellValue("Gross Taxable Salary");
           headerRow.createCell(21).setCellValue("Employer EPF Contribution");
           headerRow.createCell(22).setCellValue("Employer ESI Contribution");
           headerRow.createCell(23).setCellValue("Retiral Benefits");
           headerRow.createCell(24).setCellValue("Total Monthly CTC (A)");
           headerRow.createCell(25).setCellValue("Arrear Payable of Earlier Month");
           headerRow.createCell(26).setCellValue("Employer EPF Contribution");
           headerRow.createCell(27).setCellValue("Employer ESI Contribution");
           headerRow.createCell(28).setCellValue("Total Statutory Deductions (B)");
           headerRow.createCell(29).setCellValue("Medical Insurance");
           headerRow.createCell(30).setCellValue("Loan Deduction");
           headerRow.createCell(31).setCellValue("Advance");
           headerRow.createCell(32).setCellValue("Exam Fee");
           headerRow.createCell(33).setCellValue("TDS");
           headerRow.createCell(34).setCellValue("Other");
           headerRow.createCell(35).setCellValue("Total Other Deductions (C)");
           headerRow.createCell(36).setCellValue("Arrear Paid");
           headerRow.createCell(37).setCellValue("Net Payable for the Month (A -B-C)");
           
           
           
           
           

          
           int rowNum = 2;
           for (Map.Entry<Long, EmpDto> entry : employeePayable.entrySet()) {
               Row row = sheet.createRow(rowNum++);
               
               

               
               
               EmpDto emp = entry.getValue();
              
               row.createCell(0).setCellValue(entry.getKey()); 

             
               
               row.createCell(1).setCellValue(emp.getEnpName());
               row.createCell(2).setCellValue(emp.getPan());
               row.createCell(3).setCellValue(emp.getAadharNumber());
               row.createCell(4).setCellValue(emp.getUan());
               row.createCell(5).setCellValue(emp.getCurrentMonth());
               row.createCell(6).setCellValue(emp.getDateofJoining());
               row.createCell(7).setCellValue(emp.getBankAccountNo());
               row.createCell(8).setCellValue(emp.getBankName());
               row.createCell(9).setCellValue(emp.getIfsc());
               
               row.createCell(10).setCellValue(emp.getPayableDay());
               row.createCell(11).setCellValue(emp.getWokingday());
               
               row.createCell(12).setCellValue(emp.getBasic());
               row.createCell(13).setCellValue(emp.getHra());
               row.createCell(14).setCellValue(emp.getBonus());
               row.createCell(15).setCellValue(emp.getAthorAllowncanes());
               row.createCell(16).setCellValue(emp.getLeaveAllowances());
               row.createCell(17).setCellValue(emp.getConveyanceAllowance());
               row.createCell(18).setCellValue(emp.getFixedIncentive());
               row.createCell(19).setCellValue(emp.getIncentive());
               row.createCell(20).setCellValue(emp.getGrossTaxableSalary());
               row.createCell(21).setCellValue(emp.getEmployerEPFContribution());
               row.createCell(22).setCellValue(emp.getEmployerESIContribution());
               row.createCell(23).setCellValue(emp.getRetiralBenefits());
               row.createCell(24).setCellValue(emp.getTotalMonthly());
               row.createCell(25).setCellValue(emp.getArrearPayableofEarlierMonth());
               row.createCell(26).setCellValue(emp.getEmployerEPFContribution());
               row.createCell(27).setCellValue(emp.getEmployerESIContribution());
               row.createCell(28).setCellValue(emp.getTotalStatutoryDeductions());
               row.createCell(29).setCellValue(emp.getMedicalAllownces());
               row.createCell(30).setCellValue(emp.getLoan());
               row.createCell(31).setCellValue(emp.getAdvance());
               row.createCell(32).setCellValue(emp.getExamfee());
               row.createCell(33).setCellValue(emp.getTds());
               row.createCell(34).setCellValue(emp.getOther());
               row.createCell(35).setCellValue(emp.getTotalOtherDeductions());
               row.createCell(36).setCellValue(emp.getArrearPaid());
               row.createCell(37).setCellValue(emp.getTotalPayable());
  
               
           }
           
           
           
           String outputFile=config.getProperty("EmpSalary");
          
           try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
               workbook.write(outputStream);
           }



           
           log.info("Salary Excel file has been created successfully.");
       } catch (IOException e) {
    	   log.info("error at writing excel file"+e.getMessage());
       }
	}

}
