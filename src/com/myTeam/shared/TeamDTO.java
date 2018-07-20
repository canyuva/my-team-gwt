package com.myTeam.shared;


import lombok.Data;

import java.io.Serializable;

@Data
public class TeamDTO implements Serializable {

    private int pk_team_id;

    private String name;

    private String city;

    private int ranking;

    private int fk_category_id;

}
