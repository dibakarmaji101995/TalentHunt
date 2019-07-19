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
@Table(name="REQUIREMENT_MASTER")
public class RequirementEntity {
	@Id
	@Column(name="REQ_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer requirementId;
	
	@Column(name = "CLIENT_NAME")
    private String clientName;
    
	@Column(name="NO_OF_POSITION")
	private Integer noOfPosition;
    
    @Column(name = "STACK")
    private String stack;
    
    @Column(name = "DESG")
    private String desg;
    
    @Column(name = "EXP_REQIRED")
    private Integer expRequired;
    
    @Column(name = "JOB_DESC")
    private String jobDesc;
    
    @Column(name="LOCATION")
    private String location;
    
    @Column(name = "CLOSING_DATE")
    private String closingDate;
}
