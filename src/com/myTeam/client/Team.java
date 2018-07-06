package com.myTeam.client;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;

public class Team implements Serializable,IsSerializable {
    private int id;
    private String name;
    private String city;
    private int ranking;
    private int category_id;

    public void Team(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void Team(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
