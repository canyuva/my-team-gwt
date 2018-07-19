package com.myTeam.server.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CATEGORY")
public class Category{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_cat_id;
    @Basic
    @Column(name = "CAT_NAME")
    private String cat_name;


}
