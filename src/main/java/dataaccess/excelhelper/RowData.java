package dataaccess.excelhelper;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by akash on 20/11/17.
 */
public class RowData {
    Map<String, String> dataMap;

    public RowData() {
        dataMap = new LinkedHashMap<>();
    }

    public void setColumnValue(String columnName, String value) {
        dataMap.put(columnName, value);
    }

    public String getColumnValue(String columnName) {
        return dataMap.get(columnName);
    }
}
