package com.plea11.ahms.common.translator;

import com.plea11.ahms.common.model.BaseDBModel;
import com.plea11.ahms.common.restmodel.BaseRM;

import java.util.Collection;

/**
 * Interface to define model translator
 * @author bhukyabhanuprakash
 */

public interface IModelTranslator<D extends BaseDBModel, R extends BaseRM> {

    public D getDBModel(R rmModel);

    public R getRESTModel(D dbModel);

    public Collection<D> getDBModels(Collection<R> rmModels);

    public Collection<R> getRESTModels(Collection<D> dbModels);

    Collection<R> getRMModels(Collection<D> dbModels);
}

