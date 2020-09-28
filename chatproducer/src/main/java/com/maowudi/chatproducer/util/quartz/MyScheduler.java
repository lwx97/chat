package com.maowudi.chatproducer.util.quartz;

import com.maowudi.chatproducer.util.quartz.job.TestInterruptableJob;
import com.maowudi.chatproducer.util.quartz.job.TestJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;


/**
 * 测试定时任务
 */
public class MyScheduler {

    public static void main(String[] args) throws InterruptedException, SchedulerException {
        MyScheduler.startJob(TestInterruptableJob.class);
        TimeUnit.MINUTES.sleep(1);
        MyScheduler.shutdownJob();
    }

    private static StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();

    private static Scheduler scheduler;
    /**
     * 启动job
     * @param job
     */
    public static void startJob(Class<? extends Job> job) throws SchedulerException {
        //创建调度器
        scheduler = stdSchedulerFactory.getScheduler();
        // 2、创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
        JobDetail jobDetail = JobBuilder.newJob(job).usingJobData("jobDetail1","用来测试").withIdentity("job1", "group1").build();
        // 3、构建Trigger实例,每隔1s执行一次
        Trigger trigger = TriggerBuilder.newTrigger().usingJobData("trigger1","这是jobDetail1的trigger").withIdentity("trigger1", "trigger1Group1")
                .startNow()//立即生效
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1)//每隔1s执行一次
                        .repeatForever()).build();//一直执行
        //4、执行
        scheduler.scheduleJob(jobDetail, trigger);
        System.out.println("--------scheduler start ! ------------");
        scheduler.start();
    }

    public static void shutdownJob() throws SchedulerException {
        scheduler.shutdown();
        System.out.println("--------scheduler shutdown ! ------------");
    }

    public static void interruptedJob(String jobKey) throws UnableToInterruptJobException {
        scheduler.interrupt(jobKey);
    }
}
