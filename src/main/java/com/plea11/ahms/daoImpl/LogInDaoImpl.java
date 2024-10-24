package com.plea11.ahms.daoImpl;

import com.plea11.ahms.common.exception.DAOException;
import com.plea11.ahms.dao.LogInDao;
import com.plea11.ahms.models.Hotels;
import com.plea11.ahms.rowmapper.HotelRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author bhukyabhanuprakash
 */

@Repository
public class LogInDaoImpl implements LogInDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static String SELECT_HOTEL_BY_ID = "SELECT * FROM t_hotels WHERE f_id = ?";

    @Override
    public Optional<Hotels> findHotelByUniqueId(String uniqueId) throws DAOException {
        Object[] args = new Object[] { Integer.parseInt(uniqueId) };
        Hotels hotel = null;
        try {
            hotel = jdbcTemplate.queryForObject(SELECT_HOTEL_BY_ID, new HotelRowMapper(), args).get(0);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        } catch (Exception e) {
            throw new DAOException("Internal server error", e);
        }
        return Optional.of(hotel);
    }
}
