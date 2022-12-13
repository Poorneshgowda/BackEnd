package com.Spring.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Spring.Model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

	

	

	Member findByusernameAndPassword(String username, String password);




//	Member findByUserNameAndPassword(String username, String password);

//	Member findByUserNameAndPassword(String userName, String password);
	
	

}
