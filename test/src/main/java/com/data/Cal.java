package com.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Cal {
	public static void main(String[] args) {
		
		try {
            // Provide the path to your Excel file
            FileInputStream file = new FileInputStream(new File("/home/noida/Desktop/xl_file/data/cal.xlsx"));

            // Create Workbook instance for XLSX file
            Workbook workbook = new XSSFWorkbook(file);

            // Get the first sheet in the workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Map to store employee ID and corresponding payable days
            Map<Long, EmpSal> employeePayableDays = new LinkedHashMap<>();
            
            int month=29;

            for (int i = 2; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Cell name=row.getCell(6);
                Cell idCell = row.getCell(5); // Assuming Employee ID is in the first column
                Cell daysCell = row.getCell(41); // Assuming Payable Days is in the second column
                Cell ctc=row.getCell(25);
                Cell leave=row.getCell(42);
                Cell pay=row.getCell(43);
                System.out.println(name);
                System.out.println(idCell);
                System.out.println(daysCell);
                System.out.println(ctc);
                System.out.println(leave);
                
                
                
                if (idCell != null && daysCell != null) {
                    Long employeeId = (long) idCell.getNumericCellValue();
//                    System.out.println(employeeId);
                    Integer ctc1= (int)ctc.getNumericCellValue();
                    
                    String EmpName=name.getStringCellValue();
                    
                    Integer l=(int)leave.getNumericCellValue();
                    Integer pay1=(int)pay.getNumericCellValue();
                    
                   
                    int days = 0;

                    try {
                   
                       days = (int) (daysCell.getNumericCellValue());
                       
                    }catch(Exception e) {
                    	System.out.println(e);
                    }
                    
                    int finalAmount=0;
                    
                    
//                    int basic=(basic*l)/days;
                    
                       
//                       System.out.println(payableDays);                   
                    employeePayableDays.put(employeeId, new EmpSal(EmpName,ctc1,days,l,pay1,finalAmount));
                    
                }
            }

            // Perform calculation for each employee
            for (Entry<Long, EmpSal> entry : employeePayableDays.entrySet()) {
                Long employeeId = entry.getKey();
                EmpSal payableDays = entry.getValue();

                // Subtract the payable days from employee ID and output the result
//                int result = Integer.parseInt(employeeId) - payableDays;
//                System.out.println("Employee ID: " + employeeId + ", Result: " + result);
            }
            System.out.println(employeePayableDays);
            

            // Close the workbook and file input stream
            workbook.close();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
