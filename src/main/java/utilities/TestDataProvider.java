package utilities;

import dataaccess.ExcelReader;
import dataaccess.excelhelper.RowData;
import dataaccess.excelhelper.SheetData;
import dataaccess.excelhelper.TestDataHeaders;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestDataProvider {

    @DataProvider(name = "test-data", parallel = true)
    public Iterator<Object[]> getTestData(Method method) {
        String testName = method.getName();
        List<Object[]> testData = new ArrayList<>();
        ExcelReader excelReader = ExcelReader.getInstance();
        SheetData sheetData = excelReader.getExcelSheetData("tests");
        for (RowData rowData: sheetData.getRowData()) {
            if (rowData.getColumnValue(TestDataHeaders.testcaseName).equalsIgnoreCase(testName)) {
                testData.add(new Object[] {rowData.getDataMap()});
            }
        }
        return testData.iterator();
    }
}
