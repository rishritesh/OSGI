package com.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, IOException
    {
        System.out.println( "Hello World!" );
        

        
        
        try (InputStream inp = new FileInputStream("/home/noida/Desktop/xl_file/data/data1.xlsx")) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0); // Assuming data is in the first sheet

            List<Map<String, String>> dataList = new ArrayList<>();
            Iterator<Row> rowIterator = sheet.iterator();

            // Get column headers
            Row headerRow = rowIterator.next();
            List<String> headers = new ArrayList<>();
            for (Cell headerCell : headerRow) {
                headers.add(headerCell.toString());
            }

            // Iterate through rows
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Map<String, String> rowData = new HashMap<>();
                for (int i = 0; i < headers.size(); i++) {
                    Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    rowData.put(headers.get(i), cell.toString());
                }
                dataList.add(rowData);
            }

            // Convert data list to JSON
            String json = convertListToJson(dataList);
            System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        // Method to convert a list of maps to JSON format
        private static String convertListToJson(List<Map<String, String>> list) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.writeValueAsString(list);
            } catch (Exception e) {
                // Handle exception appropriately
                e.printStackTrace();
                return null;
            }
        }
    }

