package com.Shreyasi.SpringSecurityClient.Event.Listner;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.Shreyasi.SpringSecurityClient.Entity.User;
import com.Shreyasi.SpringSecurityClient.Event.RegistrationCompleteEvent;
import com.Shreyasi.SpringSecurityClient.Service.UserService;

import lombok.extern.slf4j.Slf4j;

@Component //@Component is an annotation that allows Spring to detect our custom beans automatically.
	//In other words, without having to write any explicit code, Spring will:
    //Scan our application for classes annotated with @Component
    //Instantiate them and inject any specified dependencies into them
    //Inject them wherever needed

@Slf4j  //generate a logger field in the runtime
public class RegistrationCompleteEventListener implements
       ApplicationListener<RegistrationCompleteEvent>{
	
	@Autowired
    private UserService userService;
	
	@Override
	public void onApplicationEvent(RegistrationCompleteEvent event) {

		//Create the Verification Token for the User with Link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token,user);
        
        //Send Mail to user
        String url =
                event.getApplicationUrl()
                        + "/verifyRegistration?token="
                        + token;
        
        //sendVerificationEmail()
        log.info("Click the link to verify your account: {}",
                url);
	}

}
