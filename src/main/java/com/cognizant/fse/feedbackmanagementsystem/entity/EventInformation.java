package com.cognizant.fse.feedbackmanagementsystem.entity;

import java.io.Serializable;

public class EventInformation implements Serializable {
	
	private static final long serialVersionUID = -7277554273171265767L;
	
	private String eventId;
	private String benificiaryName;
	public String getBenificiaryName() {
		return benificiaryName;
	}
	public void setBenificiaryName(String benificiaryName) {
		this.benificiaryName = benificiaryName;
	}
	private String councilName;
	private String eventName;
	private String eventDescription;
	//@DateTimeFormat(pattern = "dd-MM-yy")
	private String eventDate;
	private Integer employeeId;
	private String employeeName;
	private Float volunteerHours;
	private Float travelHours;
	private Integer livesImpacted;
	private String businessUnit;
	private String status;
	private String iiepCategory;
	private String baseLocation;
	
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getBaseLocation() {
		return baseLocation;
	}
	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}
//	public String getBenificiaryName() {
//		return benificiaryName;
//	}
//	public void setBenificiaryName(String benificiaryName) {
//		this.benificiaryName = benificiaryName;
//	}
	public String getCouncilName() {
		return councilName;
	}
	public void setCouncilName(String councilName) {
		this.councilName = councilName;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Float getVolunteerHours() {
		return volunteerHours;
	}
	public void setVolunteerHours(Float volunteerHours) {
		this.volunteerHours = volunteerHours;
	}
	public Float getTravelHours() {
		return travelHours;
	}
	public void setTravelHours(Float travelHours) {
		this.travelHours = travelHours;
	}
	public Integer getLivesImpacted() {
		return livesImpacted;
	}
	public void setLivesImpacted(Integer livesImpacted) {
		this.livesImpacted = livesImpacted;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIiepCategory() {
		return iiepCategory;
	}
	public void setIiepCategory(String iiepCategory) {
		this.iiepCategory = iiepCategory;
	}
	
	
	public EventInformation() {
		super();
	}
	public EventInformation(String eventId, String baseLocation, String benificiaryName, String councilName,
			String eventName, String eventDescription, String eventDate, Integer employeeId, String employeeName,
			Float volunteerHours, Float travelHours, Integer livesImpacted, String businessUnit, String status,
			String iiepCategory) {
		super();
		this.eventId = eventId;
		this.baseLocation = baseLocation;
		this.benificiaryName = benificiaryName;
		this.councilName = councilName;
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.eventDate = eventDate;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.volunteerHours = volunteerHours;
		this.travelHours = travelHours;
		this.livesImpacted = livesImpacted;
		this.businessUnit = businessUnit;
		this.status = status;
		this.iiepCategory = iiepCategory;
	}
	@Override
	public String toString() {
		return "EventInformation [eventId=" + eventId + ", baseLocation=" + baseLocation + ", benificiaryName="
				+ benificiaryName + ", councilName=" + councilName + ", eventName=" + eventName + ", eventDescription="
				+ eventDescription + ", eventDate=" + eventDate + ", employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", volunteerHours=" + volunteerHours + ", travelHours=" + travelHours
				+ ", livesImpacted=" + livesImpacted + ", businessUnit=" + businessUnit + ", status=" + status
				+ ", iiepCategory=" + iiepCategory + "]";
	}

}
