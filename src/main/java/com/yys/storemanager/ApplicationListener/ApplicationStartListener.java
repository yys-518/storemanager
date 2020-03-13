package com.yys.storemanager.ApplicationListener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.util.ResourceUtils;

import javax.servlet.annotation.WebListener;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * 监听spring boot项目启动
 */
@WebListener
public class ApplicationStartListener implements ApplicationListener {

    public void reloadLog4j() {
        //获取跟目录
        File path = null;
        try {
            //设置log日志文件夹
            path = new File(ResourceUtils.getURL("src/main/resources").getPath());
            File logs = new File(path.getAbsolutePath(), "logs");
            if (!logs.exists()) {
                //logs.mkdirs();
            }
            // System.out.println("path:" + new File(ResourceUtils.getURL("src/main/resources/logs").getPath()).toString());
            //设置系统变量，便于在log4j2-spring.xml配置log文件路径
            System.setProperty("log:rootDir", new File(ResourceUtils.getURL("src/main/resources/logs").getPath()) + "");
            //设置照片上传文件夹
            File upload = new File(path.getAbsolutePath(), "static/image/upload/");
            if (!upload.exists()) {
                upload.mkdirs();
            }
            // System.out.println("upload url:" + upload.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        // 容器启动完成之后load
        if (applicationEvent instanceof ContextRefreshedEvent) {
            if (((ContextRefreshedEvent) applicationEvent).getApplicationContext().getParent() == null) {
                reloadLog4j();
            }
        }
    }
}
