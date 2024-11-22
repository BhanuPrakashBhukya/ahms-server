package com.plea11.ahms.modeltranslator;

import com.plea11.ahms.common.translator.AbstractModelTranslator;
import com.plea11.ahms.models.HotelBranches;
import com.plea11.ahms.restmodels.HotelBranchesRM;

public class HotelBranchesModelTranslator extends AbstractModelTranslator<HotelBranches, HotelBranchesRM> {

    @Override
    public HotelBranches getDBModel(HotelBranchesRM restModel) {
        HotelBranches dbModel = new HotelBranches();

        dbModel.setName(restModel.getName());
        dbModel.setHotelId(restModel.getHotelId());
        dbModel.setGmail(restModel.getGmail());
        dbModel.setPhoneNumber(restModel.getPhoneNumber());
        dbModel.setAddressfirstLine(restModel.getAddressfirstLine());
        dbModel.setAddresssecondLine(restModel.getAddresssecondLine());
        dbModel.setCity(restModel.getCity());
        dbModel.setStateId(restModel.getStateId());
        dbModel.setCountryId(restModel.getCountryId());
        dbModel.setZipCode(restModel.getZipCode());
        dbModel.setTotal(restModel.getTotal());
        dbModel.setNonSuite(restModel.getNonSuite());
        dbModel.setSuite(restModel.getSuite());
        dbModel.setNonSuiteAvailable(restModel.getNonSuiteAvailable());
        dbModel.setSuiteAvailable(restModel.getSuiteAvailable());

        return dbModel;
    }

    @Override
    public HotelBranchesRM getRESTModel(HotelBranches dbModel) {
        HotelBranchesRM restModel = new HotelBranchesRM();

        restModel.setId(dbModel.getId());
        restModel.setHotelId(dbModel.getHotelId());
        restModel.setHotelName(dbModel.getHotelName());
        restModel.setName(dbModel.getName());
        restModel.setGmail(dbModel.getGmail());
        restModel.setPhoneNumber(dbModel.getPhoneNumber());
        restModel.setAddress(dbModel.getAddressfirstLine() + " " + dbModel.getAddresssecondLine() + " " + dbModel.getCity() + " " + dbModel.getState() + " " + dbModel.getCountry() + "-" + dbModel.getZipCode());
        restModel.setTotal(dbModel.getTotal());
        restModel.setNonSuite(dbModel.getNonSuite());
        restModel.setSuite(dbModel.getSuite());
        restModel.setNonSuiteAvailable(dbModel.getNonSuiteAvailable());
        restModel.setSuiteAvailable(dbModel.getSuiteAvailable());

        return restModel;
    }

}
