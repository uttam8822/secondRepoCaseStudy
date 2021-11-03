package com.service.serviceDentalDatabase.service;

import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.service.serviceDentalDatabase.model.LifeUser;
import com.service.serviceDentalDatabase.repo.LifeScheduleRepo;

@Service
public class LifeScheduleService {

@Autowired
private LifeScheduleRepo repo;
@Autowired
private EmailSendService service1;
Logger log = LoggerFactory.getLogger(LifeScheduleService.class);


@Scheduled(fixedRate = 30000)
public void updateStatus() {
	
	List<LifeUser> users= repo.findAll();
	for(LifeUser user : users) {
	//LifeUser user = new LifeUser();
 /* @Trasactinal
  @Modifying
  @Query("UPDATE LifeUser SET status='Yes' Where status=null and tobacco='Yes' and hivIssue='No'")*/
		if(user.getStatus()==null) {
			if("No".equals(user.getHivIssue()) && "Yes".equals(user.getTobacco())) {
			System.out.println(user.getTobacco());
		      user.setStatus("Yes");
		      service1.sendSimpleEmail(user.getEmail(),"Dear User, "+user.getFirstName()+"\nYour application has been approved for Life service"+"\n In case if you have any query please feel free to connect with us"+"\n\n\n\n\nImpetus Technologies (India) Pvt. Ltd."+"\nSDF No. K-13 to 16, NSEZ"+"\nPhase-II Noida-201305 (U.P.)" + 
	    				"\nPhone : " + 
	    				"+91-120-4018100"+"\nEmail : support@impetus.com"
	    		,"Application Approved");

			}
	       repo.save(user);
		}
	}
 
}
/*@Scheduled(initialDelay = 15000 , fixedDelay=15000)
public void fetchLifeData() {
	List<LifeUser> users= repo.findAll();
	log.info("users : {}", users);
}*/

}
