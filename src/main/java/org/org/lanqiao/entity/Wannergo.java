package org.lanqiao.entity;

public class Wannergo {
    public int user_id;
    public int strategy_id1;
    public int wanner_id;
    public Wannergo(){}
    public Wannergo(int user_id, int strategy_id1) {
        this.user_id = user_id;
        this.strategy_id1 = strategy_id1;
    }

    public int getWanner_id() {
        return wanner_id;
    }

    public void setWanner_id(int wanner_id) {
        this.wanner_id = wanner_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getStartegy_id1() {
        return strategy_id1;
    }

    public void setStartegy_id1(int startegy_id1) {
        this.strategy_id1 = startegy_id1;
    }

}
