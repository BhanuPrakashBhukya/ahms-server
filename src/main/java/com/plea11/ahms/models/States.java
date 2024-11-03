package com.plea11.ahms.models;

import com.plea11.ahms.common.model.BaseDBModel;

/**
 * @author bhukyabhanuprakash
 * */

public class States implements BaseDBModel {

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
