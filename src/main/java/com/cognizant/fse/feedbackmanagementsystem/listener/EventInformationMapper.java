
package com.cognizant.fse.feedbackmanagementsystem.listener;

import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.support.rowset.RowSet;

import com.cognizant.fse.feedbackmanagementsystem.entity.EventInformation;

public class EventInformationMapper implements RowMapper<EventInformation> {

	@Override
	public EventInformation mapRow(RowSet rs) throws Exception {
		EventInformation eventInformation = new EventInformation();
		eventInformation.setEventId(rs.getColumnValue(0));
		eventInformation.setBaseLocation(rs.getColumnValue(1));
		eventInformation.setBenificiaryName(rs.getColumnValue(2));
		eventInformation.setCouncilName(rs.getColumnValue(3));
		eventInformation.setEventName(rs.getColumnValue(4));
		eventInformation.setEventDescription(rs.getColumnValue(5));
		eventInformation.setEventDate(rs.getColumnValue(6));
		eventInformation.setEmployeeId((int) (Math.round(Float.parseFloat(rs.getColumnValue(7)))));
		eventInformation.setEmployeeName(rs.getColumnValue(8));
		eventInformation.setVolunteerHours(Float.valueOf(rs.getColumnValue(9)));
		eventInformation.setTravelHours(Float.valueOf(rs.getColumnValue(10)));
		eventInformation.setLivesImpacted((int) (Math.round(Float.parseFloat(rs.getColumnValue(11)))));
		eventInformation.setBusinessUnit(rs.getColumnValue(12));
		eventInformation.setStatus(rs.getColumnValue(13));
		eventInformation.setIiepCategory(rs.getColumnValue(14));
		return eventInformation;
	}

}