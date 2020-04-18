package com.liuzlin.springbootdemo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "小孩")
public class ChildVO {

    @ApiModelProperty("用户小孩Id")
    private Long childId;
    @ApiModelProperty(value = "用户小孩名称", required = true)
    private String childName;

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }
}
