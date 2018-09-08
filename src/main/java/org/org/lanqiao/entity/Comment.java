package org.lanqiao.entity;

import java.util.Date;

public class Comment {
    public int comment_id;
    public int strategy_id;
    public int user_id;
    public  String comment_content;
    public Date comment_date;
    public int comment_num;
    public String user_name;

    public Comment() {
    }

    public Comment(int strategy_id, String comment_content, int comment_num,int user_id,String user_name) {
        this.strategy_id = strategy_id;
        this.comment_content = comment_content;
        this.comment_num = comment_num;
        this.user_id=user_id;
        this.user_name=user_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
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

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }

    public int getComment_num() {
        return comment_num;
    }

    public void setComment_num(int comment_num) {
        this.comment_num = comment_num;
    }
}
