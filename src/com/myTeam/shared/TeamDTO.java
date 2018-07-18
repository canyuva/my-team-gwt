package com.myTeam.shared;

import lombok.Data;

@Data
public class TeamDTO{

    private int pk_team_id;

    private String name;

    private String city;

    private int ranking;

    private int fk_category_id;
}
