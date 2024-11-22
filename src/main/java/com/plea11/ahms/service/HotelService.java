package com.plea11.ahms.service;

import com.plea11.ahms.common.exception.AppServerException;
import com.plea11.ahms.models.Country;
import com.plea11.ahms.models.HotelBranches;
import com.plea11.ahms.models.Hotels;
import com.plea11.ahms.models.States;
import com.plea11.ahms.restmodels.HotelRM;
import org.springframework.security.core.Authentication;

import java.util.List;

/**
 * @author bhukyabhanuprakash
 */

public interface HotelService {

    Hotels register(Hotels hotel) throws AppServerException;

    List<Hotels> getAllHotels(Hotels hotels, Authentication authentication) throws AppServerException;

    Hotels changePassword(Hotels dbModel, Authentication authentication) throws AppServerException;

    List<Country> getCountries() throws AppServerException;

    List<States> getStates() throws AppServerException;

    List<HotelBranches> getAllBranches(Hotels hotel, Authentication authentication) throws AppServerException;
}
