package com.aitguigu.springbootmybatisquickstart.domain;

import java.io.Serializable;

/**
 * @BelongsProject: springboot-mybatis-quickstart
 * @BelongsPackage: com.aitguigu.springbootmybatisquickstart.domain
 * @Author: Boss_king
 * @CreateTime: 2020-05-11 19:02
 * @Description: 淘宝数据
 */
public class Taobao implements Serializable {
    private String user_id;
    private String item_id;
    private String cat_id;
    private String merchant_id;
    private String brand_id;
    private String month;
    private String day;
    private String action;
    private String age_range;
    private String gender;
    private String province;

    @Override
    public String toString() {
        return "Taobao{" +
                "user_id='" + user_id + '\'' +
                ", item_id='" + item_id + '\'' +
                ", cat_id='" + cat_id + '\'' +
                ", merchant_id='" + merchant_id + '\'' +
                ", brand_id='" + brand_id + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                ", action='" + action + '\'' +
                ", age_range='" + age_range + '\'' +
                ", gender='" + gender + '\'' +
                ", province='" + province + '\'' +
                '}';
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAge_range() {
        return age_range;
    }

    public void setAge_range(String age_range) {
        this.age_range = age_range;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
