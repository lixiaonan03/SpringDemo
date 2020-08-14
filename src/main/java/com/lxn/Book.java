package com.lxn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.annotation.sql.DataSourceDefinition;

/**
 * Created by lixiaonan on 2019/2/15.
 */
@ApiModel
public class Book {
    @ApiModelProperty(value="用户id",name="id",example="1")
    private String id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
