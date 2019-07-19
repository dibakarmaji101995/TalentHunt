package com.tyss.talenthuntservice.main.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.talenthuntservice.main.binding.Requirement;
import com.tyss.talenthuntservice.main.entity.RequirementEntity;
import com.tyss.talenthuntservice.main.repository.RequirementRepository;

@Service
public class RequirementServiceImpl implements RequirementService {
	@Autowired
    private RequirementRepository repo;
	@Override
	public RequirementEntity getRequirementById(Integer id) {
		Optional<RequirementEntity> opt=null;
		RequirementEntity entity=null;
		//get candidate details by id
		opt=repo.findById(id);
		//get candidateEntity object from Optional object
		entity=opt.get();
		//return entity object
		return entity;
	}
	@Override
	public Integer saveRequirement(Requirement requirement) {
		RequirementEntity entity=null;
		Integer count=0;
		//convert candidate object to entity object
		entity=new RequirementEntity();
		BeanUtils.copyProperties(requirement, entity);
		//save candidate details
		entity=repo.save(entity);
		count=entity==null?0:1;
		//return the count
		return count;
	}
	@Override
	public Integer updateRequirementById(Requirement requirement, Integer id) {
		Integer count=0;
		//update candidate details
		count=repo.updateRequirementByRequirementId(requirement.getClientName(),requirement.getNoOfPosition(),requirement.getStack(),requirement.getDesg(),
				                                requirement.getExpRequired(),requirement.getJobDesc(),requirement.getLocation(),requirement.getClosingDate(),id);
		
		return count;
	}
	@Override
	public Integer deleteRequirementById(Integer id) {
		Integer count=0;
		// delete candidate details by id
		count=repo.deleteRequirementByRequirementId(id);
		//return count
		return count;
	}
	@Override
	public List<Requirement> getAllRequirement() {
		List<Requirement> candidateList=new ArrayList<Requirement>();
		List<RequirementEntity> entityList=null;
		// get all candidate details
		entityList=repo.findAll();
		//convert entityList to candidateList
		entityList.forEach(entity->{
			//crete candidate class object
			Requirement candidate=new Requirement();
			BeanUtils.copyProperties(entity, candidate);
			//add cadidate object to list object
			candidateList.add(candidate);
		});
		//return candidateList
		return candidateList;
	}
}
