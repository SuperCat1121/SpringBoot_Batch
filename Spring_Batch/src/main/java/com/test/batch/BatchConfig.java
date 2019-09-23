package com.test.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.core.repository.support.SimpleJobRepository;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Bean
	public MapJobRepositoryFactoryBean jobRepository() {
		MapJobRepositoryFactoryBean jobRepository = new MapJobRepositoryFactoryBean();
		//jobRepository.setTransactionManager();
		return jobRepository;
	}
	
	@Bean
	public SimpleJobLauncher jobLauncher(JobRepository jobRepository) {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(jobRepository);
		return jobLauncher;
	}
	
	@Bean
	public Job simpleJob(JobBuilderFactory jobFactory, Step simpleStep) {
		return jobFactory.get("simpleJob")
				.start(simpleStep)
				.build();
	}
	
	@Bean
	public Step simpleStep(StepBuilderFactory stepFactory, Tasklet tasklet) {
		return stepFactory.get("simpleStep")
				.tasklet(tasklet).build();
	}
	
	@Bean
	public Tasklet tasklet() {
		return new tasklet();
	}

}
