package org.lanqiao.entity;

public class Place {

    private int place_id;
    private int strategy_id;
    private String place_name;
    private String place_description;

    public Place() {
    }

    public Place(int place_id, int strategy_id, String place_name, String place_description) {
        this.place_id = place_id;
        this.strategy_id = strategy_id;
        this.place_name = place_name;
        this.place_description = place_description;
    }
    public Place( int strategy_id, String place_name, String place_description) {
        this.strategy_id = strategy_id;
        this.place_name = place_name;
        this.place_description = place_description;
    }
    public Place(String place_name, String place_description,int place_id) {
        this.place_id = place_id;
        this.place_name = place_name;
        this.place_description = place_description;
    }
    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public int getStrategy_id() {
        return strategy_id;
    }

    public void setStrategy_id(int strategy_id) {
        this.strategy_id = strategy_id;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getPlace_description() {
        return place_description;
    }

    public void setPlace_description(String place_description) {
        this.place_description = place_description;
    }
}
