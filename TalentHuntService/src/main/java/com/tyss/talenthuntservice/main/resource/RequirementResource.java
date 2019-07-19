package com.tyss.talenthuntservice.main.resource;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.tyss.talenthuntservice.main.entity.RequirementEntity;
import com.tyss.talenthuntservice.main.service.RequirementService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class RequirementResource {
	@Autowired
	private RequirementService service;

	@GetMapping(value = "/requi/getAll", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Requirement>> getAllCandidate() {
		List<Requirement> candidateList = null;
		// invoke service class method
		candidateList = service.getAllRequirement();
		// return response object with list object
		return new ResponseEntity<List<Requirement>>(candidateList, HttpStatus.OK);
	}

	@GetMapping(value = "/requi/requirementByID/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Requirement> getCandidateById(@PathVariable Integer id) {
		RequirementEntity entity = null;
		Requirement requirement = null;
		// get candidate details by id
		entity = service.getRequirementById(id);
		// convert entity to candidate object
		requirement = new Requirement();
		BeanUtils.copyProperties(entity, requirement);
		// return response object with candidate object
		return new ResponseEntity<Requirement>(requirement, HttpStatus.OK);
	}

	@PostMapping(value = "/requi/saveRequirement", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PostRequestSuccessMessage> insertCandidateDetails(@RequestBody Requirement candidate) {
		Integer count = 0;
		String msg = null;
		PostRequestSuccessMessage prsm = null;
		// invoke service class method
		count = service.saveRequirement(candidate);
		// return resonse object with msg
		msg = count == 0 ? "Requirement details are not saved" : "Requirement details are saved";
		// create PostRequestSuccessMessage object
		prsm = new PostRequestSuccessMessage();
		prsm.setMsg(msg);
		return new ResponseEntity<PostRequestSuccessMessage>(prsm, HttpStatus.OK);
	}

	@PutMapping(value = "/requi/updateRequirement/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PutRequestSuccessMessage> updateCandidateDetailsById(@RequestBody Requirement candidate,
			@PathVariable Integer id) {
		Integer count = 0;
		String msg = null;
		PutRequestSuccessMessage prsm = null;
		// invoke service class method
		count = service.updateRequirementById(candidate, id);
		// return resonse object with msg
		msg = count == 0 ? "Requirement details are not updated" : "Requirement details are updated";
		// create PostRequestSuccessMessage object
		prsm = new PutRequestSuccessMessage();
		prsm.setMsg(msg);
		return new ResponseEntity<PutRequestSuccessMessage>(prsm, HttpStatus.OK);
	}

	@DeleteMapping(value = "/requi/deleteRequirement/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DeleteRequestSuccessMessage> deleteCandidateDetailsById(@PathVariable Integer id) {
		Integer count = 0;
		String msg = null;
		DeleteRequestSuccessMessage drsm = null;
		// invoke service class method
		count = service.deleteRequirementById(id);
		// return response object with msg
		msg = count == 0 ? "Requirement details are not deleted" : "Requirement details are deleted";
		// create PostRequestSuccessMessage object
		drsm = new DeleteRequestSuccessMessage();
		drsm.setMsg(msg);
		return new ResponseEntity<DeleteRequestSuccessMessage>(drsm, HttpStatus.OK);
	}
}
