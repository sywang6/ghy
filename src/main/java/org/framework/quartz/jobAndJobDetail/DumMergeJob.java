package org.framework.quartz.jobAndJobDetail;

import org.quartz.*;

public class DumMergeJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey key = context.getJobDetail().getKey();
        //获取JobDetail和Trigger合并后的datamap,如果key相同, Trigger的数据会覆盖JobDetail的数据
        JobDataMap dataMap = context.getMergedJobDataMap();

        String jobSays = dataMap.getString("t1");
        String myFloatValue = dataMap.getString("t2");

        System.out.println("Instance " + key + " of DumbJob says: " + jobSays + ", and val is: " + myFloatValue);
    }
}
