package com.data;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadData {
	

		    public static void main(String[] args) {
		        try {
		            // Provide the path to your Excel file
		            FileInputStream file = new FileInputStream(new File("/home/noida/Desktop/xl_file/data/data1.xlsx"));

		            // Create Workbook instance for XLSX file
		            Workbook workbook = new XSSFWorkbook(file);

		            // Get the first sheet in the workbook
		            Sheet sheet = workbook.getSheetAt(0);

		            // Specify the row and column index you want to read
		            int rowIndex = 0; // Row index (0-based)
		            int columnIndex = 0; // Column index (0-based)

		            // Get the cell at the specified row and column
//		            Row row = sheet.getRow(rowIndex);
//		            Cell cell = row.getCell(columnIndex);
		            Row headerRow = sheet.getRow(0);
		            String columnName = headerRow.getCell(columnIndex).getStringCellValue();
		            System.out.println("Column Name: " + columnName);

		            // Get the value from the cell
//		            String cellValue = cell.getStringCellValue();
		            // Iterate through all rows and get data from the specified column
//		            for (Row row : sheet) {
//		                Cell cell = row.getCell(columnIndex);
//		                if (cell != null) {
//		                    String cellValue = "";
//		                    if (cell.getCellType() == CellType.NUMERIC) {
//		                        // Handle numeric values
//		                        cellValue = String.valueOf(cell.getNumericCellValue());
//		                    } else if (cell.getCellType() == CellType.STRING) {
//		                        // Handle string values
//		                        cellValue = cell.getStringCellValue();
//		                    }
//		                    // Output the value
//		                    System.out.println("Value in Column " + (columnIndex + 1) + ": " + cellValue);
//		                }
//		            }
		            
		            // Iterate through data rows and get data from the specified column
		            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
		                Row row = sheet.getRow(i);
		                Cell cell = row.getCell(columnIndex);
		                if (cell != null) {
		                    String cellValue = "";
		                    if (cell.getCellType() == CellType.NUMERIC) {
		                        // Handle numeric values
		                        cellValue = String.valueOf(cell.getNumericCellValue());
		                    } else if (cell.getCellType() == CellType.STRING) {
		                        // Handle string values
		                        cellValue = cell.getStringCellValue();
		                    }
		                    // Output the value with the corresponding name
		                    System.out.println("Name: " + headerRow.getCell(columnIndex).getStringCellValue() +
		                            ", Value: " + cellValue);
		                }
		            }
		           
		            workbook.close();
		            file.close();
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
}


