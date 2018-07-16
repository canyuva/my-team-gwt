package com.myTeam.server.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue
    private int pk_user_id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "SURNAME")
    private String surname;
    @Basic
    @Column(name = "CITY")
    private String city;
    @Basic
    @Column(name = "GENDER")
    private String gender;
    @Basic
    @Column(name = "FK_TEAM_ID")
    private int fk_team_id;
}
