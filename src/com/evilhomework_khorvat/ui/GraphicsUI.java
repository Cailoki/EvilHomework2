package com.evilhomework_khorvat.ui;

import com.evilhomework_khorvat.UserInteraction;
import com.evilhomework_khorvat.interfaces.UI;

public class GraphicsUI implements UI {
    private static final String TITLE_TEXT =
            "------------------------------------------------------------------\n" +
            "------------------- Welcome to animal shelter! -------------------\n" +
            "------------------------------------------------------------------";
    private static final String MENU_TEXT =
            "******** Enter number for the action you want to perform. ********\n" +
            "********** 1. Feed Animals          2. Restock Storage  **********\n" +
            "********** 3. Generate Food Report  4. Exit Application **********";

    public void drawUserInterface(){
        drawTitle();
    }

    private void drawTitle() {
        System.out.println(TITLE_TEXT);
        onTitleDrawn();
    }

    private void onTitleDrawn(){
        drawMenu();
    }

    public void drawMenu() {
        System.out.println(MENU_TEXT);
    }
}
