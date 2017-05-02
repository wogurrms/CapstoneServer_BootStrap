package kr.ac.hansung.cse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	@RequestMapping(value = "/fagerstrom", method = RequestMethod.GET)
	public String fagerstrom() {
		return "fagerstrom";
	}
	@RequestMapping(value = "/mynicotine", method = RequestMethod.GET)
	public String mynicotine() {
		return "mynicotine";
	}
	
}
