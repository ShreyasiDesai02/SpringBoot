package com.Shreyasi.SpringSecurityClient.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Shreyasi.SpringSecurityClient.Entity.User;
import com.Shreyasi.SpringSecurityClient.Event.RegistrationCompleteEvent;
import com.Shreyasi.SpringSecurityClient.Model.UserModel;
import com.Shreyasi.SpringSecurityClient.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	 @Autowired
	 private ApplicationEventPublisher publisher;
	
	@PostMapping("register")
	public String register(@RequestBody UserModel userModel, final HttpServletRequest request) {
			User user = userService.registerUser(userModel);
			 publisher.publishEvent(new RegistrationCompleteEvent(
		                user,
		                applicationUrl(request)
		        ));
			return "Success";
	}
	
	@GetMapping("verifyRegistration")
	public String verifyRegistration(@RequestParam("token") String token) {
		String result = userService.validateVerificationToken(token);
		if(result.equalsIgnoreCase("valid")) {
			return "User verified successfully";
		}
		return "Bad user";
	} 
	
	//method to return the path i.e register(post)
	private String applicationUrl(HttpServletRequest request) {
        return "http://" +
                request.getServerName() +
                ":" +
                request.getServerPort() +
                request.getContextPath();
    }
}
