package org.lanqiao.entity;


import java.util.Date;

public class User {
    private int user_id;
    private String user_name;
    private String user_passw;
    private String user_phone;
    private Date user_birthday;
    private String user_gender;
    private  Date user_regtime;
    private String user_role;
    private String user_photo;
    private  String user_pet_name;
    private  String user_introduce;
    private  Date user_locktime;

    public User(){

    }
    public User(int user_id,String user_name,String user_passw,String user_phone){
        this.user_id=user_id;
        this.user_name=user_name;
        this.user_passw=user_passw;
        this.user_phone=user_phone;

    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_passw() {
        return user_passw;
    }

    public void setUser_passw(String user_passw) {
        this.user_passw = user_passw;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public Date getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(Date user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }

    public Date getUser_regtime() {
        return user_regtime;
    }

    public void setUser_regtime(Date user_regtime) {
        this.user_regtime = user_regtime;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public String getUser_pet_name() {
        return user_pet_name;
    }

    public void setUser_pet_name(String user_pet_name) {
        this.user_pet_name = user_pet_name;
    }

    public String getUser_introduce() {
        return user_introduce;
    }

    public void setUser_introduce(String user_introduce) {
        this.user_introduce = user_introduce;
    }

    public Date getUser_locktime() { return user_locktime; }

    public void setUser_locktime(Date user_locktime) { this.user_locktime = user_locktime; }
}

