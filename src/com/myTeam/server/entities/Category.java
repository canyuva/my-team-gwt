package com.myTeam.server.entities;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "CATEGORY")
public class Category implements IsSerializable {

    @Id
    @GeneratedValue
    private int pk_cat_id;
    @Basic
    @Column(name = "CAT_NAME")
    private String cat_name;


}
