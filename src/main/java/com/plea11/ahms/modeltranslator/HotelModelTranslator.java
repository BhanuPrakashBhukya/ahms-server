package com.plea11.ahms.modeltranslator;

import com.plea11.ahms.common.translator.AbstractModelTranslator;
import com.plea11.ahms.models.Hotels;
import com.plea11.ahms.restmodels.HotelRM;

public class HotelModelTranslator extends AbstractModelTranslator<Hotels, HotelRM> {

    @Override
    public Hotels getDBModel(HotelRM restModel)  {
        Hotels dbModel = new Hotels();

        dbModel.setId(restModel.getId());
        dbModel.setName(restModel.getName());
        dbModel.setPhone(restModel.getPhone());
        dbModel.setEmail(restModel.getEmail());
        dbModel.setPassword(restModel.getPassword());
        dbModel.setCategory(restModel.getCategory());
        dbModel.setAddressFirstLine(restModel.getAddressFirstLine());
        dbModel.setAddressSecondLine(restModel.getAddressSecondLine());
        dbModel.setCity(restModel.getCity());
        dbModel.setState(restModel.getState());
        dbModel.setCountry(restModel.getCountry());
        dbModel.setRoles(restModel.getRoles());

        return dbModel;
    }

    @Override
    public HotelRM getRESTModel(Hotels dbModel) {
        HotelRM restModel = new HotelRM();

        restModel.setId(dbModel.getId());
        restModel.setName(dbModel.getName());
        restModel.setPhone(dbModel.getPhone());
        restModel.setEmail(dbModel.getEmail());
        restModel.setPassword(dbModel.getPassword());
        restModel.setCategory(dbModel.getCategory());
        restModel.setAddressFirstLine(dbModel.getAddressFirstLine());
        restModel.setAddressSecondLine(dbModel.getAddressSecondLine());
        restModel.setCity(dbModel.getCity());
        restModel.setState(dbModel.getState());
        restModel.setCountry(dbModel.getCountry());
        restModel.setRoles(dbModel.getRoles());

        return restModel;
    }

}
