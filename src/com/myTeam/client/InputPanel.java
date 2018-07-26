package com.myTeam.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.myTeam.shared.CategoryDTO;
import com.myTeam.shared.TeamDTO;
import com.myTeam.shared.UserDTO;

import java.util.List;

public class InputPanel extends VerticalPanel {

    MyTeamServiceAsync mtAsync = GWT.create(MyTeamService.class);
    private List<TeamDTO> teamList;
    private List<CategoryDTO> categoryList;


    void init() {

        ListBox catListBox = new ListBox();
        ListBox teamListBox = new ListBox();
        catListBox.setSelectedIndex(1);


        mtAsync.getCategories(new AsyncCallback<List<CategoryDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                GWT.log("Error while getting category list from server!");
            }

            @Override
            public void onSuccess(List<CategoryDTO> result) {
                setCategoryList(result);
                for (int i = 0; i < categoryList.size(); i++) {
                    catListBox.addItem(getCategoryList().get(i).getCat_name());
                }
            }
        });

        catListBox.addChangeHandler(event -> {
                    teamListBox.clear();
                    int cat_index = catListBox.getSelectedIndex();
                    int cat_index_id = getCategoryList().get(cat_index).getPk_cat_id();

                    mtAsync.getTeamswithCategory(cat_index_id, new AsyncCallback<List<TeamDTO>>() {
                        @Override
                        public void onFailure(Throwable caught) {
                            GWT.log("Error while getting team list from server!");
                        }

                        @Override
                        public void onSuccess(List<TeamDTO> result) {
                            setTeamList(result);
                            for (int i = 0; i < teamList.size(); i++) {
                                teamListBox.addItem(getTeamList().get(i).getName());
                            }
                        }
                    });
                }
        );


        FlexTable ft = new FlexTable();
        ft.setCellSpacing(5);
        Button submit = new Button("Submit");
        TextBox nameTB = new TextBox();
        TextBox surnameTB = new TextBox();
        TextBox cityTB = new TextBox();

        RadioButton rb_male = new RadioButton("Male", "Male");
        RadioButton rb_female = new RadioButton("Female", "Female");
        FlowPanel gender = new FlowPanel();
        gender.add(rb_male);
        gender.add(rb_female);

        rb_male.addClickHandler(event -> {
            rb_female.setValue(false);
            rb_male.setValue(true);
        });

        rb_female.addClickHandler(event -> {
            rb_male.setValue(false);
            rb_female.setValue(true);
        });


        submit.addClickHandler(event -> {

            String genderText = (rb_female.getValue()) ? rb_female.getText() : rb_male.getText();
            int selectedTeamIndex = teamListBox.getSelectedIndex();
            int teamId = teamList.get(selectedTeamIndex).getPk_team_id();

            UserDTO userDTO = new UserDTO();
            userDTO.setName(nameTB.getValue());
            userDTO.setSurname(surnameTB.getValue());
            userDTO.setCity(cityTB.getValue());
            userDTO.setGender(genderText);
            userDTO.setFk_team_id(teamId);

            mtAsync.sendInformation(userDTO, new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    GWT.log("Error while sending information to the server!");
                }

                @Override
                public void onSuccess(Void result) {
                    Window.alert("User added !");
                }
            });


        });


        Button resultButton = new Button("Show Results");
        ft.setWidget(1, 1, new Label("Name :"));
        ft.setWidget(1, 2, nameTB);
        ft.setWidget(2, 1, new Label("Surname :"));
        ft.setWidget(2, 2, surnameTB);
        ft.setWidget(3, 1, new Label("City :"));
        ft.setWidget(3, 2, cityTB);
        ft.setWidget(4, 1, new Label("Gender :"));
        ft.setWidget(4, 2, gender);
        ft.setWidget(5, 1, new Label("Category :"));
        ft.setWidget(5, 2, catListBox);
        ft.setWidget(6, 1, new Label("Team :"));
        ft.setWidget(6, 2, teamListBox);
        ft.setWidget(7, 3, submit);
        ft.setWidget(7, 2, resultButton);
        ft.setCellSpacing(5);
        ft.setStyleName("flexTable");
        this.add(ft);

        resultButton.addClickHandler(event -> {
            this.remove(ft);
            ResultPanel rp = new ResultPanel();
            rp.init();
            RootPanel.get("Panel").add(rp);
        });

    }


    public List<CategoryDTO> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryDTO> categoryList) {
        this.categoryList = categoryList;
    }

    public void setTeamList(List<TeamDTO> teamList) {
        this.teamList = teamList;
    }

    public List<TeamDTO> getTeamList() {
        return teamList;
    }

}




