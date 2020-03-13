package com.yys.storemanager.Mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {
    Integer getLogin(String userName, String passWord);
}
