package com.myTeam.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public interface MyTeamServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);

    void getTeams(AsyncCallback<List<String>> async);
}
