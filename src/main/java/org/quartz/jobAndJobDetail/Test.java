package org.quartz.jobAndJobDetail;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Test {
    public static void main(String[] args) throws SchedulerException {
        //创建一个scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();


        //创建一个Trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .usingJobData("t1", "tv1")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3)
                        .repeatForever()).build();
        trigger.getJobDataMap().put("t2", "tv2");

        JobDetail job = JobBuilder.newJob(DumJob.class)
                .withIdentity("myJob", "group1") // name "myJob", group "group1"
                .usingJobData("jobSays", "Hello World!")
                .usingJobData("myFloatValue", 3.141f)
                .build();

        JobDetail mergeJob = JobBuilder.newJob(DumMergeJob.class)
                .withIdentity("myJob2", "group1") // name "myJob", group "group1"
                .usingJobData("t1", "Hello World!")
                .usingJobData("t2", "3.141f")
                .build();

        JobDetail setJob = JobBuilder.newJob(DumSetJob.class)
                .withIdentity("myJob3", "group1") // name "myJob", group "group1"
                .usingJobData("jobSays", "Hello World!")
                .usingJobData("myFloatValue", 3.141f)
                .build();

        //scheduler.scheduleJob(job,trigger);  //1.从JobDetail里面获取数据
        //scheduler.scheduleJob(mergeJob,trigger); //2.JobDetail和Trigger合并后的datamap
        scheduler.scheduleJob(setJob,trigger);//3.通过set方法将JobDetail中的datamap数据设置到Job的属性中

        scheduler.start();
    }
}
