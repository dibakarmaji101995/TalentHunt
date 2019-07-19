package com.tyss.talenthuntservice.main.service;

import java.util.List;

import com.tyss.talenthuntservice.main.binding.Requirement;
import com.tyss.talenthuntservice.main.binding.ScheduleInterview;
import com.tyss.talenthuntservice.main.entity.ScheduleInterviewEntity;

public interface ScheduleInterviewService {
	public ScheduleInterviewEntity getScheduleInterviewById(Integer id) ;
	public Integer saveScheduleInterview(ScheduleInterview schedule);
	public Integer updateScheduleInterviewById(ScheduleInterview schedule, Integer id);
	public Integer deleteScheduleInterviewById(Integer id) ;
	public List<ScheduleInterview> getAllScheduleInterview() ;
}
