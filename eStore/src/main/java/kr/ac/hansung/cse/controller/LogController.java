package kr.ac.hansung.cse.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LogController {
	// GET �޼ҵ� ó�� login ��ư�� ������ ���� ó�� display form
	// POST �޼ҵ� ó�� - ����ڰ� �Է��� ������ DB �� ���Ͽ� ���� : spring ���� �ڵ����� ó��
	@RequestMapping("/login")
	public String login(@RequestParam(value="error", required=false)String error, 
			@RequestParam(value="logout", required=false)String logout, Model model){
		if(error != null){
			model.addAttribute("error", "invalid Username and Password");
		}
		
		if(logout != null){
			model.addAttribute("logout","You have been logged out successfully!");
		}
		return "login";
	}
	
	// Logout - spring ���� logout ó���ϴ� ���(POSTó��), logout�Ȱ� �˷��ִ� ������(GET)
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		// Spring �� ���� ó���Ǵ� �κ� - ���� �α׾ƿ��� �ϴ°�
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
	}
	
	
}
