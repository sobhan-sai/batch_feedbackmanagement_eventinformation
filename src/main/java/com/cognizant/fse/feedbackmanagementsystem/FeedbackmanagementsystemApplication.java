package com.cognizant.fse.feedbackmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class FeedbackmanagementsystemApplication {

	public static void main(String[] args) {
		System.out.println("In Main method");
		SpringApplication.run(FeedbackmanagementsystemApplication.class, args);
	}

}
