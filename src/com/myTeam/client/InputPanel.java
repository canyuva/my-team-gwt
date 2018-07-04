package com.myTeam.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.List;

public class InputPanel extends VerticalPanel {

    MyTeamServiceAsync mtAsync = GWT.create(MyTeamService.class);
    private List<String> teamList;
    private List<String> categoryList;
    int selectedIndex = 1;

    void init() throws Exception {

        ListBox catListBox = new ListBox();
        ListBox teamListBox = new ListBox();
        catListBox.setSelectedIndex(1);


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
                    try {
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
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );



        FlexTable ft = new FlexTable();
        ft.setCellSpacing(5);
        Button submit = new Button("Submit");
        TextBox nameTB = new TextBox();
        TextBox surnameTB = new TextBox();
        TextBox cityTB = new TextBox();

        RadioButton rb_male = new RadioButton("male", "Male");
        RadioButton rb_female = new RadioButton("female", "Female");
        FlowPanel gender = new FlowPanel();
        gender.add(rb_male);
        gender.add(rb_female);

        GWT.log(""+teamListBox.getSelectedIndex());


        submit.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {

                String genderText="";
                if(rb_female.isChecked()){
                    genderText = "Female";
                }
                if(rb_male.isChecked()){
                    genderText = "Male";
                }



                int selectedTeamIndex = teamListBox.getSelectedIndex() + 1;

                GWT.log(nameTB.getValue()+" "+surnameTB.getValue()+" "+cityTB.getValue()+" "+genderText+
                " "+selectedTeamIndex+" ");

                mtAsync.sendInformation(nameTB.getValue(), surnameTB.getValue(),
                        cityTB.getValue(), genderText, selectedTeamIndex, new AsyncCallback<String>() {
                            @Override
                            public void onFailure(Throwable caught) {
                                System.out.println("Error while inserting..");
                            }

                            @Override
                            public void onSuccess(String result) {
                                System.out.println(result);
                            }
                        });
            }
        });

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




