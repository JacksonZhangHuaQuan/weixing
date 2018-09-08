package org.lanqiao.entity;

import java.io.Serializable;
import java.util.Date;

public class GroupChat implements Serializable {
    private int group_id;
    private int user_id;
    private String message;
    private Date messagetime;

    public GroupChat() {
    }

    public GroupChat(int group_id, int user_id, String message) {
        this.group_id = group_id;
        this.user_id = user_id;
        this.message = message;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getMessagetime() {
        return messagetime;
    }

    public void setMessagetime(Date messagetime) {
        this.messagetime = messagetime;
    }
}
