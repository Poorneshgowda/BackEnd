package com.Spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Model.Claim;
import com.Spring.Model.Member;
import com.Spring.Service.ClaimService;


@CrossOrigin(origins = {"http://localhost:3001"})
@RestController
@RequestMapping("/claim")
public class ClaimController {
	
	@Autowired
	private ClaimService claimService;
	
	@GetMapping("/getClaim")
	public List<Claim> getAllClaims(){
		List<Claim> claims = claimService.getAllClaims();
		return claims;
		
	}
	
	@GetMapping("/{id}")
	public Claim getClaimDetailsById(@PathVariable("id") Long id) {
		Claim claim = claimService.getClaimDetailsById(id);
		return claim;
		
	}
	
	@PostMapping("/addClaim")
	public ResponseEntity<Claim> saveClaim(@RequestBody Claim claim) {
		Claim claim1 = claimService.createClaim(claim);
		return new ResponseEntity<Claim>(claim1, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteId(@PathVariable("id") Long id) {
		 claimService.deleteClaimById(id);
		
	
		
	}
}
