package org.lanqiao.entity;


import java.sql.Date;

public class Strategy_Bruce {
    private int strategy_id;
    private  int user_id;
    private String strategy_title;
    private  String strategy_firstimg;
    private Date strategy_date;
    private int strategy_days;
    private String strategy_address;
    private int strategy_money;
    private String strategy_type;
    private  String strategy_season;
    private  String strategy_describe;
    private String strategy_photos;
    private  String strategy_status;
    public int strategy_score;

    public Strategy_Bruce(){}

    public Strategy_Bruce(int user_id, String strategy_title, String strategy_firstimg, Date strategy_date, int strategy_days, String strategy_address, int strategy_money, String strategy_type, String strategy_season, String strategy_describe, String strategy_photos, int strategy_score) {
        this.user_id = user_id;
        this.strategy_title = strategy_title;
        this.strategy_firstimg = strategy_firstimg;
        this.strategy_date= strategy_date;
        this.strategy_days = strategy_days;
        this.strategy_address = strategy_address;
        this.strategy_money = strategy_money;
        this.strategy_type = strategy_type;
        this.strategy_season = strategy_season;
        this.strategy_describe = strategy_describe;
        this.strategy_photos = strategy_photos;
        this.strategy_score = strategy_score;
    }

    public int getStrategy_id() {
        return strategy_id;
    }

    public void setStrategy_id(int strategy_id) {
        this.strategy_id = strategy_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStrategy_title() {
        return strategy_title;
    }

    public void setStrategy_title(String strategy_title) {
        this.strategy_title = strategy_title;
    }

    public String getStrategy_firstimg() {
        return strategy_firstimg;
    }

    public void setStrategy_firstimg(String strategy_firstimg) {
        this.strategy_firstimg = strategy_firstimg;
    }

    public Date getStrategy_date() {
        return strategy_date;
    }

    public void setStrategy_date(Date strategy_date) {
        this.strategy_date = strategy_date;
    }

    public int getStrategy_days() {
        return strategy_days;
    }

    public void setStrategy_days(int strategy_days) {
        this.strategy_days = strategy_days;
    }

    public String getStrategy_address() {
        return strategy_address;
    }

    public void setStrategy_address(String strategy_address) {
        this.strategy_address = strategy_address;
    }

    public int getStrategy_money() {
        return strategy_money;
    }

    public void setStrategy_money(int strategy_money) {
        this.strategy_money = strategy_money;
    }

    public String getStrategy_type() {
        return strategy_type;
    }

    public void setStrategy_type(String strategy_type) {
        this.strategy_type = strategy_type;
    }

    public String getStrategy_season() {
        return strategy_season;
    }

    public void setStrategy_season(String strategy_season) {
        this.strategy_season = strategy_season;
    }

    public String getStrategy_describe() {
        return strategy_describe;
    }

    public void setStrategy_describe(String strategy_describe) {
        this.strategy_describe = strategy_describe;
    }

    public String getStrategy_photos() {
        return strategy_photos;
    }

    public void setStrategy_photos(String strategy_photos) {
        this.strategy_photos = strategy_photos;
    }

    public String getStrategy_status() {
        return strategy_status;
    }

    public void setStrategy_status(String strategy_status) {
        this.strategy_status = strategy_status;
    }

    public int getStrategy_score() {
        return strategy_score;
    }

    public void setStrategy_score(int strategy_score) {
        this.strategy_score = strategy_score;
    }
}
