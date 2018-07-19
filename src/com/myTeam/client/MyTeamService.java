package com.myTeam.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.myTeam.shared.CategoryDTO;
import com.myTeam.shared.TeamDTO;
import com.myTeam.shared.UserDTO;

import java.util.List;

@RemoteServiceRelativePath("MyTeamService")
public interface MyTeamService extends RemoteService {
    // Sample interface method of remote interface
    List<TeamDTO> getTeamswithCategory(int selectedIndex);
    List<CategoryDTO> getCategories();
    void sendInformation(UserDTO userDTO);
}
