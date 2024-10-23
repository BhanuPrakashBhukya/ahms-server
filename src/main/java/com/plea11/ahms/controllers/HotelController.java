package com.plea11.ahms.controllers;

import com.plea11.ahms.common.exception.AppServerException;
import com.plea11.ahms.common.translator.IModelTranslator;
import com.plea11.ahms.models.Hotels;
import com.plea11.ahms.modeltranslator.HotelModelTranslator;
import com.plea11.ahms.restmodels.HotelRM;
import com.plea11.ahms.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhukyabhanuprakash
 */

@RestController
@RequestMapping("/hotel/v1")
public class HotelController {

    @Autowired
    HotelService hotelService;

    IModelTranslator<Hotels, HotelRM> modelTranslator = new HotelModelTranslator();

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody HotelRM hotel) throws AppServerException {
        hotelService.register(modelTranslator.getDBModel(hotel));
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/hotels")
    public ResponseEntity<List<HotelRM>> getAllHotels(Hotels hotels, Authentication authentication) throws AppServerException {
        List<Hotels> hotelsList = hotelService.getAllHotels(hotels, authentication);
        List<HotelRM> hotelRM = new ArrayList<HotelRM>();
        for (Hotels hotel : hotelsList) {
            hotelRM.add(modelTranslator.getRESTModel(hotel));
        }
        return new ResponseEntity<List<HotelRM>>(hotelRM, HttpStatus.OK);
    }

    @PutMapping("/changepassword")
    public ResponseEntity<Void> changePassword(@RequestBody HotelRM hotel, Authentication authentication) throws AppServerException {
        hotelService.changePassword(modelTranslator.getDBModel(hotel), authentication);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
