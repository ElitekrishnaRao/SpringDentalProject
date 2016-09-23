package com.dentalapp.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dentalapp.services.LoginDAO;

@Controller
public class LoginController {

	@Autowired	
	private LoginDAO loginService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		return "index";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String detailsPage(ModelMap model,Principal principal,HttpSession httpSession) {	
		httpSession.setAttribute("userName", principal.getName());
		return "contact";
	}

	@RequestMapping(value = "/sinUp", method = RequestMethod.POST)
	public String newUser(ModelMap model,@RequestParam String userName,@RequestParam String password) {
		model.addAttribute("message", "Click login to continue");
		loginService.createNewUser(userName, password);
		return "index";
	}

	/**
	 * @return the loginService
	 */
	public LoginDAO getLoginService() {
		return loginService;
	}

	/**
	 * @param loginService the loginService to set
	 */
	public void setLoginService(LoginDAO loginService) {
		this.loginService = loginService;
	}
}
