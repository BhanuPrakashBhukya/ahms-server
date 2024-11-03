package com.plea11.ahms.modeltranslator;

import com.plea11.ahms.common.translator.AbstractModelTranslator;
import com.plea11.ahms.models.Country;
import com.plea11.ahms.restmodels.CountryRM;

/**
 * @author bhukyabhanuprakash
 * */

public class CountryModelTranslator extends AbstractModelTranslator<Country, CountryRM> {

    @Override
    public Country getDBModel(CountryRM restModel) {
        Country dbModel = new Country();

        dbModel.setId(restModel.getId());
        dbModel.setName(restModel.getName());

        return dbModel;
    }

    @Override
    public CountryRM getRESTModel(Country dbModel) {
        CountryRM restModel = new CountryRM();

        restModel.setId(dbModel.getId());
        restModel.setName(dbModel.getName());

        return restModel;
    }

}
