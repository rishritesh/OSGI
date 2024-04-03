package com.data;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExcelReader {
    public static void main(String[] args) {
    	
        try {
            // Provide the path to your Excel file
            FileInputStream file = new FileInputStream(new File("/home/noida/Desktop/xl_file/data/salary.xlsx"));

            // Create Workbook instance for XLSX file
            Workbook workbook = new XSSFWorkbook(file);

            // Get the first sheet in the workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Map to store employee ID and corresponding payable days
            Map<Long, Integer> employeePayableDays = new LinkedHashMap<>();


            for (int i = 2; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Cell idCell = row.getCell(1); // Assuming Employee ID is in the first column
                Cell daysCell = row.getCell(11); // Assuming Payable Days is in the second column
//                System.out.println(idCell);
//                System.out.println(daysCell);
                
                if (idCell != null && daysCell != null) {
                    Long employeeId = (long) idCell.getNumericCellValue();
//                    System.out.println(employeeId);
                    int payableDays = 0;

                    try {
                   
                       payableDays = (int) (daysCell.getNumericCellValue());
                       
                    }catch(Exception e) {
                    	System.out.println(e);
                    }
                       
//                       System.out.println(payableDays);
                       

                   
                    employeePayableDays.put(employeeId, payableDays);
                    
                }
            }

            // Perform calculation for each employee
            for (Map.Entry<Long, Integer> entry : employeePayableDays.entrySet()) {
                Long employeeId = entry.getKey();
                int payableDays = entry.getValue();

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

