package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.testBiz;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private testBiz biz;
	@Autowired
	private Job job;
	@Autowired
	private JobLauncher myJobLauncher;
	
	@RequestMapping("/")
	public String test(Model model) throws Exception {
		model.addAttribute("list", biz.selectList());
		
		//myJobLauncher.run(job, new JobParameters());
		
		return "index";
	}
}
