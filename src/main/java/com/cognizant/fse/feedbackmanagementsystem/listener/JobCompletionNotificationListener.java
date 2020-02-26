package com.cognizant.fse.feedbackmanagementsystem.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.fse.feedbackmanagementsystem.entity.EventInformation;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {
	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	  public void afterJob(JobExecution jobExecution) {
	    if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
	      log.info("!!! JOB FINISHED! Time to verify the results");

	      jdbcTemplate.query("SELECT event_id, base_location, benificiary_name, council_name, event_name, event_description, event_date, employee_id, employee_name, volunteer_hours, travel_hours, lives_impacted, business_unit, status,  iiep_category FROM event_information",
	        (rs, row) ->new EventInformation(		
	          rs.getString(0),
	          rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getFloat(9),rs.getFloat(10),rs.getInt(11),rs.getString(12),rs.getString(13),rs.getString(14))
	      ).forEach(event -> log.info("Found <" + event + "> in the database."));
	    }
	  }
}
