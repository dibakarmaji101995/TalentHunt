package com.tyss.talenthuntservice.main.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;



@Data
@XmlRootElement(name = "schedule-inteview")
@XmlAccessorType(XmlAccessType.FIELD)
public class ScheduleInterview {
	private Integer scheduleId;
     private String candidateName;
     private String email;
     private Double cctc;
     private Double ectc;
     private String gender;
     private String currentOrg;
     private String scheDate;
     private Integer totalExperience;
     private Integer noticePeriod;
     private String stack;
     private Integer releventExp;
     private String location;
     private Long contactNumber;
     private String readyToRelocate;
     private String interviewPanel;
}
