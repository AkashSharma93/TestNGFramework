package dataaccess;

import dataaccess.excelhelper.RowData;
import dataaccess.excelhelper.SheetData;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akash on 20/11/17.
 */
public class ExcelReader {
    private static ExcelReader excelReader;

    private Workbook workbook;

    private static ExcelReader getInstance() {
        try {
            if (excelReader == null) {
                excelReader = new ExcelReader();
            }
        } catch (IOException | InvalidFormatException  e) {
            e.printStackTrace();
        }
        return excelReader;
    }

    public ExcelReader() throws IOException, InvalidFormatException {
        FileInputStream fileInputStream = new FileInputStream(FileHelper.getTestDataFilePath());
        workbook = WorkbookFactory.create(fileInputStream);
    }

    public SheetData getExcelSheetData(String sheetName) {
        SheetData sheetData = new SheetData(sheetName);
        Sheet sheet = workbook.getSheet(sheetName);

        // Gather header info.
        Row headerRow = sheet.getRow(0);
        List<String> headerNames = new ArrayList<>();
        for (Cell cell: headerRow) {
            if (cell == null) break;    // Early quit, to avoid parsing null cells.
            headerNames.add(getCellValue(cell));
        }

        // Gathering other details.
        // Switching to traditional for-loop to skip first row.
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            if (row == null) break;     // Early quit, to avoid parsing null rows.
            RowData rowData = new RowData();
            for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
                Cell cell = row.getCell(cellIndex);
                if (cell == null) break;    // Early quit, to avoid parsing null cells.
                rowData.setColumnValue(headerNames.get(cellIndex), getCellValue(cell));
            }
            sheetData.addRowData(rowData);
        }
        return sheetData;
    }

    public String getCellValue(Cell cell) {
        switch (cell.getCellTypeEnum()) {
            case STRING:
                return cell.getStringCellValue();

            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());

            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());

            case FORMULA:
                return cell.getCellFormula();

            default:
                return "";
        }
    }
}
