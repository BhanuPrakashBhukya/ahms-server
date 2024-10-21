package com.plea11.ahms.daoImpl;

import com.plea11.ahms.common.exception.DAOException;
import com.plea11.ahms.dao.HotelDao;
import com.plea11.ahms.models.Hotels;
import com.plea11.ahms.rowmapper.HotelRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HotelDaoImpl implements HotelDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    PlatformTransactionManager transactionManager;

    public static String INSERT_INTO_HOTELS = "INSERT INTO T_HOTELS ( F_NAME, F_MOBILE_NUMBER, F_EMAIL, F_PASSWORD, F_CATEGORY, "
            + "F_ADDRESS_FIRST_LINE, F_ADDRESS_SECOND_LINE, F_CITY, F_STATE_ID, F_COUNTRY_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static String SELECT_HOTELS = "SELECT * FROM t_hotels ORDER BY f_created_timestamp";

    @Override
    public Hotels register(Hotels hotel) throws DAOException {

        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        KeyHolder keyHolder = new GeneratedKeyHolder();

        try {
            jdbcTemplate.update(conn -> {
                var ps = conn.prepareStatement(INSERT_INTO_HOTELS, new String[]{"f_id"});
                ps.setString(1, hotel.getName());
                ps.setString(2, hotel.getPhone());
                ps.setString(3, hotel.getEmail());
                ps.setString(4, hotel.getPassword());
                ps.setInt(5, hotel.getCategory());
                ps.setString(6, hotel.getAddressFirstLine());
                ps.setString(7, hotel.getAddressSecondLine());
                ps.setString(8, hotel.getCity());
                ps.setLong(9, hotel.getState());
                ps.setLong(10, hotel.getCountry());

                return ps;
            }, keyHolder);
            transactionManager.commit(status);
            hotel.setId(keyHolder.getKey().intValue());
            return hotel;
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw new DAOException("Error registering hotel", e);
        }
    }

    @Override
    public List<Hotels> getAllHotels(Hotels hotels) throws DAOException {
        Object[] args = new Object[] {  };
        List<Hotels> hotelsList = new ArrayList<Hotels>();
        try {
            hotelsList = jdbcTemplate.queryForObject(SELECT_HOTELS, new HotelRowMapper(), args);
        } catch (EmptyResultDataAccessException e) {
            throw new DAOException("No hotels to show", e);
        } catch (Exception e) {
            throw new DAOException("Internal server error", e);
        }
        return hotelsList;
    }

}
