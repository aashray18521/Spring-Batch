package org.projects.batchprocessing.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListenerImpl implements JobExecutionListener {

    private Logger logger = LoggerFactory.getLogger(JobCompletionNotificationListenerImpl.class);
    @Override
    public void beforeJob(JobExecution jobExecution) {
        logger.info("Job Started");
//        JobExecutionListener.super.beforeJob(jobExecution);
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus()== BatchStatus.COMPLETED)
            logger.info("Job Completed");
//        JobExecutionListener.super.afterJob(jobExecution);
    }
}
