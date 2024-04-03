package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TotalSal {
	private static final Logger log = Logger.getLogger(TotalSal.class.getName());

	
	public static void collect() {
		
		Test config=new Test();
		String file= config.getProperty("cal");
		
		String file1=config.getProperty("caloutput1");
		 
		String outputcal1=config.getProperty("cal1");
		
		try {
			
		    FileInputStream inputStream = new FileInputStream(file);

		    
		    Workbook workbook = new XSSFWorkbook(inputStream);
		    Sheet sheet = workbook.getSheetAt(0); 

		    FileInputStream appendStream = new FileInputStream(file1);
		  
		    Workbook appendWorkbook = new XSSFWorkbook(appendStream);
		    Sheet appendSheet = appendWorkbook.getSheetAt(0); 

		    int rowCount = Math.max(sheet.getPhysicalNumberOfRows(), appendSheet.getPhysicalNumberOfRows());
		    int finalAmount=0;
		    for (int i = 1; i < rowCount; i++) {
		        Row existingRow = sheet.getRow(i);
		        Row appendRow = appendSheet.getRow(i);
		        Cell id = appendRow.getCell(44);
		        

		        if (existingRow == null) {
		            existingRow = sheet.createRow(i);
		        }
		        

		        int startColumn = existingRow.getLastCellNum() >= 0 ? existingRow.getLastCellNum() : 0;
		        

		        if (appendRow != null) {
		            int columnCount = appendRow.getPhysicalNumberOfCells();
		            for (int j = 0; j < columnCount; j++) {
		                Cell cell = appendRow.getCell(j);
		                Cell existingCell = existingRow.createCell(startColumn + j);

		                if (cell != null) {
		                    switch (cell.getCellType()) {
		                        case STRING:
		                            existingCell.setCellValue(cell.getStringCellValue());
		                            break;
		                        case NUMERIC:
		                            if (DateUtil.isCellDateFormatted(cell)) {

		                                existingCell.setCellValue(cell.getDateCellValue());
		                                

		                                CellStyle dateCellStyle = existingCell.getCellStyle();
		                                CreationHelper createHelper = existingCell.getSheet().getWorkbook().getCreationHelper();
		                                dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy")); // You can change the date format as per your requirement
		                                existingCell.setCellStyle(dateCellStyle);

		                            } else {
		                                existingCell.setCellValue(cell.getNumericCellValue());
		                            }
		                            break;
		                        case BOOLEAN:
		                            existingCell.setCellValue(cell.getBooleanCellValue());
		                            break;
		                        case FORMULA:
		                            switch (cell.getCachedFormulaResultType()) {
		                                case STRING:
		                                    existingCell.setCellValue(cell.getStringCellValue());
		                                    break;
		                                case NUMERIC:


		                                    existingCell.setCellValue(cell.getNumericCellValue());
		                                    break;
		                                case BOOLEAN:
		                                    existingCell.setCellValue(cell.getBooleanCellValue());
		                                    break;
		                            }
		                            break;
		                        default:
		                            existingCell.setCellValue("");
		                    }
		                }
		            }
		        }
		    }

		    FileOutputStream outputStream = new FileOutputStream(outputcal1);

		    workbook.write(outputStream);

		    outputStream.flush();
		    outputStream.close();
		    workbook.close();
		    inputStream.close();

		    
		    log.info("Data merged successfully.");
		} catch (Exception e) {
			log.info("eror at merged."+e.getMessage());
		}

	}
	


}
