package com.myTeam.shared;


import java.io.Serializable;

public class TeamDTO implements Serializable {

    private int pk_team_id;

    private String name;

    private String city;

    private int ranking;

    private int fk_category_id;

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

    public int getFk_category_id() {
        return fk_category_id;
    }

    public void setFk_category_id(int fk_category_id) {
        this.fk_category_id = fk_category_id;
    }
    public int getPk_team_id() {
        return pk_team_id;
    }

    public void setPk_team_id(int pk_team_id) {
        this.pk_team_id = pk_team_id;
    }

}
