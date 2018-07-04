package com.myTeam.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

@RemoteServiceRelativePath("MyTeamService")
public interface MyTeamService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);
    List<String> getTeamswithCategory(int selectedIndex) throws Exception;
    List<String> getCategories() throws Exception;


    public static class App {
        private static MyTeamServiceAsync ourInstance = GWT.create(MyTeamService.class);

        public static synchronized MyTeamServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
