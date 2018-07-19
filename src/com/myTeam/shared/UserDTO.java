package com.myTeam.shared;

import lombok.Data;

import java.io.Serializable;


public class UserDTO implements Serializable {
    private int pk_user_id;

    private String name;

    private String surname;

    private String city;

    private String gender;

    private int fk_team_id;

    public int getPk_user_id() {
        return pk_user_id;
    }

    public void setPk_user_id(int pk_user_id) {
        this.pk_user_id = pk_user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getFk_team_id() {
        return fk_team_id;
    }

    public void setFk_team_id(int fk_team_id) {
        this.fk_team_id = fk_team_id;
    }
}
