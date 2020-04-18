package com.liuzlin.springbootdemo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户")
public class UserVO {

    @ApiModelProperty("用户Id")
    private Long userId;
    @ApiModelProperty(value = "名称", required = true)
    private String userName;
    @ApiModelProperty("年龄")
    private Integer age;
    @ApiModelProperty("地址")
    private String address;
    @ApiModelProperty("用户小孩")
    private ChildVO childVO;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ChildVO getChildVO() {
        return childVO;
    }

    public void setChildVO(ChildVO childVO) {
        this.childVO = childVO;
    }
}
