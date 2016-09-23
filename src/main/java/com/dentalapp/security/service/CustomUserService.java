package com.dentalapp.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.dentalapp.dao.beans.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dentalapp.services.LoginDAO;

@Service
public class CustomUserService implements UserDetailsService {

	@Autowired	
	private LoginDAO loginService;

	public CustomUser loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = loginService.validateCredentials(username);
		CustomUser customUser =null;
		if(user!=null){
			customUser	= new CustomUser();
			customUser.setUsername(user.getEmailId());
			customUser.setPassword(user.getPassword());

			List<Role> roles = new ArrayList<Role>();
			Role role = new Role();
			role.setName("ROLE_USER");
			roles.add(role);

			customUser.setAuthorities(roles);
		}
		return customUser;
	}

	public LoginDAO getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginDAO loginService) {
		this.loginService = loginService;
	}

}
