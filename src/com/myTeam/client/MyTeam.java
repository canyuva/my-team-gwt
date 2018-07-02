package com.myTeam.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

public class MyTeam implements EntryPoint {



    @Override
    public void onModuleLoad() {
        InputPanel ipanel = new InputPanel();
        ipanel.init();
        //ipanel.add(new Button("asdsd"));

        RootPanel.get("Panel").add(ipanel);

    }

}





