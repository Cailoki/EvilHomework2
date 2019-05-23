package com.evilhomework_khorvat;

import com.evilhomework_khorvat.interfaces.UI;

public final class UserInterface<T extends UI> {
    private T ui;

    public UserInterface(T userInterface) {
        this.ui = userInterface;
    }

    public UserInterface drawInterface(){
        ui.drawUserInterface();
        return this;
    }
}
