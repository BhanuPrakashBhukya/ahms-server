package com.plea11.ahms.common.translator;

import com.plea11.ahms.common.model.BaseDBModel;
import com.plea11.ahms.common.restmodel.BaseRM;

import java.util.*;

/**
 * @author bhukyabhanuprakash
 */
public class AbstractModelTranslator<D extends BaseDBModel, R extends BaseRM> implements IModelTranslator<D, R> {

    protected D dbModel;

    protected R restModel;

    @Override
    public D getDBModel(R rmModel) {
        return this.dbModel;
    }

    @Override
    public R getRESTModel(D dmModel) {
        return this.restModel;
    }

    @Override
    public Collection<D> getDBModels(Collection<R> rmModels) {
        Collection<D> pObjects = null;
        if (rmModels != null && !rmModels.isEmpty()) {
            pObjects = getCollectionOfDInstance(rmModels);
            for (R r : rmModels) {
                pObjects.add(getDBModel(r));
            }
        }
        return pObjects;
    }

    @Override
    public Collection<R> getRESTModels(Collection<D> dbModels) {
        return List.of();
    }

    protected Collection<D> getCollectionOfDInstance(Collection<R> rObjects) {
        if (rObjects instanceof Set) {
            return new HashSet<D>();
        }
        return new ArrayList<D>();
    }

    @Override
    public Collection<R> getRMModels(Collection<D> dbModels) {
        Collection<R> rObjects = null;
        if (dbModels != null && !dbModels.isEmpty()) {
            rObjects = getCollectionOfRInstance(dbModels);
            for (D d : dbModels) {
                rObjects.add(getRESTModel(d));
            }
        }
        return rObjects;
    }

    protected Collection<R> getCollectionOfRInstance(Collection<D> dbModels) {
        if (dbModels instanceof Set) {
            return new HashSet<R>();
        }
        return new ArrayList<R>();
    }
}
