package com.plea11.ahms.modeltranslator;

import com.plea11.ahms.common.translator.AbstractModelTranslator;
import com.plea11.ahms.models.LogIn;
import com.plea11.ahms.restmodels.LogInRM;

/**
 * @author bhukyabhanuprakash
 */

public class LoginModelTranslator extends AbstractModelTranslator<LogIn, LogInRM> {

    @Override
    public LogIn getDBModel(LogInRM restModel) {
        LogIn dbModel = new LogIn();

        dbModel.setEmail(restModel.getEmail());
        dbModel.setPassword(restModel.getPassword());
        dbModel.setPhoneNumber(restModel.getPhoneNumber());
        dbModel.setUniqueId(restModel.getUniqueId());

        return dbModel;
    }

    @Override
    public LogInRM getRESTModel(LogIn dbModel) {
        LogInRM restModel = new LogInRM();

        restModel.setEmail(dbModel.getEmail());
        restModel.setPassword(dbModel.getPassword());
        restModel.setPhoneNumber(dbModel.getPhoneNumber());
        restModel.setUniqueId(dbModel.getUniqueId());

        return restModel;
    }
}
