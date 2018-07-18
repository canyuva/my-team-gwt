package com.myTeam.shared;

import lombok.Data;

@Data
public class UserDTO {
    private int pk_user_id;

    private String name;

    private String surname;

    private String city;

    private String gender;

    private int fk_team_id;
}
