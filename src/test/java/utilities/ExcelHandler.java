package utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * `ExcelHandler` class provides utility methods to read and write data to Excel files.
 * It uses the Apache POI library to interact with Excel files.
 * The class supports writing data from a List of HashMaps to an Excel sheet and
 * reading data from a specific row in an Excel sheet into a HashMap.
 */
public class ExcelHandler {

    public static FileInputStream excelFileInputStream;
    public static FileOutputStream excelFileOutputStream;
    public static String excelFilePath = "src/test/resources/testdata.xlsx";
    public static Workbook excelWorkbook;
    public static Sheet targetSheet;

    /**
     * Writes data from a List of HashMaps to an Excel sheet.
     * Each HashMap in the list represents a row of data.
     *
     * @param sheetName The name of the sheet to write the data to.
     * @param dataList  A List of HashMaps, where each HashMap contains the data for a single row.
     *                  Keys in the HashMaps represent column headers.
     * @throws IOException If an error occurs while writing to the Excel file.
     */
    public static void writeDataToExcel(String sheetName, List<HashMap<String, String>> dataList) throws IOException {
        // Step 1: Open the Excel file for reading
        excelFileInputStream = new FileInputStream(excelFilePath);
        excelWorkbook = WorkbookFactory.create(excelFileInputStream);

        // Step 2: Get the target sheet or create a new one if it doesn't exist
        targetSheet = excelWorkbook.getSheet(sheetName);
        if (targetSheet == null) {
            targetSheet = excelWorkbook.createSheet(sheetName);
        }
        excelFileInputStream.close();

        // Step 3: Create the header row using the keys from the first HashMap
        int rowIndex = 0;
        int columnIndex = 0;
        Row headerRow = targetSheet.createRow(rowIndex++);
        HashMap<String, String> headerMap = dataList.get(0);
        for (String key : headerMap.keySet()) {
            Cell cell = headerRow.createCell(columnIndex++);
            cell.setCellValue(key); // Write the header key
        }

        // Step 4: Write the data rows from the HashMap list
        for (HashMap<String, String> dataMap : dataList) {
            Row dataRow = targetSheet.createRow(rowIndex++);
            columnIndex = 0;
            for (String value : dataMap.values()) {
                Cell cell = dataRow.createCell(columnIndex++);
                cell.setCellValue(value); // Write the data value
            }
        }

        // Step 5: Save the changes to the Excel file
        excelFileOutputStream = new FileOutputStream(excelFilePath);
        excelWorkbook.write(excelFileOutputStream);
        excelFileOutputStream.close();

        // Step 6: Print success message
        System.out.println("Excel file created successfully: " + dataList);
    }

    /**
     * Reads data from a specific row in an Excel sheet into a HashMap.
     *
     * @param sheetName The name of the sheet to read the data from.
     * @param rowNum    The row number to read the data from (0-based index).
     * @return A HashMap containing the data from the specified row,
     *         where keys are column headers and values are the corresponding cell values.
     * @throws IOException If an error occurs while reading from the Excel file.
     */
    public static HashMap<String, String> readDataFromExcel(String sheetName, int rowNum) throws IOException {
        // Step 1: Open the Excel file for reading
        excelFileInputStream = new FileInputStream(excelFilePath);
        excelWorkbook = WorkbookFactory.create(excelFileInputStream);

        // Step 2: Get the target sheet
        targetSheet = excelWorkbook.getSheet(sheetName);

        // Step 3: Get the total number of columns in the header row
        int totalColumns = targetSheet.getRow(0).getLastCellNum();

        // Step 4: Create a HashMap to store the data
        HashMap<String, String> readMap = new HashMap<>();

        // Step 5: Iterate through the columns and read the data
        for (int i = 0; i < totalColumns; i++) {
            String key = targetSheet.getRow(0).getCell(i).getStringCellValue(); // Read header key
            String value = targetSheet.getRow(rowNum).getCell(i).getStringCellValue(); // Read cell value
            readMap.put(key, value); // Add key-value pair to HashMap
        }

        // Step 6: Close the file input stream
        excelFileInputStream.close();

        // Step 7: Return the HashMap containing the data
        return readMap;
    }

    /**
     * Main method to demonstrate the functionality of the `ExcelHandler` class.
     *
     * @param args Command line arguments (not used).
     * @throws IOException If an error occurs while reading or writing to the Excel file.
     */
    public static void main(String[] args) throws IOException {
        // Step 1: Create a list of HashMaps to represent multiple rows of data
        List<HashMap<String, String>> dataList = new ArrayList<>();

        // Step 2: Add the first row of data
        HashMap<String, String> dataMap1 = new HashMap<>();
        dataMap1.put("Name", "John");
        dataMap1.put("Age", "30");
        dataMap1.put("City", "New York");
        dataList.add(dataMap1);

        // Step 3: Add the second row of data
        HashMap<String, String> dataMap2 = new HashMap<>();
        dataMap2.put("Name", "Jane");
        dataMap2.put("Age", "25");
        dataMap2.put("City", "Los Angeles");
        dataList.add(dataMap2);

        // Step 4: Write the data to the Excel sheet
        writeDataToExcel("TestSheet", dataList);

        // Step 5: Read data from a specific row in the Excel sheet
        HashMap<String, String> getData = readDataFromExcel("TestSheet", 1);

        // Step 6: Print the retrieved data
        System.out.println("Read Data: " + getData.get("Name") + ", " + getData.get("Age") + ", " + getData.get("City"));
    }
}