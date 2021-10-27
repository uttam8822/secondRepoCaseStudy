package com.service.serviceDentalDatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.serviceDentalDatabase.model.DentalVisionUser;
import com.service.serviceDentalDatabase.model.LifeUser;
import com.service.serviceDentalDatabase.repo.DentalVisionRepo;
import com.service.serviceDentalDatabase.service.DentalVisionRegistration;

@RestController
public class DentalVisionService {

	@Autowired
	private DentalVisionRegistration service;
    @Autowired
    private DentalVisionRepo repo;
	@PostMapping("/registerdentalvisionservice")
	@CrossOrigin(origins = "http://localhost:4200")
	public DentalVisionUser resisterUserService(@RequestBody DentalVisionUser user) throws Exception {
		 String tempAadhar=user.getAadhar();
		if(user.getFirstName()==null)
			throw new Exception("Error");
		if(user.getLastName()==null) throw new Exception("Error");	
		if(user.getEmail()==null) throw new Exception("Error");	
		if(user.getPan()==null) throw new Exception("Error");	
		if(user.getAddress()==null) throw new Exception("Error");	
		if(user.getZip()==null) throw new Exception("Error");	
		if(user.getCity()==null) throw new Exception("Error");	
		if(user.getState()==null) throw new Exception("Error");	
		if(user.getContact()==null) throw new Exception("Error");	
		if(user.getDateOfBirth()==null) throw new Exception("Error");	
		if(user.getOccupation()==null) throw new Exception("Error");	
		if(user.getIncome()==null) throw new Exception("Error");	
		if(user.getGender()==null) throw new Exception("Error");
		if(user.getMember()==null) throw new Exception("Error");
		if(user.getSelectPlane()==null) throw new Exception("Error");
		if(user.getCancellingInsurance()==null) throw new Exception("Error");
		if(user.getAnyEyeDisease()==null) throw new Exception("Error");
		if(user.getGroupInsurance()==null) throw new Exception("Error");
		if(user.getTobacco()==null) throw new Exception("Error");
		if(user.getOralOperation()==null) throw new Exception("Error");
		if(user.getLastDentalCkeck()==null) throw new Exception("Error");
		if(user.getAnyCavity()==null) throw new Exception("Error");
		if(user.getWearGlasses()==null) throw new Exception("Error");
		if(user.getAnyEyeDisease()==null) throw new Exception("Error");
		if(user.getAnyEyeOperation()==null) throw new Exception("Error");
	        if(tempAadhar != null && !"".equals(tempAadhar))
	        {
		     DentalVisionUser userobj=service.fetchUserByAadhar(tempAadhar);
		     if(userobj != null) {
		    	 throw new Exception("user with" +tempAadhar + "id already exist");
		     }
	        }
		DentalVisionUser userObj = null;
		userObj = service.saveUser(user);
		return userObj;
	}
	@PutMapping("/statusdv/{aadhar}")
	@CrossOrigin(origins = "http://localhost:4200")
	public DentalVisionUser updateStatus(@RequestBody DentalVisionUser user)throws Exception{
		user.setStatus("Yes");
		DentalVisionUser userObj;
		
		userObj=service.saveUser(user);			
		return userObj;
	    
	}
	@PutMapping("/status1dv/{aadhar}")
	@CrossOrigin(origins = "http://localhost:4200")
	public DentalVisionUser updateStatus1(@RequestBody DentalVisionUser user)throws Exception{
		user.setStatus("No");
		DentalVisionUser userObj;
		
		userObj=service.saveUser(user);			
		return userObj;
	    
	}
	@GetMapping("/getdentalvisiondata")
	@CrossOrigin(origins="http://localhost:4200")
	List<DentalVisionUser> getUser(){
		return repo.findAll();
	}
}