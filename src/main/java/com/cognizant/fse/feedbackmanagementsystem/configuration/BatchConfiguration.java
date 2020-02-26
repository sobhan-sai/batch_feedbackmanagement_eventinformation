package com.cognizant.fse.feedbackmanagementsystem.configuration;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.poi.PoiItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.cognizant.fse.feedbackmanagementsystem.entity.EventInformation;
import com.cognizant.fse.feedbackmanagementsystem.listener.EventInformationMapper;
import com.cognizant.fse.feedbackmanagementsystem.processor.EventInformationProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public DataSource dataSource;

	@Bean
	ItemReader<EventInformation> excelStudentReader() {
		System.out.println("In Excel Student Reader");
		PoiItemReader<EventInformation> reader = new PoiItemReader<>();
		reader.setResource(new ClassPathResource("outreach event information.xlsx"));
		reader.setLinesToSkip(1);
		reader.setRowMapper(excelRowMapper());
		return reader;
	}

	private RowMapper<EventInformation> excelRowMapper() {
		return new EventInformationMapper();
	}

	@Bean
	ItemProcessor<EventInformation, EventInformation> excelStudentProcessor() {
		System.out.println("In Excel Student Processor");
		return new EventInformationProcessor();
	}

	@Bean
	ItemWriter<EventInformation> excelStudentWriter() {
		JdbcBatchItemWriter<EventInformation> writer = new JdbcBatchItemWriter<EventInformation>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<EventInformation>());
		writer.setSql(
				"INSERT INTO event_information (event_id, base_location, benificiary_name, council_name, event_name, event_description, event_date, employee_id, employee_name, volunteer_hours, travel_hours, lives_impacted, business_unit, status,  iiep_category  ) VALUES (:eventId, :baseLocation, :benificiaryName, :councilName, :eventName, :eventDescription, :eventDate, :employeeId, :employeeName, :volunteerHours, :travelHours, :livesImpacted, :businessUnit, :status, :iiepCategory)");
		writer.setDataSource(dataSource);
		return writer;
	}

	@Bean
	Step excelFileToDatabaseStep(ItemReader<EventInformation> excelStudentReader,
			ItemProcessor<EventInformation, EventInformation> excelStudentProcessor,
			ItemWriter<EventInformation> excelStudentWriter, StepBuilderFactory stepBuilderFactory) {
		System.out.println("In Excel Step");
		return stepBuilderFactory.get("excelFileToDatabaseStep").<EventInformation, EventInformation>chunk(1)
				.reader(excelStudentReader).processor(excelStudentProcessor).writer(excelStudentWriter).build();
	}

	@Bean
	Job excelFileToDatabaseJob(JobBuilderFactory jobBuilderFactory,
			@Qualifier("excelFileToDatabaseStep") Step excelStudentStep) {
		System.out.println("In Excel Job");
		return jobBuilderFactory.get("excelFileToDatabaseJob").incrementer(new RunIdIncrementer())
				.flow(excelStudentStep).end().build();
	}

	/*
	 * @Bean public FlatFileItemReader<EventInformation> reader() {
	 * FlatFileItemReader<EventInformation> reader = new
	 * FlatFileItemReader<EventInformation>(); reader.setResource(new
	 * ClassPathResource("outreach event information.xlsx"));
	 * reader.setLineMapper(new DefaultLineMapper<EventInformation>() { {
	 * setLineTokenizer(new DelimitedLineTokenizer() { { setNames( new String[] {
	 * "eventId", "baseLocation", "benificiaryName", "councilName", "eventName",
	 * "eventDescription", "eventDate", "employeeId", "employeeName",
	 * "volunteerHours", "travelHours", "livesImpacted", "businessUnit", "status",
	 * "iiepCategory" }); } }); setFieldSetMapper(new
	 * BeanWrapperFieldSetMapper<EventInformation>() { {
	 * setTargetType(EventInformation.class); } }); } }); return reader;
	 */
	/*
	 * return new
	 * FlatFileItemReaderBuilder<EventInformation>().name("eventInformationReader")
	 * .resource(new
	 * ClassPathResource("outreach_event_information.csv")).linesToSkip(1).delimited
	 * () .names(new String[] { "eventId","baseLocation", "benificiaryName",
	 * "councilName", "eventName", "eventDescription", "eventDate", "employeeId",
	 * "employeeName", "volunteerHours", "travelHours", "livesImpacted",
	 * "businessUnit", "status", "iiepCategory" })
	 * 
	 * .fieldSetMapper(new BeanWrapperFieldSetMapper<EventInformation>() { {
	 * setTargetType(EventInformation.class); } }).build();
	 */
	/* } */

	/*
	 * @Bean public EventInformationProcessor processor() {
	 * 
	 * return new EventInformationProcessor(); }
	 */
	/*
	 * @Bean public JdbcBatchItemWriter<EventInformation> writer() {
	 * JdbcBatchItemWriter<EventInformation> writer = new
	 * JdbcBatchItemWriter<EventInformation>();
	 * writer.setItemSqlParameterSourceProvider(new
	 * BeanPropertyItemSqlParameterSourceProvider<EventInformation>());
	 * writer.setSql(
	 * "INSERT INTO event_information (event_id, base_location, benificiary_name, council_name, event_name, event_description, event_date, employee_id, employee_name, volunteer_hours, travel_hours, lives_impacted, business_unit, status,  iiep_category  ) VALUES (:eventId, :baseLocation, :benificiaryName, :councilName, :eventName, :eventDescription, :eventDate, :employeeId, :employeeName, :volunteerHours, :travelHours, :livesImpacted, :businessUnit, :status, :iiepCategory)"
	 * ); writer.setDataSource(dataSource); return writer;
	 * 
	 * 
	 * return new JdbcBatchItemWriterBuilder<EventInformation>()
	 * .itemSqlParameterSourceProvider(new
	 * BeanPropertyItemSqlParameterSourceProvider<>())
	 * .sql("INSERT INTO event_information (event_id, base_location, benificiary_name, council_name, event_name, event_description, event_date, employee_id, employee_name, volunteer_hours, travel_hours, lives_impacted, business_unit, status,  iiep_category  ) VALUES (:eventId, :baseLocation, :benificiaryName, :councilName, :eventName, :eventDescription, :eventDate, :employeeId, :employeeName, :volunteerHours, :travelHours, :livesImpacted, :businessUnit, :status,  :iiepCategory )"
	 * ) .dataSource(dataSource) .build();
	 * 
	 * }
	 * 
	 * @Bean
	 * 
	 * @Scheduled(fixedRate = 2000) public Job
	 * importEventInformationJob(JobCompletionNotificationListener listener, Step
	 * step1) { return
	 * jobBuilderFactory.get("importEventInformationJob").incrementer(new
	 * RunIdIncrementer()).listener(listener) .flow(step1).end().build(); }
	 * 
	 * @Bean public Step step1(JdbcBatchItemWriter<EventInformation> writer) {
	 * return stepBuilderFactory.get("step1").<EventInformation,
	 * EventInformation>chunk(10).reader(reader())
	 * .processor(processor()).writer(writer).build(); }
	 */
}
