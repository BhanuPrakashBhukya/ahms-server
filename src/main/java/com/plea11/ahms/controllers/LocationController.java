package com.plea11.ahms.controllers;

import com.plea11.ahms.common.exception.AppServerException;
import com.plea11.ahms.common.translator.IModelTranslator;
import com.plea11.ahms.models.Country;
import com.plea11.ahms.models.States;
import com.plea11.ahms.modeltranslator.CountryModelTranslator;
import com.plea11.ahms.modeltranslator.StatesModelTranslator;
import com.plea11.ahms.restmodels.CountryRM;
import com.plea11.ahms.restmodels.StatesRM;
import com.plea11.ahms.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhukyabhanuprakash
 * */

@RestController
@RequestMapping("/hotel/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class LocationController {

    private final Logger log = LoggerFactory.getLogger(LocationController.class);

    IModelTranslator<Country, CountryRM> countryModelTranslator = new CountryModelTranslator();
    IModelTranslator<States, StatesRM> statesModelTranslator = new StatesModelTranslator();

    @Autowired
    HotelService hotelService;

    @GetMapping("/countries")
    public ResponseEntity<List<CountryRM>> getCountries() throws AppServerException {
        List<CountryRM> countryRM = new ArrayList<CountryRM>();
        List<Country> countries = hotelService.getCountries();
        for (Country country : countries) {
            countryRM.add(countryModelTranslator.getRESTModel(country));
        }
        return new ResponseEntity<List<CountryRM>>(countryRM, HttpStatus.OK);
    }

    @GetMapping("/states")
    public ResponseEntity<List<StatesRM>> getStates() throws AppServerException {
        List<StatesRM> statesRM = new ArrayList<StatesRM>();
        List<States> states = hotelService.getStates();
        for (States state : states) {
            statesRM.add(statesModelTranslator.getRESTModel(state));
        }
        return new ResponseEntity<List<StatesRM>>(statesRM, HttpStatus.OK);
    }
}
