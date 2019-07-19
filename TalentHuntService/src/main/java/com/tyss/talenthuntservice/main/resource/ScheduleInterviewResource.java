package com.tyss.talenthuntservice.main.resource;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.talenthuntservice.main.binding.DeleteRequestSuccessMessage;
import com.tyss.talenthuntservice.main.binding.PostRequestSuccessMessage;
import com.tyss.talenthuntservice.main.binding.PutRequestSuccessMessage;
import com.tyss.talenthuntservice.main.binding.Requirement;
import com.tyss.talenthuntservice.main.binding.ScheduleInterview;
import com.tyss.talenthuntservice.main.entity.RequirementEntity;
import com.tyss.talenthuntservice.main.entity.ScheduleInterviewEntity;
import com.tyss.talenthuntservice.main.service.RequirementService;
import com.tyss.talenthuntservice.main.service.ScheduleInterviewService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ScheduleInterviewResource {
	@Autowired
	private ScheduleInterviewService service;

	@GetMapping(value = "/schedule/getAll", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ScheduleInterview>> getAllCandidate() {
		List<ScheduleInterview> candidateList = null;
		// invoke service class method
		candidateList = service.getAllScheduleInterview();
		// return response object with list object
		return new ResponseEntity<List<ScheduleInterview>>(candidateList, HttpStatus.OK);
	}

	@GetMapping(value = "/schedule/scheduleByID/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ScheduleInterview> getCandidateById(@PathVariable Integer id) {
		ScheduleInterviewEntity entity = null;
		ScheduleInterview requirement = null;
		// get candidate details by id
		entity = service.getScheduleInterviewById(id);
		// convert entity to candidate object
		requirement = new ScheduleInterview();
		BeanUtils.copyProperties(entity, requirement);
		// return response object with candidate object
		return new ResponseEntity<ScheduleInterview>(requirement, HttpStatus.OK);
	}

	@PostMapping(value = "/schedule/saveSchedule", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PostRequestSuccessMessage> insertCandidateDetails(@RequestBody ScheduleInterview candidate) {
		Integer count = 0;
		String msg = null;
		PostRequestSuccessMessage prsm = null;
		// invoke service class method
		count = service.saveScheduleInterview(candidate);
		// return resonse object with msg
		msg = count == 0 ? "Candidate details are not saved" : "Candidate details are saved";
		// create post msg object
		prsm = new PostRequestSuccessMessage();
		prsm.setMsg(msg);
		return new ResponseEntity<PostRequestSuccessMessage>(prsm, HttpStatus.OK);
	}

	@PutMapping(value = "/schedule/updateSchedule/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PutRequestSuccessMessage> updateCandidateDetailsById(@RequestBody ScheduleInterview candidate,
			@PathVariable Integer id) {
		Integer count = 0;
		String msg = null;
		PutRequestSuccessMessage prsm = null;
		// invoke service class method
		count = service.updateScheduleInterviewById(candidate, id);
		// return resonse object with msg
		msg = count == 0 ? "Candidate details are not updated" : "Candidate details are updated";
		// create post msg object
		prsm = new PutRequestSuccessMessage();
		prsm.setMsg(msg);
		return new ResponseEntity<PutRequestSuccessMessage>(prsm, HttpStatus.OK);
	}

	@DeleteMapping(value = "/schedule/deleteSchedule/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DeleteRequestSuccessMessage> deleteCandidateDetailsById(@PathVariable Integer id) {
		Integer count = 0;
		String msg = null;
		DeleteRequestSuccessMessage drsm = null;
		// invoke service class method
		count = service.deleteScheduleInterviewById(id);
		// return response object with msg
		msg = count == 0 ? "Candidate details are not deleted" : "Candidate details are deleted";
		// create post msg object
		drsm = new DeleteRequestSuccessMessage();
		drsm.setMsg(msg);
		return new ResponseEntity<DeleteRequestSuccessMessage>(drsm, HttpStatus.OK);
	}
}
