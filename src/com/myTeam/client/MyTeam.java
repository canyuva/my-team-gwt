package com.myTeam.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

public class MyTeam implements EntryPoint {



    @Override
    public void onModuleLoad() {
        InputPanel ipanel = new InputPanel();
        try {
            ipanel.init();
        } catch (Exception e) {
            e.printStackTrace();
        }

        RootPanel.get("Panel").add(ipanel);

    }

}





