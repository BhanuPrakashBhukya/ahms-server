package com.plea11.ahms.service;

import com.plea11.ahms.common.exception.AppServerException;
import com.plea11.ahms.models.Hotels;
import com.plea11.ahms.restmodels.HotelRM;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface HotelService {

    Hotels register(Hotels hotel) throws AppServerException;

    List<Hotels> getAllHotels(Hotels hotels, Authentication authentication) throws AppServerException;
}
