package com.Spring.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Comman.ApiResponse;
import com.Spring.Dto.Login;
import com.Spring.Model.Member;
import com.Spring.Repository.MemberRepository;
import com.Spring.Util.jwtUtils;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepo;
	
		@Autowired
		jwtUtils jwtUtils;
		
	   public Member createMember(Member member) {
	        return memberRepo.save(member);

	   }
	   
	   public List<Member> getAllEmployees(){ 
		   return memberRepo.findAll(); 
	   }
	
	   public ApiResponse LoginCheck(Login login) {
	        ApiResponse apiResponse=new ApiResponse();
	        Member member=memberRepo.findByusernameAndPassword(login.getUsername(), login.getPassword());
	        if(member==null)
	        {
	        	apiResponse.setData("Username and password is Wrong");
	        }
	        else {
	        	
	      
			String token=jwtUtils.generateJwt(member);
	        	//apiResponse.setData(token);
			
			Map<String, Object> data = new HashMap<>();
			data.put("accessToken", token);
			apiResponse.setData(data);
			
	        }
	        return apiResponse;
	   }
	

}
