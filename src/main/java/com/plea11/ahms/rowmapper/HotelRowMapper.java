package com.plea11.ahms.rowmapper;

import com.plea11.ahms.commonutils.DAOUtils;
import com.plea11.ahms.models.Hotels;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelRowMapper implements RowMapper<List<Hotels>> {

    DAOUtils daoUtils = DAOUtils.getInstance();

    @Override
    public List<Hotels> mapRow(ResultSet rs, int rowNum) throws SQLException {
        List<Hotels> hotelList = new ArrayList<Hotels>();

        do {
            Hotels hotel = new Hotels();

            if (daoUtils.hasColumn(rs,"f_id")) {
                hotel.setId(rs.getLong("f_id"));
            }
            if (daoUtils.hasColumn(rs,"f_name")) {
                hotel.setName(rs.getString("f_name"));
            }
            if (daoUtils.hasColumn(rs,"f_mobile_number")) {
                hotel.setPhone(rs.getString("f_mobile_number"));
            }
            if (daoUtils.hasColumn(rs,"f_email")) {
                hotel.setEmail(rs.getString("f_email"));
            }
            if (daoUtils.hasColumn(rs,"f_password")) {
                hotel.setPassword(rs.getString("f_password"));
            }
            if (daoUtils.hasColumn(rs,"f_category")) {
                hotel.setCategory(rs.getInt("f_category"));
            }
            if (daoUtils.hasColumn(rs,"f_address_first_line")) {
                hotel.setAddressFirstLine(rs.getString("f_address_first_line"));
            }
            if (daoUtils.hasColumn(rs,"f_address_second_line")) {
                hotel.setAddressSecondLine(rs.getString("f_address_second_line"));
            }
            if (daoUtils.hasColumn(rs,"f_city")) {
                hotel.setCity(rs.getString("f_city"));
            }
            if (daoUtils.hasColumn(rs,"f_state_id")) {
                hotel.setState(rs.getLong("f_state_id"));
            }
            if (daoUtils.hasColumn(rs,"f_country_id")) {
                hotel.setCountry(rs.getLong("f_country_id"));
            }
            hotelList.add(hotel);
        } while (rs.next());
        return hotelList;
    }
}
