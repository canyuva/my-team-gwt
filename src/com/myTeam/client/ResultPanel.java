package com.myTeam.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.myTeam.shared.UserDTO;

import java.util.List;

public class ResultPanel extends VerticalPanel {

    MyTeamServiceAsync mtAsync = GWT.create(MyTeamService.class);


    void init() {

        CellTable<UserDTO> userTable = new CellTable<>();
        Button backButton = new Button("Back");

        TextColumn<UserDTO> userID = new TextColumn<UserDTO>() {
            @Override
            public String getValue(UserDTO user) {
                String id = String.valueOf(user.getPk_user_id());
                return id;
            }
        };

        TextColumn<UserDTO> userName = new TextColumn<UserDTO>() {
            @Override
            public String getValue(UserDTO user) {
                return user.getName();
            }
        };

        TextColumn<UserDTO> userTeam = new TextColumn<UserDTO>() {
            @Override
            public String getValue(UserDTO user) {
                return user.getUserTeam().getName();
            }
        };

        TextColumn<UserDTO> userSurname = new TextColumn<UserDTO>() {
            @Override
            public String getValue(UserDTO user) {
                return user.getSurname();
            }
        };

        TextColumn<UserDTO> userCity = new TextColumn<UserDTO>() {
            @Override
            public String getValue(UserDTO user) {
                return user.getCity();
            }
        };

        TextColumn<UserDTO> userGender = new TextColumn<UserDTO>() {
            @Override
            public String getValue(UserDTO user) {
                return user.getGender();
            }
        };

        userTable.addColumn(userID,"ID");
        userTable.addColumn(userName,"Name");
        userTable.addColumn(userSurname,"Surname");
        userTable.addColumn(userCity,"City");
        userTable.addColumn(userGender,"Gender");
        userTable.addColumn(userTeam,"Team");


        mtAsync.getUsers(new AsyncCallback<List<UserDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                GWT.log("Error while getting user list");
            }

            @Override
            public void onSuccess(List<UserDTO> result) {
                userTable.setRowCount(result.size(),true);
                userTable.setRowData(0,result);
            }
        });

        userTable.setStyleName("resultTable");

        this.add(userTable);
        this.add(backButton);

        backButton.addClickHandler(event -> {
            this.remove(userTable);
            this.remove(backButton);
            InputPanel ipanel = new InputPanel();
            ipanel.init();
            RootPanel.get("Panel").add(ipanel);
        });

    }

}
