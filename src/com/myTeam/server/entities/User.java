package com.myTeam.server.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "USER")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column
    private int fk_team_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_TEAM_ID")
    private Team team;
}
