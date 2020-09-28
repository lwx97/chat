package com.maowudi.chatproducer.util;

import com.maowudi.chatproducer.util.quartz.MyScheduler;
import com.maowudi.chatproducer.util.quartz.job.TestJob;
import lombok.SneakyThrows;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.stereotype.Component;

@Component
public class SpringStart implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        MyScheduler.startJob(TestJob.class);
    }
}
