package com.plea11.ahms.rowmapper;

import com.plea11.ahms.commonutils.DAOUtils;
import com.plea11.ahms.models.States;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bhukyabhanuprakash
 * */

public class StatesRowMapper implements RowMapper<List<States>> {

    DAOUtils daoUtils = DAOUtils.getInstance();

    @Override
    public List<States> mapRow(ResultSet rs, int rowNum) throws SQLException {
        List<States> StatesList = new ArrayList<States>();

        do {
            States States = new States();
            if (daoUtils.hasColumn(rs, "f_id")) {
                States.setId(rs.getLong("f_id"));
            }
            if (daoUtils.hasColumn(rs, "f_name")) {
                States.setName(rs.getString("f_name"));
            }
            StatesList.add(States);
        } while (rs.next());
        
        return StatesList;
    }
}
