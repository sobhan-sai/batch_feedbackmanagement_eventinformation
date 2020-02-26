package com.cognizant.fse.feedbackmanagementsystem.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.cognizant.fse.feedbackmanagementsystem.entity.EventInformation;

public class EventInformationProcessor implements ItemProcessor<EventInformation,EventInformation> {

	private static final Logger log = LoggerFactory.getLogger(EventInformationProcessor.class);

	  @Override
	  public EventInformation process(final EventInformation eventInformation) throws Exception {
		  System.out.println("In Event Information Processor");
	    return eventInformation;
	  }

}
