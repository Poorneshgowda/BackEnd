package com.Spring.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Comman.ApiResponse;
import com.Spring.Dto.Login;
import com.Spring.Model.Member;
import com.Spring.Repository.MemberRepository;
import com.Spring.Service.MemberService;


@CrossOrigin(origins = {"http://localhost:3001"})
@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberRepository memberRepo;
	
	// FETCH MEMBER
	@GetMapping("/getMember")
	public ResponseEntity<List<Member>> findAllEmployees() {
		List<Member> member = memberService.getAllEmployees();
		return new ResponseEntity<List<Member>>(member, HttpStatus.OK);
	}
	
	// ADD MEMBER
	@PostMapping("/addMember")
	public ResponseEntity<Member> createEmployee(@RequestBody Member member) {
		Member member1 = memberService.createMember(member);
		return new ResponseEntity<Member>(member1, HttpStatus.OK);
	}

	// Delete member
	@DeleteMapping("/deletemember/{id}")
	public ResponseEntity<String> deleteMembereByID(@PathVariable("id") Long id) {
		Optional<Member> optional = memberRepo.findById(id);
		if (!optional.isPresent())
			throw new RuntimeException("Invalid ID");
		if (optional.isPresent())
			memberRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	// Update info of particular member
	@PutMapping("/updatemem/{id}")
	public Member updateMember(@PathVariable("id") Long id, @RequestBody Member member) {
		Optional<Member> optional = memberRepo.findById(id);
		if (!optional.isPresent())
			throw new RuntimeException("Invalid ID");

		Member member1 = optional.get();

		member1.setMemberName(member.getMemberName());
		member1.setDob(member.getDob());
		member1.setCity(member.getCity());
		member1.setState(member.getState());
		member1.setEmailId(member.getEmailId());
		member1.setContactNo(member.getContactNo());
		member1.setUsername(member.getUsername());
		member1.setPassword(member.getPassword());

		return memberRepo.save(member1);

	}
	
	//login
    @PostMapping("/loginCheck")
    public ResponseEntity<ApiResponse> loginCheck(@RequestBody Login login)
    {   
        String status= null;
        
        ApiResponse apiResponse=memberService.LoginCheck(login);
        
        if(apiResponse!=null)
        {
        	status="Successfully loged in!";
        }
        else {
        	status="Pls Check Your userName and password";
        }
        return new  ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
    }
    

}
