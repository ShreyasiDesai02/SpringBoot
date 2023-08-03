package com.Shreyasi.SpringSecurityClient.Service;

import com.Shreyasi.SpringSecurityClient.Entity.User;
import com.Shreyasi.SpringSecurityClient.Model.UserModel;

public interface UserService {

	User registerUser(UserModel userModel);

	void saveVerificationTokenForUser(String token, User user);

	String validateVerificationToken(String token);

}