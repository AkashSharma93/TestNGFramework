package dataaccess.excelhelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akash on 20/11/17.
 */
public class SheetData {
    private String sheetName;
    private List<RowData> rows;

    public SheetData(String sheetName) {
        this.sheetName = sheetName;
        rows = new ArrayList<>();
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public List<RowData> getRowData() {
        return rows;
    }

    public void addRowData(RowData rowData) {
        rows.add(rowData);
    }
}
