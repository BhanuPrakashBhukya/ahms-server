package com.plea11.ahms.restmodels;

import com.plea11.ahms.common.restmodel.BaseRM;

/**
 * @author bhukyabhanuprakash
 * */

public class StatesRM extends BaseRM {

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
