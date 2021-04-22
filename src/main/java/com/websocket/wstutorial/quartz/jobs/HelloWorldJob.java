package com.websocket.wstutorial.quartz.jobs;

import com.websocket.wstutorial.quartz.info.TimerInfo;
import com.websocket.wstutorial.service.WsService;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldJob implements Job {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldJob.class);
    private final WsService wsService;

    @Autowired
    public HelloWorldJob(WsService wsService) {
        this.wsService = wsService;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        TimerInfo info = (TimerInfo) jobDataMap.get(HelloWorldJob.class.getSimpleName());

        LOG.info("My callback data is '{}'", info.getCallbackData());
        wsService.notifyFrontend(info.getCallbackData());
    }
}
