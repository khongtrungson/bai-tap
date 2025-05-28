package com.kts.snw;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.time.Instant;
import java.util.Date;

/**
 * Hello world!
 */
public class App{
    public static void main(String[] args) throws SchedulerException{
        JobDetail jobDetail = JobBuilder.newJob(PrintDataJob.class)
                                        .withIdentity("app", "group1")
                                        .build();
        Trigger trigger = TriggerBuilder.newTrigger()
                                        .withIdentity("trigger1", "group1")
                                        .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                                        .build();

        Trigger trigger2 = TriggerBuilder.newTrigger()
                                         .startAt(Date.from(Instant.now().plusSeconds(10)))
                                         .withIdentity("trigger2", "group1")
                                         .withSchedule(SimpleScheduleBuilder.simpleSchedule().withRepeatCount(0))
                                         .build();

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger2);
        scheduler.shutdown(true);

    }
}
