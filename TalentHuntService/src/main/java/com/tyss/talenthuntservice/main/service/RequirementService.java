package com.tyss.talenthuntservice.main.service;

import java.util.List;

import com.tyss.talenthuntservice.main.binding.Requirement;
import com.tyss.talenthuntservice.main.entity.RequirementEntity;

public interface RequirementService {
	public RequirementEntity getRequirementById(Integer id) ;
	public Integer saveRequirement(Requirement candidate);
	public Integer updateRequirementById(Requirement requirement, Integer id);
	public Integer deleteRequirementById(Integer id) ;
	public List<Requirement> getAllRequirement() ;
}
