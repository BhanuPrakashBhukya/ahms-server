package com.plea11.ahms.rowmapper;

import com.plea11.ahms.commonutils.DAOUtils;
import com.plea11.ahms.models.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bhukyabhanuprakash
 */

public class CountryRowMapper implements RowMapper<List<Country>> {

    DAOUtils daoUtils = DAOUtils.getInstance();

    @Override
    public List<Country> mapRow(ResultSet rs, int rowNum) throws SQLException {
        List<Country> countryList = new ArrayList<Country>();

        do {
            Country country = new Country();

            if (daoUtils.hasColumn(rs, "f_id")) {
                country.setId(rs.getLong("f_id"));
            }
            if (daoUtils.hasColumn(rs, "f_name")) {
                country.setName(rs.getString("f_name"));
            }
            countryList.add(country);
        } while (rs.next());

        return countryList;
    }
}
