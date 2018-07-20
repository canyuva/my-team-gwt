package com.myTeam;

import com.myTeam.server.entities.Category;
import com.myTeam.server.entities.Team;
import com.myTeam.server.entities.User;
import com.myTeam.shared.CategoryDTO;
import com.myTeam.shared.TeamDTO;
import com.myTeam.shared.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

public final class Conversion {

    public static Conversion convert = null;

    public synchronized static Conversion getConvert(){
        if(convert == null){
            convert = new Conversion();
        }
        return convert;
    }

    public TeamDTO fromEntitytToTeamDTO (Team team){
        TeamDTO team_dto = new TeamDTO();

        team_dto.setPk_team_id(team.getPk_team_id());
        team_dto.setName(team.getName());
        team_dto.setFk_category_id(team.getFk_category_id());
        team_dto.setRanking(team.getRanking());
        team_dto.setCity(team.getCity());

        return team_dto;
    }

    public Team fromDTOtoTeamEntity (TeamDTO team_dto){
        Team team = new Team();

        team.setPk_team_id(team_dto.getPk_team_id());
        team.setName(team_dto.getName());
        team.setCity(team_dto.getCity());
        team.setFk_category_id(team_dto.getFk_category_id());
        team.setRanking(team_dto.getRanking());

        return team;
    }

    public CategoryDTO fromEntityToCatDTO (Category cat){
        CategoryDTO cat_dto = new CategoryDTO();

        cat_dto.setCat_name(cat.getCat_name());
        cat_dto.setPk_cat_id(cat.getPk_cat_id());

        return cat_dto;
    }

    public Category fromDTOtoCatEntity(CategoryDTO cat_dto){
        Category cat = new Category();

        cat.setPk_cat_id(cat_dto.getPk_cat_id());
        cat.setCat_name(cat_dto.getCat_name());

        return cat;
    }

    public UserDTO fromEntityToUserDTO(User user){
        UserDTO user_dto = new UserDTO();

        user_dto.setPk_user_id(user.getPk_user_id());
        user_dto.setName(user.getName());
        user_dto.setSurname(user.getSurname());
        user_dto.setGender(user.getGender());
        user_dto.setCity(user.getCity());
        user_dto.setFk_team_id(user.getFk_team_id());

        return user_dto;
    }

    public User fromDTOtoUser (UserDTO user_dto){
        User user = new User();

        user.setPk_user_id(user_dto.getPk_user_id());
        user.setName(user_dto.getName());
        user.setSurname(user_dto.getSurname());
        user.setCity(user_dto.getCity());
        user.setGender(user_dto.getGender());
        user.setFk_team_id(user_dto.getFk_team_id());

        return user;
    }

    public List<TeamDTO> fromTeamToDTO (List<Team> teamList){
        return teamList.stream().map(this::fromEntitytToTeamDTO).collect(Collectors.toList());
    }

    public List<CategoryDTO> fromCategoryToDTO (List<Category> catList){
        return catList.stream().map(this::fromEntityToCatDTO).collect(Collectors.toList());
    }


}
