package com.myTeam.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.myTeam.server.entities.Team;

import java.util.List;

@RemoteServiceRelativePath("MyTeamService")
public interface MyTeamService extends RemoteService {
    // Sample interface method of remote interface
    List<Team> getTeamswithCategory(int selectedIndex);
    List<String> getCategories();
    String sendInformation(String name, String surname, String city, String gender, int team_id) throws Exception;
}
