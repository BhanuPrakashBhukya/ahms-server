package com.plea11.ahms.rowmapper;

import com.plea11.ahms.commonutils.DAOUtils;
import com.plea11.ahms.models.LogIn;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bhukyabhanuprakash
 */

public class LogInRowMapper implements RowMapper {

    DAOUtils daoUtils = DAOUtils.getInstance();

    @Override
    public List<LogIn> mapRow(ResultSet rs, int rowNum) throws SQLException {
        List<LogIn> logInList = new ArrayList<LogIn>();

        do {
            LogIn logIn = new LogIn();
            if (daoUtils.hasColumn(rs,"")) {
                logIn.setEmail(rs.getString(""));
            }
            if (daoUtils.hasColumn(rs,"")) {
                logIn.setPassword(rs.getString(""));
            }
            if (daoUtils.hasColumn(rs,"")) {
                logIn.setUniqueId(rs.getString(""));
            }
            if (daoUtils.hasColumn(rs,"")) {
                logIn.setPhoneNumber(rs.getString(""));
            }
            logInList.add(logIn);
        } while (rs.next());

        return logInList;
    }
}
