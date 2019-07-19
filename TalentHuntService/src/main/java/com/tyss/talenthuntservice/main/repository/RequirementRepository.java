package com.tyss.talenthuntservice.main.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tyss.talenthuntservice.main.entity.RequirementEntity;

@Repository
public interface RequirementRepository extends JpaRepository<RequirementEntity, Serializable> {
    @Transactional
	@Modifying
	@Query(value = "UPDATE RequirementEntity SET clientName=:clientName,"
			+ "noOfPosition=:noOfPosition,stack=:stack,desg=:desg,"
			+ "expRequired=:expRequired,jobDesc=:jobDesc,location=:location,"
			+ "closingDate=:closingDate where requirementId=:requirementId")
	public Integer updateRequirementByRequirementId(String clientName, Integer noOfPosition, String stack, String desg,
			Integer expRequired, String jobDesc, String location, String closingDate, Integer requirementId);

	@Transactional
	@Modifying
	@Query(value = "DELETE from RequirementEntity where requirementId=:id")
	public Integer deleteRequirementByRequirementId(Integer id);
}
