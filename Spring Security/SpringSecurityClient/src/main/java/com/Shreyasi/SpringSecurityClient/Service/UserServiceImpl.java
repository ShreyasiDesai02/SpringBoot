package com.Shreyasi.SpringSecurityClient.Service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Shreyasi.SpringSecurityClient.Entity.User;
import com.Shreyasi.SpringSecurityClient.Entity.VerificationToken;
import com.Shreyasi.SpringSecurityClient.Model.UserModel;
import com.Shreyasi.SpringSecurityClient.Repository.UserRepository;
import com.Shreyasi.SpringSecurityClient.Repository.VerificationTokenRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passEncoder;
	
	@Autowired
	private VerificationTokenRepository verificationTokenRepo;
	
	@Override
	
	public User registerUser(UserModel userModel) {
		User user = new User();
		user.setEmail(userModel.getEmail());
		user.setFirstName(userModel.getFirstName());
		user.setLastName(user.getLastName());
		user.setRole("User");
		user.setPassword(passEncoder.encode(userModel.getPassword()));
		
		userRepo.save(user);
		return user;
	}

	@Override
	public void saveVerificationTokenForUser(String token, User user) {
		VerificationToken verificationToken = new VerificationToken(user,token);
		verificationTokenRepo.save(verificationToken);
		
	}

	//checking the token that we are getting exists in database or not
	@Override
	public String validateVerificationToken(String token) {
		VerificationToken verificationToken = verificationTokenRepo.findByToken(token);
		
		if (verificationToken == null) {
            return "invalid";
		}
            
		//get user from verification token and check expiration time
            User user = verificationToken.getUser();
            Calendar cal = Calendar.getInstance();
            
            //if expiration time exceeds token is deleted
            if ((verificationToken.getExpirationTime().getTime()
                    - cal.getTime().getTime()) <= 0) {
                verificationTokenRepo.delete(verificationToken);
                return "expired";
                
            }
                return "valid";
            }
		
	
	}		




