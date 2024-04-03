package com.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class Test {
	
	public static void main(String[] args) {
		 String file1 = "/home/noida/Desktop/xl_file/data/data2.xls";
	        String file2 = "/home/noida/Desktop/xl_file/data/data2.xls";
	        String outputFile = "/home/noida/Desktop/xl_file/data/outxls.xls";

	        try {
	            // Read data from first Excel file
	            List<List<String>> data1 = readExcel(file1);

	            // Read data from second Excel file
	            List<List<String>> data2 = readExcel(file2);

	            // Merge data from both files
	            List<List<String>> mergedData = mergeData(data1, data2);

	            // Write merged data to a new Excel file
	            writeExcel(outputFile, mergedData);

	            System.out.println("Merged Excel file created successfully.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static List<List<String>> readExcel(String fileName) throws IOException {
	        List<List<String>> data = new ArrayList<>();

	        try (FileInputStream fis = new FileInputStream(fileName);
	             Workbook workbook = new HSSFWorkbook(fis)) {
	            Sheet sheet = (Sheet) workbook.getSheetAt(0);

	            Iterator<Row> rowIterator = sheet.iterator();
	            while (rowIterator.hasNext()) {
	                Row row = rowIterator.next();
	                Iterator<Cell> cellIterator = row.cellIterator();
	                List<String> rowData = new ArrayList<>();
	                while (cellIterator.hasNext()) {
	                    Cell cell = cellIterator.next();
	                    rowData.add(cell.toString());
	                }
	                data.add(rowData);
	            }
	        }

	        return data;
	    }

	    private static List<List<String>> mergeData(List<List<String>> data1, List<List<String>> data2) {
	        // Merge data from both lists into a single list
	        List<List<String>> mergedData = new ArrayList<>(data1);
	        mergedData.addAll(data2);
	        return mergedData;
	    }

	    private static void writeExcel(String fileName, List<List<String>> data) throws IOException {
	        try (FileOutputStream fos = new FileOutputStream(fileName);
	             Workbook workbook = new HSSFWorkbook()) {
	            Sheet sheet = (Sheet) workbook.createSheet();
	            int rowCount = 0;
	            for (List<String> rowData : data) {
	                Row row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(rowCount++);
	                int columnCount = 0;
	                for (String cellData : rowData) {
	                    Cell cell = row.createCell(columnCount++);
	                    cell.setCellValue(cellData);
	                }
	            }
	            workbook.write(fos);
	            System.out.println(fos);
	        }
	    
		
	}
}


