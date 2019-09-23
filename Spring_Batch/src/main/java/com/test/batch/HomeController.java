package com.test.batch;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@EnableBatchProcessing
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws JobParametersInvalidException 
	 * @throws JobInstanceAlreadyCompleteException 
	 * @throws JobRestartException 
	 * @throws JobExecutionAlreadyRunningException 
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BatchConfig.class);
		//test config = ctx.getBean(test.class);
		//System.out.println(config.getName());
		
		Step s = ctx.getBean(Step.class);
		System.out.println(s);
		
		Job simpleJob = ctx.getBean(Job.class);
		System.out.println(simpleJob);
		
		JobLauncher joblauncher = (JobLauncher) ctx.getBean(JobLauncher.class);
		try {
			JobExecution execution = joblauncher.run(simpleJob, new JobParameters());
			System.out.println(execution);
			logger.info("런쳐 실행 로그");
			//System.out.println("Job Exit Status : " + execution.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "home";
	}
	
}
