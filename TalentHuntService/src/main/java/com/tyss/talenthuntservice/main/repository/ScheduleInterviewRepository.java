package com.tyss.talenthuntservice.main.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tyss.talenthuntservice.main.entity.ScheduleInterviewEntity;

@Repository
public interface ScheduleInterviewRepository extends JpaRepository<ScheduleInterviewEntity, Serializable> {
    @Transactional
	@Modifying
	@Query(value = "UPDATE ScheduleInterviewEntity SET candidateName=:candidateName,"
	        + "email=:email,cctc=:cctc,ectc=:ectc,"
			+ "gender=:gender,currentOrg=:currentOrg,scheDate=:scheDate,"
			+ "totalExperience=:totalExperience,noticePeriod=:noticePeriod,stack=:stack,"
			+ "releventExp=:releventExp,location=:location,contactNumber=:contactNumber,"
			+ "readyToRelocate=:readyToRelocate," 
			+ "interviewPanel=:interviewPanel where scheduleId=:scheduleId")
	public Integer updateScheduleInterviewByScheduleId(String candidateName, String email, Double cctc, Double ectc,
			String gender, String currentOrg, String scheDate, Integer totalExperience, Integer noticePeriod,
			String stack, Integer releventExp, String location, Long contactNumber, String readyToRelocate,
			String interviewPanel, Integer scheduleId);

	@Transactional
	@Modifying
	@Query(value = "DELETE from ScheduleInterviewEntity where scheduleId=:scheduleId")
	public Integer deleteScheduleInterviewByScheduleId(Integer scheduleId);
}
