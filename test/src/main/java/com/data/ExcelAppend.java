package com.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelAppend {
	private static final Logger l = Logger.getLogger(ExcelAppend.class.getName());
	
	public static void append() {
		
		 String inputFile = "/home/noida/Desktop/xl_file/data/cal.xlsx";
	        String appendFile = "/home/noida/Desktop/xl_file/data/caloutput.xlsx";
	        String outputFile = "/home/noida/Desktop/xl_file/data/caloutput.xlsx";

	        try {
	            FileInputStream inputStream = new FileInputStream(inputFile);
	            Workbook workbook = new XSSFWorkbook(inputStream);

	            FileInputStream appendStream = new FileInputStream(appendFile);
	            Workbook appendWorkbook = new XSSFWorkbook(appendStream);
	            Sheet appendSheet = appendWorkbook.getSheetAt(0); // Assuming data is in the first sheet

	            FileOutputStream outputStream = new FileOutputStream(outputFile);
	            workbook.cloneSheet(0);
	            workbook.write(outputStream);

	            Sheet outputSheet = workbook.getSheetAt(1); // Second sheet

	            int rowCount = appendSheet.getPhysicalNumberOfRows();
	            for (int i = 0; i < rowCount; i++) {
	                Row row = appendSheet.getRow(i);
	                Row outputRow = outputSheet.createRow(outputSheet.getLastRowNum() + 1);

	                int columnCount = row.getPhysicalNumberOfCells();
	                for (int j = 0; j < columnCount; j++) {
	                    Cell cell = row.getCell(j);
	                    Cell outputCell = outputRow.createCell(j);

	                    if (cell != null) {
	                        switch (cell.getCellType()) {
	                            case STRING:
	                                outputCell.setCellValue(cell.getStringCellValue());
	                                break;
	                            case NUMERIC:
	                                if (DateUtil.isCellDateFormatted(cell)) {
	                                    outputCell.setCellValue(cell.getDateCellValue());
	                                } else {
	                                    outputCell.setCellValue(cell.getNumericCellValue());
	                                }
	                                break;
	                            case BOOLEAN:
	                                outputCell.setCellValue(cell.getBooleanCellValue());
	                                break;
	                            case FORMULA:
	                                switch (cell.getCachedFormulaResultType()) {
	                                    case STRING:
	                                        outputCell.setCellValue(cell.getStringCellValue());
	                                        break;
	                                    case NUMERIC:
	                                        outputCell.setCellValue(cell.getNumericCellValue());
	                                        break;
	                                    case BOOLEAN:
	                                        outputCell.setCellValue(cell.getBooleanCellValue());
	                                        break;
	                                }
	                                break;
	                            default:
	                                outputCell.setCellValue("");
	                        }
	                    }
	                }
	            }

	            outputStream.flush();
	            outputStream.close();
	            workbook.close();
	            inputStream.close();

	           // System.out.println("Data appended successfully to output file.");
	            l.info("Data appended successfully to output file.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}
//    public static void main(String[] args) {
//        String inputFile = "/home/noida/Desktop/xl_file/data/cal.xlsx";
//        String appendFile = "/home/noida/Desktop/xl_file/data/caloutput.xlsx";
//        String outputFile = "/home/noida/Desktop/xl_file/data/caloutput.xlsx";
//
//        try {
//            FileInputStream inputStream = new FileInputStream(inputFile);
//            Workbook workbook = new XSSFWorkbook(inputStream);
//
//            FileInputStream appendStream = new FileInputStream(appendFile);
//            Workbook appendWorkbook = new XSSFWorkbook(appendStream);
//            Sheet appendSheet = appendWorkbook.getSheetAt(0); // Assuming data is in the first sheet
//
//            FileOutputStream outputStream = new FileOutputStream(outputFile);
//            workbook.cloneSheet(0);
//            workbook.write(outputStream);
//
//            Sheet outputSheet = workbook.getSheetAt(1); // Second sheet
//
//            int rowCount = appendSheet.getPhysicalNumberOfRows();
//            for (int i = 0; i < rowCount; i++) {
//                Row row = appendSheet.getRow(i);
//                Row outputRow = outputSheet.createRow(outputSheet.getLastRowNum() + 1);
//
//                int columnCount = row.getPhysicalNumberOfCells();
//                for (int j = 0; j < columnCount; j++) {
//                    Cell cell = row.getCell(j);
//                    Cell outputCell = outputRow.createCell(j);
//
//                    if (cell != null) {
//                        switch (cell.getCellType()) {
//                            case STRING:
//                                outputCell.setCellValue(cell.getStringCellValue());
//                                break;
//                            case NUMERIC:
//                                if (DateUtil.isCellDateFormatted(cell)) {
//                                    outputCell.setCellValue(cell.getDateCellValue());
//                                } else {
//                                    outputCell.setCellValue(cell.getNumericCellValue());
//                                }
//                                break;
//                            case BOOLEAN:
//                                outputCell.setCellValue(cell.getBooleanCellValue());
//                                break;
//                            case FORMULA:
//                                switch (cell.getCachedFormulaResultType()) {
//                                    case STRING:
//                                        outputCell.setCellValue(cell.getStringCellValue());
//                                        break;
//                                    case NUMERIC:
//                                        outputCell.setCellValue(cell.getNumericCellValue());
//                                        break;
//                                    case BOOLEAN:
//                                        outputCell.setCellValue(cell.getBooleanCellValue());
//                                        break;
//                                }
//                                break;
//                            default:
//                                outputCell.setCellValue("");
//                        }
//                    }
//                }
//            }
//
//            outputStream.flush();
//            outputStream.close();
//            workbook.close();
//            inputStream.close();
//
//           // System.out.println("Data appended successfully to output file.");
//            l.info("Data appended successfully to output file.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
