package com.tyss.talenthuntservice.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.talenthuntservice.main.binding.ScheduleInterview;
import com.tyss.talenthuntservice.main.entity.ScheduleInterviewEntity;
import com.tyss.talenthuntservice.main.repository.ScheduleInterviewRepository;

@Service
public class ScheduleInterviewServiceImpl implements ScheduleInterviewService {
	@Autowired
    private ScheduleInterviewRepository repo;
	@Override
	public ScheduleInterviewEntity getScheduleInterviewById(Integer id) {
		Optional<ScheduleInterviewEntity> opt=null;
		ScheduleInterviewEntity entity=null;
		//get candidate details by id
		opt=repo.findById(id);
		//get candidateEntity object from Optional object
		entity=opt.get();
		//return entity object
		return entity;
	}

	@Override
	public Integer saveScheduleInterview(ScheduleInterview schedule) {
		ScheduleInterviewEntity entity=null;
		Integer count=0;
		//convert candidate object to entity object
		entity=new ScheduleInterviewEntity();
		BeanUtils.copyProperties(schedule, entity);
		//save candidate details
		entity=repo.save(entity);
		count=entity==null?0:1;
		//return the count
		return count;
	}

	@Override
	public Integer updateScheduleInterviewById(ScheduleInterview schedule, Integer id) {
		Integer count=0;
		// update candidate details
		System.out.println(schedule);
		count=repo.updateScheduleInterviewByScheduleId(schedule.getCandidateName(),schedule.getEmail(),schedule.getCctc(),schedule.getEctc(),
				                                       schedule.getGender(),schedule.getCurrentOrg(),schedule.getScheDate(),schedule.getTotalExperience(),
				                                       schedule.getNoticePeriod(),schedule.getStack(),schedule.getReleventExp(),schedule.getLocation(),
				                                       schedule.getContactNumber(),schedule.getReadyToRelocate(),schedule.getInterviewPanel(),id);
		
		return count;
	}

	@Override
	public Integer deleteScheduleInterviewById(Integer id) {
		Integer count=0;
		// delete candidate details by id
		count=repo.deleteScheduleInterviewByScheduleId(id);
		//return count
		return count;
	}

	@Override
	public List<ScheduleInterview> getAllScheduleInterview() {
		List<ScheduleInterview> scheduleList=new ArrayList<ScheduleInterview>();
		List<ScheduleInterviewEntity> entityList=null;
		// get all candidate details
		entityList=repo.findAll();
		//convert entityList to candidateList
		entityList.forEach(entity->{
			//crete candidate class object
			ScheduleInterview schedule=new ScheduleInterview();
			BeanUtils.copyProperties(entity, schedule);
			//add cadidate object to list object
			scheduleList.add(schedule);
		});
		//return candidateList
		return scheduleList;
	}
	
}
