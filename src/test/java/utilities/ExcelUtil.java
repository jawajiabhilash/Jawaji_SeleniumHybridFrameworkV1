package utilities;

     import org.apache.poi.ss.usermodel.*;

     import java.io.FileInputStream;
     import java.io.FileOutputStream;
     import java.io.IOException;
     import java.util.HashMap;

     public class ExcelUtil {
         // This class is used to read data from an Excel file
         // It uses the Apache POI library to read the Excel file and extract data from it
         // The getData() method takes a sheet name as input and returns a 2D array of objects containing the data from the sheet
         // The getRowCount() method returns the number of rows in the specified sheet
         // The getColumnCount() method returns the number of columns in the specified sheet

         public static FileInputStream fileInputStream;
         public static FileOutputStream fileOutputStream;
         public static String path = "src/test/resources/testdata.xlsx";
         public static Workbook workbook;
         public static Sheet sheet;

         /**
          * Reads the test data from the specified row and sheet in the Excel file.
          *
          * @param rowNumber The row number to read the data from.
          * @param sheetName The name of the sheet to read the data from.
          * @return A HashMap containing the test data.
          * @throws IOException If an I/O error occurs.
          */
         public static HashMap<String, String> getTestData(int rowNumber, String sheetName) throws IOException {
             // Step 1: Open the Excel file
             fileInputStream = new FileInputStream(path);
             workbook = WorkbookFactory.create(fileInputStream);
             sheet = workbook.getSheet(sheetName);

             // Step 2: Get the number of rows and columns
             int rowCount = sheet.getLastRowNum();
             int columnCount = sheet.getRow(0).getLastCellNum();

             // Step 3: Create a HashMap to store the data
             HashMap<String, String> hashmap = new HashMap<>();

             // Step 4: Iterate through the columns and read the data
             for (int i = 0; i < columnCount; i++) {
                 String key = sheet.getRow(0).getCell(i).getStringCellValue();
                 String value = sheet.getRow(rowNumber).getCell(i).getStringCellValue();
                 hashmap.put(key, value);
             }

             // Step 5: Close the file input stream
             fileInputStream.close();

             // Step 6: Return the HashMap containing the test data
             return hashmap;
         }

         /**
          * Writes the test data into the specified Excel sheet and returns the HashMap object.
          *
          * @param sheetName The name of the sheet where the data should be written.
          * @return The HashMap object containing the test data.
          * @throws IOException If an I/O error occurs.
          */
         public static HashMap<String, String> writeTestData(String sheetName) throws IOException {
             // Step 1: Open the Excel file and get the sheet where you want to write the data
             FileInputStream fileInputStream = new FileInputStream(path);
             Workbook workbook = WorkbookFactory.create(fileInputStream);
             Sheet sheet = workbook.getSheet(sheetName);
             if (sheet == null) {
                 sheet = workbook.createSheet(sheetName);
             }
             fileInputStream.close();

             // Step 2: Create a new row at the end of the sheet
             int rowCount = sheet.getLastRowNum();
             Row row = sheet.createRow(++rowCount);

             // Step 3: Create a HashMap to store the data
             HashMap<String, String> hashMap = new HashMap<>();

             // Step 4: Iterate through the HashMap and write the key-value pairs into the sheet
             int cellNum = 0;
             for (String key : hashMap.keySet()) {
                 Cell cell = row.createCell(cellNum++);
                 cell.setCellValue(key);
                 cell = row.createCell(cellNum++);
                 cell.setCellValue(hashMap.get(key));
             }

             // Step 5: Save and close the file
             FileOutputStream fileOutputStream = new FileOutputStream(path);
             workbook.write(fileOutputStream);
             fileOutputStream.close();
             workbook.close();

             // Step 6: Return the HashMap object
             return hashMap;
         }

         /**
          * Returns the number of rows in the specified sheet.
          *
          * @param sheetName The name of the sheet.
          * @return The number of rows in the sheet.
          * @throws IOException If an I/O error occurs.
          */
         public static int getRowCount(String sheetName) throws IOException {
             // Step 1: Open the Excel file
             fileInputStream = new FileInputStream(path);
             workbook = WorkbookFactory.create(fileInputStream);
             sheet = workbook.getSheet(sheetName);

             // Step 2: Get the number of rows
             int rowCount = sheet.getLastRowNum();

             // Step 3: Close the file input stream
             fileInputStream.close();

             // Step 4: Return the number of rows
             return rowCount;
         }

         /**
          * Returns the number of columns in the first row of the specified sheet.
          *
          * @param sheetName The name of the sheet.
          * @return The number of columns in the first row.
          * @throws IOException If an I/O error occurs.
          */
         public static int getColumnCount(String sheetName) throws IOException {
             // Step 1: Open the Excel file
             fileInputStream = new FileInputStream(path);
             workbook = WorkbookFactory.create(fileInputStream);
             sheet = workbook.getSheet(sheetName);

             // Step 2: Get the number of columns in the first row
             int columnCount = sheet.getRow(0).getLastCellNum();

             // Step 3: Close the file input stream
             fileInputStream.close();

             // Step 4: Return the number of columns
             return columnCount;
         }
     }