package com.example.demo.dataSourceConfig;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author 罗曼蒂克
 * @Date Created in 9:51   2018/6/6
 */
@Component
public class ScheduledTasks {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Scheduled(fixedRate = 1000)//指定间隔时间
    public void reportCurrentTime() {//要执行的功能代码
        //执行调度方法

        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
