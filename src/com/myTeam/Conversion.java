package com.myTeam;

import com.myTeam.server.entities.Category;
import com.myTeam.server.entities.Team;
import com.myTeam.server.entities.User;
import com.myTeam.shared.CategoryDTO;
import com.myTeam.shared.TeamDTO;
import com.myTeam.shared.UserDTO;

public final class Conversion {

    public TeamDTO teamDTO (Team team){
        TeamDTO team_dto = new TeamDTO();

        team_dto.setPk_team_id(team.getPk_team_id());
        team_dto.setName(team.getName());
        team_dto.setFk_category_id(team.getFk_category_id());
        team_dto.setRanking(team.getRanking());
        team_dto.setCity(team.getCity());

        return team_dto;
    }

    public CategoryDTO catDTO (Category cat){
        CategoryDTO cat_dto = new CategoryDTO();

        cat_dto.setCat_name(cat.getCat_name());
        cat_dto.setPk_cat_id(cat.getPk_cat_id());

        return cat_dto;
    }

    public UserDTO userDTO(User user){
        UserDTO user_dto = new UserDTO();

        user_dto.setPk_user_id(user.getPk_user_id());
        user_dto.setName(user.getName());
        user_dto.setSurname(user.getSurname());
        user_dto.setGender(user.getGender());
        user_dto.setCity(user.getCity());
        user_dto.setFk_team_id(user.getFk_team_id());

        return user_dto;
    }


}
