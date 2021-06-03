package com.websocket.wstutorial.quartz.playground;

import com.websocket.wstutorial.quartz.info.TimerInfo;
import com.websocket.wstutorial.quartz.jobs.HelloWorldJob;
import com.websocket.wstutorial.quartz.timeservice.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PlaygroundService {

    private final SchedulerService scheduler;

    @Autowired
    public PlaygroundService(SchedulerService scheduler) {
        this.scheduler = scheduler;
    }

    public void runHelloWorldJob() {
        TimerInfo info = new TimerInfo();
        info.setTotalFireCount(5);
        info.setRemainingFireCount(info.getTotalFireCount());
        info.setRunForever(false);
        info.setRepeatIntervalMs(1500);
        info.setInitialOffsetMs(1000);
        info.setCallbackData("This is my message! " + "\uD83D\uDE03");

        scheduler.schedule(HelloWorldJob.class, info);
    }
}
