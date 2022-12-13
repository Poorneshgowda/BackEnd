package com.Spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Model.Claim;
import com.Spring.Repository.ClaimRepository;

@Service
public class ClaimService {
	
	@Autowired
	private ClaimRepository claimRepo;

	public List<Claim> getAllClaims() {
		// TODO Auto-generated method stub
		List<Claim> claims = claimRepo.findAll();
		return claims ;
	}

	public Claim getClaimDetailsById(Long id) {
		// TODO Auto-generated method stub
		Claim claim =  claimRepo.findById(id).get();
		return claim;
	}

	public Claim createClaim(Claim claim) {
		// TODO Auto-generated method stub
		return claimRepo.save(claim);
	}

	public void deleteClaimById(Long id) {
		claimRepo.deleteById(id);
		
	}

	
	


}
