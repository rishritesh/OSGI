package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class Calculation {
	private static final Logger log = Logger.getLogger(Calculation.class.getName());
	
	static Test config=new Test();
	
	
	public static void main(String[] args) {
		
		String Inputfile = config.getProperty("salary");
		
		try {
			
			
            FileInputStream file = new FileInputStream(Inputfile);
           


          
            Workbook workbook = new XSSFWorkbook(file);


            
            Sheet sheet = workbook.getSheetAt(0);


            
            Map<Long, Emp> employeePayableDays = new LinkedHashMap<>();
          
            
            

            for (int i = 2; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Cell name=row.getCell(0);
                Cell idCell = row.getCell(1); 
                Cell daysCell = row.getCell(11); 
                Cell days=row.getCell(2);

                
                
                if (idCell != null && daysCell != null) {
                    Long employeeId = (long) idCell.getNumericCellValue();
                    
                    int day= (int)days.getNumericCellValue();
                    
                    String EmpName=name.getStringCellValue();
                   
                    int payableDays = 0;

                    try {
                   
                       payableDays = (int) (daysCell.getNumericCellValue());

                       
                    }catch(Exception e) {
                    
                    }
                       
                       
                       

                   
                    employeePayableDays.put(employeeId, new Emp(EmpName,day,payableDays-day,payableDays));
                    
                }
            }

            // Perform calculation for each employee
            for (Map.Entry<Long, Emp> entry : employeePayableDays.entrySet()) {
                Long employeeId = entry.getKey();
                Emp payableDays = entry.getValue();
            }
  
            
            
            
            write(employeePayableDays);
            

          
            workbook.close();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

		Salary.salary();
	}
	
	public static void write(Map<Long,Emp> employeePayable) {
	
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Data");
            
            
            Row headerRow = sheet.createRow(1);
            headerRow.createCell(0).setCellValue("EmpCode");
            headerRow.createCell(1).setCellValue("EmpName");
            headerRow.createCell(2).setCellValue("MonthDays");
            headerRow.createCell(3).setCellValue("BalanceDays");
            headerRow.createCell(4).setCellValue("TotalAttendance");
            headerRow.createCell(5).setCellValue("DaysAmoutPay");
            
            
            
            

          
            int rowNum = 2;
            for (Map.Entry<Long, Emp> entry : employeePayable.entrySet()) {
                Row row = sheet.createRow(rowNum++);
                
                
                row.createCell(0).setCellValue(entry.getKey()); 

                
                
                Emp emp = entry.getValue();
               

                row.createCell(1).setCellValue(emp.getName());
                row.createCell(2).setCellValue(emp.getDays());
               row.createCell(3).setCellValue(emp.getPayableDays());
               row.createCell(4).setCellValue(emp.getTotalAttendance());
               
               
               Cell month=row.getCell(2);
               Cell day1=row.getCell(4);
               int data=(int)day1.getNumericCellValue();
              int days=(int)month.getNumericCellValue();
              
              boolean val=data>days;
              if(data>days) {
            	  row.createCell(5).setCellValue(days);
              }
              else {
            	  row.createCell(5).setCellValue(data);
              }
               
            }

            String cal=config.getProperty("cal");
          
            try (FileOutputStream outputStream = new FileOutputStream(cal)) {
                workbook.write(outputStream);
            }

            log.info("Excel file has been created successfully.");
            
        } catch (IOException e) {
        	log.info("Error at writing of cal file."+e.getMessage());
        }
        
        
	}
	
	
	

}
