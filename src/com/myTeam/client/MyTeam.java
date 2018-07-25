package com.myTeam.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class MyTeam implements EntryPoint {



    @Override
    public void onModuleLoad() {
        Label logo = new Label("Which Team Are You Fan Of ?");
        logo.setStyleName("logoText");
        InputPanel ipanel = new InputPanel();
        ipanel.init();
        RootPanel.get("Panel").add(logo);
        RootPanel.get("Panel").add(ipanel);

    }

}





