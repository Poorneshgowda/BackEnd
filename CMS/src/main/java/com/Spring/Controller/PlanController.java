package com.Spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Model.Plan;
import com.Spring.Service.PlanService;


@CrossOrigin(origins = {"http://localhost:3001"})
@RestController
@RequestMapping("/plan")
public class PlanController {
	
	@Autowired
	private PlanService planService;
	

	@PostMapping("/addPlan")
	public ResponseEntity<Plan> insertPlan(@RequestBody Plan plan) {

		Plan plan1 = planService.insertPlan(plan);

		return new ResponseEntity<Plan>(plan1, HttpStatus.OK);

	}
	
	
	@GetMapping("/getPlan")
	public ResponseEntity<List<Plan>> findAllPlans() {

		List<Plan> plan = planService.getAllPlans();
		return new ResponseEntity<List<Plan>>(plan, HttpStatus.OK);
	}


}
