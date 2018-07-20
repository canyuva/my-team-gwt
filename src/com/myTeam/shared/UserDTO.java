package com.myTeam.shared;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private int pk_user_id;

    private String name;

    private String surname;

    private String city;

    private String gender;

    private int fk_team_id;
}
