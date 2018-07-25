package com.myTeam.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.myTeam.server.entities.Team;
import com.myTeam.shared.CategoryDTO;
import com.myTeam.shared.TeamDTO;
import com.myTeam.shared.UserDTO;

import java.util.List;

public interface MyTeamServiceAsync {


    void getCategories(AsyncCallback<List<CategoryDTO>> async);

    void getTeamswithCategory(int selectedIndex, AsyncCallback<List<TeamDTO>> async);

    void sendInformation(UserDTO userDTO, AsyncCallback<Void> async);

    void getUsers(AsyncCallback<List<UserDTO>> async);
}
