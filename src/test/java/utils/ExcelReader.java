package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {

    public static List<Map<String, String>> readExcel(String path, String sheetName) {
        // Creating data structure to hold the data from Excel file
        List<Map<String, String>> excelData = new ArrayList<>();

        try {
            // Navigate to the file
            FileInputStream fileInputStream = new FileInputStream(path);
            // A class that helps us to read/write Excel Files
            XSSFWorkbook excelFile = new XSSFWorkbook(fileInputStream);
            // Accessing sheet from the Excel file
            Sheet sheet = excelFile.getSheet(sheetName);

            // Extracting the first row to use as keys for the maps
            Row headerRow = sheet.getRow(0);

            // loop to extract the data from the sheet row by row and create a map to store it
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Map<String, String> rowMap = new LinkedHashMap<>(); // map creation
                Row row = sheet.getRow(i); // extract the data from the sheet row by row (every iteration)

                // loop to store the extracted row to the map
                for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                    String key = headerRow.getCell(j).toString(); // getting the header row as key
                    String value = row.getCell(j).toString(); // extracting the value of cell
                    rowMap.put(key, value); // storing the row data to the row map

                }

                // storing the rowMap to the arrayList excelData
                excelData.add(rowMap);
            }

        } catch (IOException io) {
            io.printStackTrace();
        }

        return excelData;

    }


    // overload method that takes the sheetName
    public static List<Map<String, String>> readExcel(String sheetName) {
        // calling the readExcel method above
        return readExcel(Constants.EXCEL_FILE_PATH, sheetName);

    }

    // overload method that takes no parameter
    public static List<Map<String, String>> readExcel() {
        // calling the readExcel method above
        return readExcel(Constants.EXCEL_FILE_PATH, "Sheet1");

    }

}
