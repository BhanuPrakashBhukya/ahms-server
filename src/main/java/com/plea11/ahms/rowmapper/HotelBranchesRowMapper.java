package com.plea11.ahms.rowmapper;

import com.plea11.ahms.commonutils.DAOUtils;
import com.plea11.ahms.models.HotelBranches;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelBranchesRowMapper implements RowMapper<List<HotelBranches>> {

    DAOUtils daoUtils = DAOUtils.getInstance();

    @Override
    public List<HotelBranches> mapRow(ResultSet rs, int rowNum) throws SQLException {
        List<HotelBranches> hotelBranches = new ArrayList<HotelBranches>();

        do {
            HotelBranches hotelBranche = new HotelBranches();

            if (daoUtils.hasColumn(rs, "f_id")) {
                hotelBranche.setId(rs.getLong("f_id"));
            }
            if (daoUtils.hasColumn(rs, "f_hotel_id")) {
                hotelBranche.setHotelId(rs.getLong("f_hotel_id"));
            }
            if (daoUtils.hasColumn(rs, "hotel_name")) {
                hotelBranche.setHotelName(rs.getString("hotel_name"));
            }
            if (daoUtils.hasColumn(rs, "f_name")) {
                hotelBranche.setName(rs.getString("f_name"));
            }
            if (daoUtils.hasColumn(rs, "f_gmail")) {
                hotelBranche.setGmail(rs.getString("f_gmail"));
            }
            if (daoUtils.hasColumn(rs, "f_phone_number")) {
                hotelBranche.setPhoneNumber(rs.getString("f_phone_number"));
            }
            if (daoUtils.hasColumn(rs, "f_address_first_line")) {
                hotelBranche.setAddressfirstLine(rs.getString("f_address_first_line"));
            }
            if (daoUtils.hasColumn(rs, "f_address_second_line")) {
                hotelBranche.setAddresssecondLine(rs.getString("f_address_second_line"));
            }
            if (daoUtils.hasColumn(rs, "f_city")) {
                hotelBranche.setCity(rs.getString("f_city"));
            }
            if (daoUtils.hasColumn(rs, "state_name")) {
                hotelBranche.setState(rs.getString("state_name"));
            }
            if (daoUtils.hasColumn(rs, "country_name")) {
                hotelBranche.setCountry(rs.getString("country_name"));
            }
            if (daoUtils.hasColumn(rs, "f_pin_code")) {
                hotelBranche.setZipCode(rs.getString("f_pin_code"));
            }
            if (daoUtils.hasColumn(rs, "f_total_rooms")) {
                hotelBranche.setTotal(rs.getInt("f_total_rooms"));
            }
            if (daoUtils.hasColumn(rs, "f_non_suite_rooms")) {
                hotelBranche.setNonSuite(rs.getInt("f_non_suite_rooms"));
            }
            if (daoUtils.hasColumn(rs, "f_suite_rooms")) {
                hotelBranche.setSuite(rs.getInt("f_suite_rooms"));
            }
            if (daoUtils.hasColumn(rs, "f_non_suite_available_rooms")) {
                hotelBranche.setNonSuiteAvailable(rs.getInt("f_non_suite_available_rooms"));
            }
            if (daoUtils.hasColumn(rs, "f_suite_available_rooms")) {
                hotelBranche.setSuiteAvailable(rs.getInt("f_suite_available_rooms"));
            }
            hotelBranches.add(hotelBranche);
        } while (rs.next());
        return hotelBranches;
    }

}
