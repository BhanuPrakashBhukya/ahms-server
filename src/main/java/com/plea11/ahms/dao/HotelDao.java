package com.plea11.ahms.dao;

import com.plea11.ahms.common.exception.DAOException;
import com.plea11.ahms.models.Country;
import com.plea11.ahms.models.HotelBranches;
import com.plea11.ahms.models.Hotels;
import com.plea11.ahms.models.States;

import java.util.List;

/**
 * @author bhukyabhanuprakash
 */

public interface HotelDao {

    Hotels register(Hotels hotel) throws DAOException;

    List<Hotels> getAllHotels(Hotels principal) throws DAOException;

    Hotels changePassword(Hotels hotels, Hotels principal) throws DAOException;

    List<Country> getCountries() throws DAOException;

    List<States> getStates() throws DAOException;

    List<HotelBranches> getAllBranches(Hotels hotel) throws DAOException;
}
