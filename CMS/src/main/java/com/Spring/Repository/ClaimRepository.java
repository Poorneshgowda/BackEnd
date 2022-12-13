package com.Spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Spring.Model.Claim;


public interface ClaimRepository extends JpaRepository<Claim, Long> {

}
