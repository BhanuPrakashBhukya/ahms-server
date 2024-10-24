package com.plea11.ahms.dao;

import com.plea11.ahms.common.exception.DAOException;
import com.plea11.ahms.models.Hotels;

import java.util.List;

/**
 * @author bhukyabhanuprakash
 */

public interface HotelDao {

    Hotels register(Hotels hotel) throws DAOException;

    List<Hotels> getAllHotels(Hotels principal) throws DAOException;

    Hotels changePassword(Hotels hotels, Hotels principal) throws DAOException;
}
