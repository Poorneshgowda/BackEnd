package com.Spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Model.Plan;
import com.Spring.Repository.PlanRepository;



@Service
public class PlanService {
	
	@Autowired
	private PlanRepository planRepo;

	public Plan insertPlan(Plan plan) {
		
		return planRepo.save(plan);
	}

	public List<Plan> getAllPlans() {
		// TODO Auto-generated method stub
		return planRepo.findAll();
	}
	

}
