package com.maowudi.chatproducer.util.quartz.job;

import org.quartz.*;

import java.util.Date;

public class TestInterruptableJob implements InterruptableJob {

    private JobKey jobKey;
    // 任务是否被打断标记
    private boolean _interrupted = false;

    @Override
    public void interrupt() throws UnableToInterruptJobException {
        System.out.println("---" + jobKey + "--被打断终止了！！！--");
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        jobKey = jobExecutionContext.getJobDetail().getKey();
        System.out.println(new Date().toLocaleString());
        System.out.println("执行job : " + jobKey);
    }
}
