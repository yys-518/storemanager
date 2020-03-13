package com.yys.storemanager.Controller;

import com.yys.storemanager.Service.LoginService;
import com.yys.storemanager.Util.Constants;
import com.yys.storemanager.Util.JsonUtil;
import com.yys.storemanager.Util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public String Login(@RequestParam(name = "data") String data) {

        try {
            String UserName = JsonUtil.getStringValue(data, "user");
            String PassWord = JsonUtil.getStringValue(data, "password");
            int count = loginService.getLogin(UserName, PassWord);
            if (count > 0) {
                return "homePage.html";
            }
        } catch (Exception e) {
            LogUtil.error(this.getClass().getName(), "Login()", e);
        }
        return Constants.ERROR;

    }
}
