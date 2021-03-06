package com.myTeam.server.entities;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TEAM")
public class Team implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_team_id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "CITY")
    private String city;
    @Basic
    @Column(name = "RANKING")
    private int ranking;
    @Basic
    @Column
    private int fk_category_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_CATEGORY_ID")
    private Category category;
}
