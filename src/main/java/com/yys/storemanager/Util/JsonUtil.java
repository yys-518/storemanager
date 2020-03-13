package com.yys.storemanager.Util;

import com.alibaba.fastjson.JSONObject;

public class JsonUtil {

    /**
     * data:json
     * key:
     *
     * @param data
     * @param key
     * @return
     */
    public static String getStringValue(String data, String key) {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(data);
        return jsonObject.getString(key);
    }
}
