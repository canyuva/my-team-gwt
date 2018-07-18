package com.myTeam.server.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable{

    @Id
    @GeneratedValue
    private int pk_cat_id;
    @Basic
    @Column(name = "CAT_NAME")
    private String cat_name;


}
