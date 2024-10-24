package com.plea11.ahms.commonutils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * @author bhukyabhanuprakash
 */

public class DAOUtils {
    static DAOUtils dAOUtils = new DAOUtils();

    private DAOUtils() {
    }

    public static DAOUtils getInstance() {
        return dAOUtils;
    }
    public boolean hasColumn(ResultSet rs, String columnName) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columns = rsmd.getColumnCount();
        for (int x = 1; x <= columns; x++) {
            if (columnName.equals(rsmd.getColumnLabel(x))) {
                return true;
            }
        }
        return false;
    }
}
