package com.myTeam.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.List;

public class InputPanel extends VerticalPanel {

    MyTeamServiceAsync mtAsync = GWT.create(MyTeamService.class);
    private List<String> teamList;
    private List<String> categoryList;
    int selectedIndex = 1;

    void init() {

        ListBox catListBox = new ListBox();
        ListBox teamListBox = new ListBox();

        mtAsync.getCategories(new AsyncCallback<List<String>>() {
            @Override
            public void onFailure(Throwable caught) {
                GWT.log("Error while getting category list!");
            }

            @Override
            public void onSuccess(List<String> result) {
                setCategoryList(result);
                for (int i = 0; i < categoryList.size(); i++) {
                    catListBox.addItem(getCategoryList().get(i));
                }
            }
        });

        catListBox.addChangeHandler(event -> {

                    teamListBox.clear();
                    selectedIndex = catListBox.getSelectedIndex();
                    selectedIndex = selectedIndex + 1;
                    mtAsync.getTeamswithCategory(selectedIndex, new AsyncCallback<List<String>>() {
                        @Override
                        public void onFailure(Throwable caught) {
                            GWT.log("Error while getting team list!");
                        }

                        @Override
                        public void onSuccess(List<String> result) {
                            setTeamList(result);
                            for (int i = 0; i < teamList.size(); i++) {
                                teamListBox.addItem(getTeamList().get(i));
                            }
                            GWT.log(result.toString());
                        }
                    });
                }

        );


        FlexTable ft = new FlexTable();
        ft.setCellSpacing(5);

        TextBox nameTB = new TextBox();
        TextBox surnameTB = new TextBox();
        TextBox cityTB = new TextBox();
        Button submit = new Button("Submit");
        RadioButton rb_male = new RadioButton("sex", "Male");
        RadioButton rb_female = new RadioButton("sex", "Female");
        FlowPanel gender = new FlowPanel();
        gender.add(rb_male);
        gender.add(rb_female);


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


        this.add(ft);
    }


    public List<String> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<String> teamList) {
        this.teamList = teamList;
    }

    public List<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }
}




