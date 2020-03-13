package com.yys.storemanager.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName LogUtil
 * @Description TODO
 * @Author YYS
 * @Date 2020/3/13 13:54
 * @Version 1.0
 */
public class LogUtil {
    protected static final Logger logger = LoggerFactory.getLogger(LogUtil.class);

    public static void error(String className, String Message, Exception e) {
        logger.error(className, Message, e);
    }
}
