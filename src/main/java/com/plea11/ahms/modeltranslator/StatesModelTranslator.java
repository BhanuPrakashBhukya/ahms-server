package com.plea11.ahms.modeltranslator;

import com.plea11.ahms.common.translator.AbstractModelTranslator;
import com.plea11.ahms.models.States;
import com.plea11.ahms.restmodels.StatesRM;

/**
 * @author bhukyabhanuprakash
 * */

public class StatesModelTranslator extends AbstractModelTranslator<States, StatesRM> {

    @Override
    public States getDBModel(StatesRM restModel) {
        States dbModel = new States();

        dbModel.setId(restModel.getId());
        dbModel.setName(restModel.getName());

        return dbModel;
    }

    @Override
    public StatesRM getRESTModel(States dbModel) {
        StatesRM restModel = new StatesRM();

        restModel.setId(dbModel.getId());
        restModel.setName(dbModel.getName());

        return restModel;
    }
}
