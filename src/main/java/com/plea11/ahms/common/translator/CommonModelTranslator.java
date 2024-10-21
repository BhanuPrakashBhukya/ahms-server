package com.plea11.ahms.common.translator;

import com.plea11.ahms.common.model.CommonObject;
import com.plea11.ahms.common.restmodel.CommonRM;

/**
 * @author bhukyabhanuprakash
 */
public class CommonModelTranslator<D extends CommonObject, R extends CommonRM> extends AbstractModelTranslator<D, R> implements IModelTranslator<D, R> {

    @Override
    public D getDBModel(R restModel) {
        this.dbModel = super.getDBModel(restModel);
        return dbModel;
    }

    @Override
    public R getRESTModel(D dbModel) {
        this.restModel = super.getRESTModel(dbModel);
        return restModel;
    }
}