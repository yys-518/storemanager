package com.yys.storemanager.Service;

import com.yys.storemanager.Mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;

    public Integer getLogin(String userName, String passWord) {
        return loginMapper.getLogin(userName, passWord);
    }
}
