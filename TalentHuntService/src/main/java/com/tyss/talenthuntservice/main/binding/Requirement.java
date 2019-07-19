package com.tyss.talenthuntservice.main.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "REQUIREMENT")
@XmlAccessorType(XmlAccessType.FIELD)
public class Requirement {
	private Integer requirementId;
    private String clientName;
	private Integer noOfPosition;
    private String stack;
    private String desg;
    private Integer expRequired;
    private String jobDesc;
    private String location;
    private String closingDate;
}
