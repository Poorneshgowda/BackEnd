package com.Spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Spring.Model.Plan;


public interface PlanRepository extends JpaRepository<Plan, Long> {

}
