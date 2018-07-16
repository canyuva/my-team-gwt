package com.myTeam.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.myTeam.server.entities.Team;

import java.util.List;

public interface MyTeamServiceAsync {


    void getCategories(AsyncCallback<List<String>> async) throws Exception;


    void sendInformation(String name, String surname, String city, String gender, int team_id,
                         AsyncCallback<String> async);

    void getTeamswithCategory(int selectedIndex, AsyncCallback<List<Team>> async);

}
