package com.test.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class tasklet implements Tasklet {
	private static final Logger logger = LoggerFactory.getLogger(tasklet.class);
	public tasklet() {
		System.out.println("tasklet 생성자");
	}
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		System.out.println("tasklet 실행되라");
		return RepeatStatus.FINISHED;
	}
}
