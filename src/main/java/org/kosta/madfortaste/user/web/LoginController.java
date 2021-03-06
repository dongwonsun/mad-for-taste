package org.kosta.madfortaste.user.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.madfortaste.user.domain.User;
import org.kosta.madfortaste.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "login")
	public String login(String id, String password, HttpServletRequest req) {
		if (!(id == null || id.equals("")) 	&& !(password == null || password.equals(""))) {
			loginService.login(id, password, req);
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value = "reLogin")
	public String reLogin(HttpSession session, HttpServletRequest req) {
		User user = (User) session.getAttribute("member");
		if(user==null)
			user = (User) session.getAttribute("owner");
		if(user!=null)
			loginService.reLogin(user, session, req);
		return "redirect:/";
	}
}
