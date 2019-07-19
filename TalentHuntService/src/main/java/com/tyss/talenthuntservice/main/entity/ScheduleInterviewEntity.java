package com.tyss.talenthuntservice.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "SCHEDULE_INTERVIEW_MASTER")
public class ScheduleInterviewEntity {
	@Id
	@Column(name = "SCHEDULE_ID", unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer scheduleId;

	@Column(name = "CANDIDATE_NAME")
	private String candidateName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "CCTC")
	private Double cctc;

	@Column(name = "ECTC")
	private Double ectc;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "CURRENT_ORGANIZATION")
	private String currentOrg;

	@Column(name = "SCHEDULE_DATE")
	private String scheDate;

	@Column(name = "TOTAL_EXP")
	private Integer totalExperience;

	@Column(name = "NOTICE_PERIOD")
	private Integer noticePeriod;

	@Column(name = "STACK")
	private String stack;

	@Column(name = "RELEVENT_EXP")
	private Integer releventExp;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "CONTACT_NUMBER")
	private Long contactNumber;
	
	@Column(name = "READY_TO_RELOCATE")
	private String readyToRelocate;
	
	@Column(name="INTERVIEW_PANEL")
	private String interviewPanel;
}
