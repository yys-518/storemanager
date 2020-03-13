package com.yys.storemanager.Bean;

import java.io.Serializable;

public class Login implements Serializable {
    private String userName;
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
