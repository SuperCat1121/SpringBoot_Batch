package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SimpleScheduler {
	
	@Autowired
	private Job job;
	@Autowired
	private JobLauncher myJobLauncher;

	@Scheduled(cron = "0 03 18 * * *")
	public void schedulerTest() throws Exception {
		myJobLauncher.run(job, new JobParameters());
	}

}
