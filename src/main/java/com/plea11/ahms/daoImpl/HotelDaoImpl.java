package com.plea11.ahms.daoImpl;

import com.plea11.ahms.common.exception.DAOException;
import com.plea11.ahms.dao.HotelDao;
import com.plea11.ahms.models.Country;
import com.plea11.ahms.models.HotelBranches;
import com.plea11.ahms.models.Hotels;
import com.plea11.ahms.models.States;
import com.plea11.ahms.rowmapper.CountryRowMapper;
import com.plea11.ahms.rowmapper.HotelBranchesRowMapper;
import com.plea11.ahms.rowmapper.HotelRowMapper;
import com.plea11.ahms.rowmapper.StatesRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

/**
 * @author bhukyabhanuprakash
 */

@Repository
public class HotelDaoImpl implements HotelDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    PlatformTransactionManager transactionManager;

    public static String INSERT_INTO_HOTELS = "INSERT INTO T_HOTELS ( F_NAME, F_MOBILE_NUMBER, F_EMAIL, F_PASSWORD, F_CATEGORY, "
            + "F_ADDRESS_FIRST_LINE, F_ADDRESS_SECOND_LINE, F_CITY, F_STATE_ID, F_COUNTRY_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static String SELECT_HOTELS = "SELECT * FROM t_hotels ORDER BY f_created_timestamp";

    private static String UPDATE_PASSWORD = "UPDATE t_hotels SET f_password = ? WHERE f_id = ?";

    private static String SELECT_COUNTRIES = "SELECT * FROM t_countries ORDER BY f_name ASC";

    private static String SELECT_STATES = "SELECT * FROM t_states ORDER BY f_name ASC";

    private static String SELECT_FROM_HOTEL_BRANCHES = "SELECT * FROM t_branches ORDER BY f_id DESC";

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
                ps.setString(9, hotel.getPinCode());
                ps.setLong(10, hotel.getState());
                ps.setLong(11, hotel.getCountry());

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

    @Override
    public Hotels changePassword(Hotels hotels, Hotels hotel) throws DAOException {
        Object[] args = new Object[] { hotels.getPassword(), hotels.getId() };
        try {
            int rowUpdated = jdbcTemplate.update(UPDATE_PASSWORD, args);
        } catch (DataAccessException e) {
            throw new DAOException("Error updating hotel password", e);
        }
        return null;
    }

    @Override
    public List<Country> getCountries() throws DAOException {
        Object[] args = new Object[] {  };
        List<Country> countries = new ArrayList<Country>();
        try {
            countries = jdbcTemplate.queryForObject(SELECT_COUNTRIES, new CountryRowMapper(), args);
        } catch (EmptyResultDataAccessException e) {
            throw new DAOException("No countries to fetch", e);
        } catch (Exception e) {
            throw new DAOException("Internal server error", e);
        }
        return countries;
    }

    @Override
    public List<States> getStates() throws DAOException {
        Object[] args = new Object[] {  };
        List<States> states = new ArrayList<States>();
        try {
            states = jdbcTemplate.queryForObject(SELECT_STATES, new StatesRowMapper(), args);
        } catch (EmptyResultDataAccessException e) {
            throw new DAOException("No states to fetch", e);
        } catch (Exception e) {
            throw new DAOException("Internal server error", e);
        }
        return states;
    }

    @Override
    public List<HotelBranches> getAllBranches(Hotels hotel) throws DAOException {
        Object[] args = new Object[] {  };
        List<HotelBranches> branches = new ArrayList<HotelBranches>();
        try {
            branches = jdbcTemplate.queryForObject(SELECT_FROM_HOTEL_BRANCHES, new HotelBranchesRowMapper(), args);
        }catch (EmptyResultDataAccessException e) {

        } catch (Exception e) {
            throw new DAOException("Internal server error", e);
        }
        return branches;
    }

}
