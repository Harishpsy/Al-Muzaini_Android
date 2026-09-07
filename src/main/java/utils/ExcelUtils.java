package utils;

import constants.FrameworkConstants;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ExcelUtils {

    private static final DataFormatter DATA_FORMATTER = new DataFormatter();

    private ExcelUtils() {}

    /**
     * Resolves the full path of an Excel file.
     * Checks if fileName is an existing path, or looks inside the configured or default test data directory.
     * Automatically appends .xlsx if missing.
     *
     * @param fileName File name or relative/absolute path
     * @return Absolute file path
     */
    public static String resolveFilePath(String fileName) {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("File name cannot be null or empty.");
        }

        String normalizedName = fileName.trim();
        if (!normalizedName.endsWith(".xlsx") && !normalizedName.endsWith(".xls")) {
            normalizedName += ".xlsx";
        }

        // Check if direct file exists (absolute or relative to current working directory)
        File directFile = new File(normalizedName);
        if (directFile.exists()) {
            return directFile.getAbsolutePath();
        }

        // Check in test data path (configured via qa.properties/system property or default resources/Testdata)
        String testDataDir = FrameworkConstants.getTestDataPath();
        File resolvedFile = new File(testDataDir, normalizedName);
        if (resolvedFile.exists()) {
            return resolvedFile.getAbsolutePath();
        }

        // Fallback: check standard src/main/resources/Testdata
        File fallbackFile = new File(FrameworkConstants.TEST_DATA_PATH, normalizedName);
        if (fallbackFile.exists()) {
            return fallbackFile.getAbsolutePath();
        }

        // Return resolved path even if it doesn't exist yet (useful for error messages or file creation)
        return resolvedFile.getAbsolutePath();
    }

    /**
     * Reads all data rows from the first sheet of the specified Excel file.
     *
     * @param fileName Name of the Excel file (e.g., "Login.xlsx")
     * @return List of Object arrays representing row values
     */
    public static List<Object[]> getTestData(String fileName) {
        return getTestData(fileName, null);
    }

    /**
     * Reads all data rows from the specified sheet of an Excel file.
     * Skips the header row (row index 0). Blank rows are ignored.
     *
     * @param fileName  Name or path of the Excel file
     * @param sheetName Sheet name to read (or null/empty for first sheet)
     * @return List of Object arrays representing row values
     */
    public static List<Object[]> getTestData(String fileName, String sheetName) {
        String resolvedPath = resolveFilePath(fileName);
        File file = new File(resolvedPath);

        if (!file.exists()) {
            throw new RuntimeException("Excel test data file not found at: " + resolvedPath);
        }

        List<Object[]> dataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = (sheetName == null || sheetName.trim().isEmpty())
                    ? workbook.getSheetAt(0)
                    : workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new IllegalArgumentException("Sheet '" + sheetName + "' not found in workbook: " + resolvedPath);
            }

            int rowCount = sheet.getPhysicalNumberOfRows();
            if (rowCount <= 1) {
                // No data rows (only header or empty)
                return dataList;
            }

            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                return dataList;
            }

            int colCount = headerRow.getLastCellNum();

            for (int r = 1; r <= sheet.getLastRowNum(); r++) {
                Row row = sheet.getRow(r);
                if (row == null || isRowEmpty(row, colCount)) {
                    continue;
                }

                Object[] rowData = new Object[colCount];
                for (int c = 0; c < colCount; c++) {
                    Cell cell = row.getCell(c, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                    rowData[c] = (cell == null) ? "" : DATA_FORMATTER.formatCellValue(cell).trim();
                }
                dataList.add(rowData);
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to read Excel file at: " + resolvedPath, e);
        }

        return dataList;
    }

    /**
     * Reads sheet data as a list of maps, where each map contains ColumnHeader -> CellValue pairs.
     *
     * @param fileName  Excel file name
     * @param sheetName Sheet name (or null for first sheet)
     * @return List of Maps
     */
    public static List<Map<String, String>> getTestDataAsMap(String fileName, String sheetName) {
        String resolvedPath = resolveFilePath(fileName);
        File file = new File(resolvedPath);

        if (!file.exists()) {
            throw new RuntimeException("Excel test data file not found at: " + resolvedPath);
        }

        List<Map<String, String>> dataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = (sheetName == null || sheetName.trim().isEmpty())
                    ? workbook.getSheetAt(0)
                    : workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new IllegalArgumentException("Sheet '" + sheetName + "' not found in workbook: " + resolvedPath);
            }

            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                return dataList;
            }

            int colCount = headerRow.getLastCellNum();
            List<String> headers = new ArrayList<>();
            for (int c = 0; c < colCount; c++) {
                Cell cell = headerRow.getCell(c);
                headers.add(cell == null ? "Col_" + c : DATA_FORMATTER.formatCellValue(cell).trim());
            }

            for (int r = 1; r <= sheet.getLastRowNum(); r++) {
                Row row = sheet.getRow(r);
                if (row == null || isRowEmpty(row, colCount)) {
                    continue;
                }

                Map<String, String> rowMap = new LinkedHashMap<>();
                for (int c = 0; c < colCount; c++) {
                    Cell cell = row.getCell(c, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                    String value = (cell == null) ? "" : DATA_FORMATTER.formatCellValue(cell).trim();
                    rowMap.put(headers.get(c), value);
                }
                dataList.add(rowMap);
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to read Excel file at: " + resolvedPath, e);
        }

        return dataList;
    }

    /**
     * Helper to write or create an Excel file with header and data rows.
     *
     * @param targetPath Target file path
     * @param sheetName  Sheet name
     * @param headers    Array of column headers
     * @param dataRows   List of data row arrays
     * @throws IOException If write fails
     */
    public static void createExcelFile(String targetPath, String sheetName, String[] headers, List<String[]> dataRows) throws IOException {
        File file = new File(targetPath);
        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        try (Workbook workbook = new org.apache.poi.xssf.usermodel.XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet(sheetName != null ? sheetName : "Sheet1");

            // Header Style
            CellStyle headerStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            headerStyle.setFont(font);
            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // Create Header Row
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i, CellType.STRING);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
            }

            // Create Data Rows
            int rowIdx = 1;
            for (String[] rowData : dataRows) {
                Row row = sheet.createRow(rowIdx++);
                for (int c = 0; c < rowData.length; c++) {
                    Cell cell = row.createCell(c, CellType.STRING);
                    cell.setCellValue(rowData[c]);
                }
            }

            // Auto-size columns
            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            try (FileOutputStream fos = new FileOutputStream(file)) {
                workbook.write(fos);
            }
        }
    }

    private static boolean isRowEmpty(Row row, int colCount) {
        for (int c = 0; c < colCount; c++) {
            Cell cell = row.getCell(c, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
            if (cell != null && !DATA_FORMATTER.formatCellValue(cell).trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
